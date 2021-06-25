package ir.maktab.service;

import ir.maktab.dto.ServiceDto;
import ir.maktab.service.exception.DuplicatedServiceException;

import java.util.List;

public interface ServiceService {
    void saveNewService(ServiceDto dto) throws DuplicatedServiceException;

    ServiceDto getService(ServiceDto dto);

    List<ServiceDto> fetchAllServices();

    void deleteService(ServiceDto dto);

    void updateService(ServiceDto dto);


}
