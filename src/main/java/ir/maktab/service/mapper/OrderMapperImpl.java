package ir.maktab.service.mapper;

import ir.maktab.data.domain.CustomerOrder;
import ir.maktab.dto.OrderDto;
import org.springframework.stereotype.Component;

@Component
public class OrderMapperImpl implements OrderMapper {
    private final CustomerMapper customerMapper;
    private final SubServiceMapper serviceMapper;
    private final SpecialistMapper specialistMapper;

    public OrderMapperImpl(CustomerMapper customerMapper, SubServiceMapper serviceMapper, SpecialistMapper specialistMapper) {
        this.customerMapper = customerMapper;
        this.serviceMapper = serviceMapper;
        this.specialistMapper = specialistMapper;
    }


    @Override
    public CustomerOrder toOrder(OrderDto dto) {
        CustomerOrder order = new CustomerOrder();
        if (dto.getSpecialistDto() != null) {
            order.setSpecialist(specialistMapper.toSpecialist(dto.getSpecialistDto()));
        }
        order.setId(dto.getId());
        order.setDateOfWork(dto.getDateOfWork());
        order.setFinalPrice(dto.getProposedPrice());
        order.setSituation(dto.getSituation());
        order.setCustomer(customerMapper.toCustomer(dto.getCustomer()));
        order.setDateOfOrderRegistration(dto.getDateOfOrderRegistration());
        order.setDescription(dto.getDescription());

        order.setSubService(serviceMapper.convertToSubService(dto.getSubService()));
        order.setAddress(dto.getAddress());

        return order;
    }


    @Override
    public OrderDto toOrderDto(CustomerOrder order) {
        OrderDto dto = new OrderDto();
        if (order.getSpecialist() != null)
            dto.setSpecialistDto(specialistMapper.toSpecialistDto(order.getSpecialist()));
        dto.setId(order.getId());
        dto.setCustomer(customerMapper.toCustomerDto(order.getCustomer()));
        dto.setDateOfOrderRegistration(order.getDateOfOrderRegistration());
        dto.setDescription(order.getDescription());
        dto.setSubService(serviceMapper.covertToSubServiceDto(order.getSubService()));
        dto.setProposedPrice(order.getFinalPrice());
        dto.setSituation(order.getSituation());
        dto.setDateOfWork(order.getDateOfWork());
        dto.setAddress(order.getAddress());

        return dto;
    }
}
