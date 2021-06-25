package ir.maktab.service;

import ir.maktab.data.domain.SubService;
import ir.maktab.data.repository.ServiceRepository;
import ir.maktab.data.repository.SubServiceRepository;
import ir.maktab.dto.SubServiceDto;
import ir.maktab.service.exception.DuplicatedServiceException;
import ir.maktab.service.exception.NotFoundServiceException;
import ir.maktab.service.exception.NotFoundSubServiceException;
import ir.maktab.service.mapper.ServiceMapper;
import ir.maktab.service.mapper.SubServiceMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SubServiceServiceImpl implements SubServiceService {
    private final ServiceRepository repository;
    private final ServiceMapper serviceMapper;
    private final SubServiceRepository subServiceRepository;
    private final SubServiceMapper subServiceMapper;

    public SubServiceServiceImpl(ServiceRepository repository, ServiceMapper serviceMapper, SubServiceRepository subServiceRepository, SubServiceMapper subServiceMapper) {
        this.repository = repository;
        this.serviceMapper = serviceMapper;
        this.subServiceRepository = subServiceRepository;
        this.subServiceMapper = subServiceMapper;
    }

    @Override
    public void saveNewSubService(SubServiceDto subServiceDto) throws DuplicatedServiceException, NotFoundServiceException {
        if (subServiceRepository.findByName(subServiceDto.getName()).isPresent()) {
            throw new DuplicatedServiceException("This Sub Service is duplicate,");
        }
        if (repository.findByName(subServiceDto.getService().getName()) == null) {
            throw new NotFoundServiceException("This Service Is Not Available!");
        }
        subServiceDto.setService(serviceMapper.ToServiceDto(repository.findByName(subServiceDto.getService().getName())));
        subServiceRepository.save(
                subServiceMapper.convertToSubService(subServiceDto));

    }

    @Override
    public void updateSubService(SubServiceDto dto) {
        subServiceRepository.save(subServiceMapper.convertToSubService(dto));

    }

    @Override
    public void deleteSubService(SubServiceDto dto) {
        subServiceRepository.delete(subServiceMapper.convertToSubService(dto));

    }

    @Override
    public SubServiceDto getSubService(SubServiceDto dto) {
        return null;
    }

    @Override
    public List<SubServiceDto> fetchAllSubServices() {
        return subServiceRepository.findAll()
                .stream().map(i -> subServiceMapper.covertToSubServiceDto(i))
                .collect(Collectors.toList());
    }



    @Override
    public SubServiceDto findByName(String name) throws NotFoundSubServiceException {
        Optional<SubService> subService = subServiceRepository.findByName(name);
        if (subService.isPresent()) {
            return subServiceMapper.covertToSubServiceDto(subService.get());
        }
        throw new NotFoundSubServiceException("Sub Service Not Found");
    }

    @Override
    public List<SubServiceDto> getSubServicesByServiceName(String service) {
    return subServiceRepository.findByServiceName(service).stream().map(subServiceMapper::covertToSubServiceDto).collect(Collectors.toList());
    }
}
