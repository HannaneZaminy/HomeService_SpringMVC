package ir.maktab.service.mapper;

import ir.maktab.data.domain.Service;
import ir.maktab.dto.ServiceDto;

public interface ServiceMapper {

    ServiceDto ToServiceDto(Service service);

    Service ToService(ServiceDto serviceDto);
}
