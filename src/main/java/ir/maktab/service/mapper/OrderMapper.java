package ir.maktab.service.mapper;

import ir.maktab.data.domain.CustomerOrder;
import ir.maktab.dto.OrderDto;

public interface OrderMapper {
    CustomerOrder toOrder(OrderDto dto);

    OrderDto toOrderDto(CustomerOrder order);
}
