package ir.maktab.service;

import ir.maktab.data.repository.ServiceRepository;
import ir.maktab.dto.ServiceDto;
import ir.maktab.service.exception.DuplicatedServiceException;
import ir.maktab.service.mapper.ServiceMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServiceServiceImpl implements ServiceService {
    private final ServiceRepository serviceRepository;
    private final ServiceMapper serviceMapper;

    public ServiceServiceImpl(ServiceRepository serviceRepository, ServiceMapper serviceMapper) {
        this.serviceRepository = serviceRepository;
        this.serviceMapper = serviceMapper;
    }

    @Override
    public void saveNewService(ServiceDto serviceDto) throws DuplicatedServiceException {
        if (serviceRepository.findByName(serviceDto.getName()) != null) {
            throw new DuplicatedServiceException("This Service is Duplicate");
        } else {
            serviceRepository.save(serviceMapper.ToService(serviceDto));
        }
    }

    @Override
    public ServiceDto getService(ServiceDto dto) {
        return null;
    }

    @Override
    public void deleteService(ServiceDto dto) {
        serviceRepository.delete(serviceMapper.ToService(dto));
    }

    @Override
    public void updateService(ServiceDto dto) {
        serviceRepository.save(serviceMapper.ToService(dto));
    }

    @Override
    public List<ServiceDto> fetchAllServices() {
        return serviceRepository.findAll()
                .stream().map(serviceMapper::ToServiceDto)
                .collect(Collectors.toList());
    }
}
