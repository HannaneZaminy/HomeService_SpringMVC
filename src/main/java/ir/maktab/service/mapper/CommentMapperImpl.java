package ir.maktab.service.mapper;

import ir.maktab.data.domain.Comments;
import ir.maktab.dto.CommentDto;
import org.springframework.stereotype.Component;

@Component
public class CommentMapperImpl implements CommentMapper {
    private final CustomerMapper customerMapper;
    private final OrderMapper orderMapper;


    public CommentMapperImpl(CustomerMapper customerMapper, SpecialistMapper specialistMapper, OrderMapper orderMapper) {
        this.customerMapper = customerMapper;
        this.orderMapper = orderMapper;
    }

    @Override
    public Comments toComment(CommentDto dto) {
        Comments comments = new Comments();
        comments.setId(dto.getId());
        comments.setRate(dto.getRate());
        comments.setComment(dto.getComment());
        comments.setCustomer(customerMapper.toCustomer(dto.getCustomer()));
        comments.setOrder(orderMapper.toOrder(dto.getOrderDto()));
        return comments;

    }

    @Override
    public CommentDto toCommentDto(Comments comments) {
        CommentDto dto = new CommentDto();
        dto.setId(comments.getId());
        dto.setComment(comments.getComment());
        dto.setRate(comments.getRate());
        dto.setCustomer(customerMapper.toCustomerDto(comments.getCustomer()));
        dto.setOrderDto(orderMapper.toOrderDto(comments.getOrder()));
        return dto;
    }
}
