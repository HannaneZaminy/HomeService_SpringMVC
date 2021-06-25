package ir.maktab.service.mapper;

import ir.maktab.data.domain.Service;
import ir.maktab.dto.ServiceDto;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class ServiceMapperImpl implements ServiceMapper {


    @Override
    public ServiceDto ToServiceDto(Service service) {
        ServiceDto serviceDto = new ServiceDto();
        serviceDto.setId(service.getId());
        serviceDto.setName(service.getName());
        return serviceDto;
    }

    @Override
    public Service ToService(ServiceDto serviceDto) {
        Service service = new Service();
        service.setId(serviceDto.getId());
        service.setName(serviceDto.getName());
        return service;
    }
}
