package ir.maktab.service;

import ir.maktab.data.domain.Specialist;
import ir.maktab.data.domain.SubService;
import ir.maktab.data.repository.SpecialistRepository;
import ir.maktab.data.repository.SubServiceRepository;
import ir.maktab.dto.SpecialistDto;
import ir.maktab.dto.SubServiceDto;
import ir.maktab.service.exception.DuplicatedEmailAddressException;
import ir.maktab.service.exception.InvalidPasswordException;
import ir.maktab.service.exception.NotFoundSpecialistException;
import ir.maktab.service.exception.NotFoundSubServiceException;
import ir.maktab.service.mapper.SpecialistMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Collectors;

@Service

public class SpecialistServiceImpl implements SpecialistService {
    private final SpecialistRepository specialistRepository;
    private final SpecialistMapper specialistMapper;
    private final SubServiceService subServiceService;
    private final SubServiceRepository subServiceRepository;

    public SpecialistServiceImpl(SpecialistRepository specialistRepository, SpecialistMapper specialistMapper, SubServiceService subServiceService, SubServiceRepository subServiceRepository) {
        this.specialistRepository = specialistRepository;
        this.specialistMapper = specialistMapper;
        this.subServiceService = subServiceService;
        this.subServiceRepository = subServiceRepository;
    }

    @Override
    public SpecialistDto saveNewSpecialist(SpecialistDto specialistDto) throws DuplicatedEmailAddressException {
        Optional<Specialist> optionallyEmail = specialistRepository.findByEmail(specialistDto.getEmail());
        if (optionallyEmail.isPresent()) {
            throw new DuplicatedEmailAddressException("This user exists... ");
        }
        specialistRepository.save(specialistMapper.toSpecialist(specialistDto));
        return specialistDto;
    }

    @Override
    public void updateSpecialistRate(SpecialistDto specialistDto, Double rate) {
        specialistRepository.save(specialistMapper.toSpecialist(specialistDto));
    }


    @Override
    public SpecialistDto findByEmail(String email) throws NotFoundSpecialistException {
        Optional<Specialist> byEmail = specialistRepository.findByEmail(email);
        if (byEmail.isPresent()) {
            return specialistMapper.toSpecialistDto(byEmail.get());
        }
        throw new NotFoundSpecialistException("specialist Is Not Available");

    }

    @Override
    public SpecialistDto loginSpecialist(SpecialistDto dto) throws NotFoundSpecialistException, InvalidPasswordException {
        Optional<Specialist> specialist = specialistRepository.findByEmail(dto.getEmail());
        if (specialist.isPresent()) {
            if (!specialist.get().getPassword().equals(dto.getPassword())) {
                throw new InvalidPasswordException("Password Is Incorrect ! Please Try Again...");
            } else {
                return specialistMapper.toSpecialistDto(specialist.get());
            }
        } else {
            throw new NotFoundSpecialistException("This Email Is Not Available ! Please Try Again... ");
        }
    }

    @Override
    public List<SpecialistDto> fetchAllSpecialist() {
        return specialistRepository.findAll()
                .stream()
                .map(specialistMapper::toSpecialistDto)
                .collect(Collectors.toList());
    }

    @Override
    public void updateSpecialist(SpecialistDto specialistDto) {
        specialistRepository.save(specialistMapper.toSpecialist(specialistDto));
    }

    @Override
    public void selectService(SpecialistDto dto) {
        specialistRepository.save(specialistMapper.toSpecialist(dto));
    }

    @Override
    public void selectServiceForSpecialist(SubServiceDto service, SpecialistDto specialistDto) {
        Optional<SubService> subService = subServiceRepository.findById(service.getId());
        Optional<Specialist> specialist = specialistRepository.findByEmail(specialistDto.getEmail());
        specialist.get().getServices().add(subService.get());
        specialistRepository.save(specialist.get());

    }

    @Override
    public void updateSpecialistWallet(SpecialistDto toSpecialistDto, Double wallet) {
        specialistRepository.save(specialistMapper.toSpecialist(toSpecialistDto));
    }

    @Override
    public void changePassword(SpecialistDto specialistDto) {
        Optional<Specialist> byEmail = specialistRepository.findByEmail(specialistDto.getEmail());
        Specialist specialist = byEmail.get();
        specialist.setPassword(specialistDto.getPassword());
        specialistRepository.save(specialist);
    }

}
