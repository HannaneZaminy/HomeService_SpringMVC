package ir.maktab.service;

import ir.maktab.data.repository.CommentsRepository;
import ir.maktab.dto.CommentDto;
import ir.maktab.dto.SpecialistDto;
import ir.maktab.dto.OrderDto;
import ir.maktab.service.exception.NotFoundOrderException;
import ir.maktab.service.mapper.CommentMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService {
    private final CommentsRepository commentsRepository;
    private final CommentMapper commentMapper;
    private final SpecialistService specialistService;
    private final OrderService orderService;

    public CommentServiceImpl(CommentsRepository commentsRepository, CommentMapper commentMapper, SpecialistService specialistService, OrderService orderService) {
        this.commentsRepository = commentsRepository;
        this.commentMapper = commentMapper;
        this.specialistService = specialistService;
        this.orderService = orderService;
    }

    @Override
    public void saveNewComment(CommentDto commentDto) throws NotFoundOrderException {
        OrderDto orderDto = orderService.findById(commentDto.getOrderDto().getId());
        SpecialistDto specialistDto = orderDto.getSpecialistDto();
        int numberOfSpecialistOrders = specialistDto.getOrders().size();
        double rate = (specialistDto.getRate() + commentDto.getRate())/numberOfSpecialistOrders ;
        specialistDto.setRate(rate);
        commentDto.setSpecialistDto(specialistDto);
        specialistService.updateSpecialist(specialistDto);
        commentDto.setCustomer(orderDto.getCustomer());
        commentDto.setOrderDto(orderDto);
        commentsRepository.save(commentMapper.toComment(commentDto));
    }
    @Override
    public List<CommentDto> fetchAllComments() {
        return
                commentsRepository.findAll()
                        .stream()
                        .map(commentMapper::toCommentDto).collect(Collectors.toList());
    }

    @Override
    public void deleteComment(CommentDto dto) {
        commentsRepository.delete(commentMapper.toComment(dto));

    }

    @Override
    public void updateComment(CommentDto dto) {
        commentsRepository.save(commentMapper.toComment(dto));

    }



}
