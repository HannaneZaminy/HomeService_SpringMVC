package ir.maktab.service.mapper;

import ir.maktab.data.domain.SubService;
import ir.maktab.dto.SubServiceDto;
import org.springframework.stereotype.Component;

@Component
public class SubServiceMapperImpl implements SubServiceMapper {
    private final ServiceMapper serviceMapper;

    public SubServiceMapperImpl(ServiceMapper serviceMapper) {
        this.serviceMapper = serviceMapper;
    }


    @Override
    public SubServiceDto covertToSubServiceDto(SubService subService) {
        SubServiceDto subServiceDto = new SubServiceDto();
        subServiceDto.setId(subService.getId());
        subServiceDto.setName(subService.getName());
        subServiceDto.setBasePrice(subService.getBasePrice());
        subServiceDto.setDescription(subService.getDescription());
        subServiceDto.setService(serviceMapper.ToServiceDto(subService.getService()));
        return subServiceDto;
    }

    @Override
    public SubService convertToSubService(SubServiceDto subServiceDto) {
        SubService subService = new SubService();
        subService.setId(subServiceDto.getId());
        subService.setName(subServiceDto.getName());
        subService.setBasePrice(subServiceDto.getBasePrice());
        subService.setDescription(subServiceDto.getDescription());
        subService.setService(serviceMapper.ToService(subServiceDto.getService()));
        return subService;
    }
}
