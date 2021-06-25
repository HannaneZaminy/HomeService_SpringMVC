package ir.maktab.service.mapper;

import ir.maktab.data.domain.Specialist;
import ir.maktab.dto.SpecialistDto;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class SpecialistMapperImpl implements SpecialistMapper {
    private final SubServiceMapper serviceMapper;

    public SpecialistMapperImpl(SubServiceMapper serviceMapper) {
        this.serviceMapper = serviceMapper;
    }


    @Override
    public Specialist toSpecialist(SpecialistDto specialistDto) {
        Specialist specialist = new Specialist();
        specialist.setPassword(specialistDto.getPassword());
        specialist.setRole(specialistDto.getRole());
        specialist.setSituation(specialistDto.getSituation());
        specialist.setId(specialistDto.getId());
        specialist.setName(specialistDto.getName());
        specialist.setWallet(specialistDto.getWallet());
        specialist.setImage(specialistDto.getImage());
        specialist.setRate(specialistDto.getRate());
       specialist.setServices(specialistDto.getServices().stream().map(serviceMapper::convertToSubService).collect(Collectors.toList()));
        specialist.setLastName(specialistDto.getLastName());
        specialist.setEmail(specialistDto.getEmail());

        specialist.setDate(specialistDto.getRegistrationDay());


        return specialist;
    }

    @Override
    public SpecialistDto toSpecialistDto(Specialist specialist) {
        SpecialistDto specialistDto = new SpecialistDto();
        specialistDto.setId(specialist.getId());
        specialistDto.setImage(specialist.getImage());
        specialistDto.setRate(specialist.getRate());
        specialistDto.setName(specialist.getName());
        specialistDto.setLastName(specialist.getLastName());
        specialistDto.setEmail(specialist.getEmail());
        specialistDto.setServices(specialist.getServices().stream().map(serviceMapper::covertToSubServiceDto).collect(Collectors.toList()));
        specialistDto.setPassword(specialist.getPassword());
        specialistDto.setRegistrationDay(specialist.getDate());
        specialistDto.setRole(specialist.getRole());
        specialistDto.setSituation(specialist.getSituation());
        specialistDto.setWallet(specialist.getWallet());


        return specialistDto;
    }
}
