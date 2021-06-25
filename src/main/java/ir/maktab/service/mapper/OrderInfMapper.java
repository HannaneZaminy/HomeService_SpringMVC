package ir.maktab.service.mapper;

import ir.maktab.data.domain.OrderInf;
import ir.maktab.dto.OrderInfDto;

public interface OrderInfMapper {

    OrderInf toOrderInf(OrderInfDto dto);
    OrderInfDto toOrderInfDto(OrderInf orderHistory);
}
