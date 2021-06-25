package ir.maktab.service.mapper;

import ir.maktab.data.domain.OrderInf;
import ir.maktab.dto.OrderInfDto;
import org.springframework.stereotype.Component;

@Component
public class OrderInfMapperImpl implements OrderInfMapper {
    private final OrderMapper orderMapper;

    public OrderInfMapperImpl(OrderMapper orderMapper) {
        this.orderMapper = orderMapper;
    }

    @Override
    public OrderInf toOrderInf(OrderInfDto orderInfDto) {
        OrderInf inf = new OrderInf();
        inf.setOrder(orderMapper.toOrder(orderInfDto.getOrderDto()));
        inf.setId(orderInfDto.getId());
        inf.setOrderSituation(orderInfDto.getOrderStatus());
        return inf;
    }

    @Override
    public OrderInfDto toOrderInfDto(OrderInf orderInf) {
        OrderInfDto dto = new OrderInfDto();
        dto.setId(orderInf.getId());
        dto.setOrderStatus(orderInf.getOrderSituation());
        dto.setOrderDto(orderMapper.toOrderDto(orderInf.getOrder()));
        return dto;
    }
}
