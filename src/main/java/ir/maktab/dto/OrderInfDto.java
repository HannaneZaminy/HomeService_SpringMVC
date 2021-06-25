package ir.maktab.dto;

import ir.maktab.data.enums.OrderStatus;

public class OrderInfDto {
    private int id;
    private OrderStatus orderStatus;
    private OrderDto orderDto;


    public int getId() {
        return id;
    }

    public OrderInfDto setId(int id) {
        this.id = id;
        return this;
    }

    public OrderDto getOrderDto() {
        return orderDto;
    }

    public OrderInfDto setOrderDto(OrderDto orderDto) {
        this.orderDto = orderDto;
        return this;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public OrderInfDto setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
        return this;
    }
}
