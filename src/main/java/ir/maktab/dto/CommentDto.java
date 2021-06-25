package ir.maktab.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;


public class CommentDto {

    private Integer id;
    private CustomerDto customer;
    private String comment;
    private OrderDto orderDto;
    private SpecialistDto specialistDto;

    @Max(value = 10,message = "Rate Most Be Less Than 10 !")
    @Min(value = 0,message = "Rate Most Be More Than 0 !")
    private Double rate;

    public Integer getId() {
        return id;
    }

    public CommentDto setId(Integer id) {
        this.id = id;
        return this;
    }

    public CustomerDto getCustomer() {
        return customer;
    }

    public CommentDto setCustomer(CustomerDto customer) {
        this.customer = customer;
        return this;
    }

    public String getComment() {
        return comment;
    }

    public CommentDto setComment(String comment) {
        this.comment = comment;
        return this;
    }

    public OrderDto getOrderDto() {
        return orderDto;
    }

    public CommentDto setOrderDto(OrderDto orderDto) {
        this.orderDto = orderDto;
        return this;
    }

    public SpecialistDto getSpecialistDto() {
        return specialistDto;
    }

    public CommentDto setSpecialistDto(SpecialistDto specialistDto) {
        this.specialistDto = specialistDto;
        return this;
    }

    public Double getRate() {
        return rate;
    }

    public CommentDto setRate(Double rate) {
        this.rate = rate;
        return this;
    }
}
