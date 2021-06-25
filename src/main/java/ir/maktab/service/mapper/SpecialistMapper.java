package ir.maktab.service.mapper;

import ir.maktab.data.domain.Specialist;
import ir.maktab.dto.SpecialistDto;

public interface SpecialistMapper {
    Specialist toSpecialist(SpecialistDto dto);

    SpecialistDto toSpecialistDto(Specialist expert);
}
