package ir.maktab.service;

import ir.maktab.dto.SubServiceDto;
import ir.maktab.service.exception.DuplicatedServiceException;
import ir.maktab.service.exception.NotFoundServiceException;
import ir.maktab.service.exception.NotFoundSubServiceException;

import java.util.List;

public interface SubServiceService {

    void saveNewSubService(SubServiceDto dto) throws DuplicatedServiceException, NotFoundServiceException;

    void updateSubService(SubServiceDto dto);

    void deleteSubService(SubServiceDto dto);

    //void addSpecialistToSubService(SubServiceDto serviceDto);

    SubServiceDto getSubService(SubServiceDto dto);

    List<SubServiceDto> fetchAllSubServices();

    SubServiceDto findByName(String name) throws NotFoundSubServiceException;

    List<SubServiceDto> getSubServicesByServiceName(String service);
}
