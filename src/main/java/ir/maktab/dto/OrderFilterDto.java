package ir.maktab.dto;

import ir.maktab.data.enums.OrderStatus;

import java.util.Date;

public class OrderFilterDto {

    private String subServiceName;
    private OrderStatus orderStatus;
    private String serviceName;
    private Date minDate;
    private Date maxDate;




    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public OrderFilterDto setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
        return this;
    }

    public String getServiceName() {
        return serviceName;
    }

    public OrderFilterDto setServiceName(String serviceName) {
        this.serviceName = serviceName;
        return this;
    }

    public String getSubServiceName() {
        return subServiceName;
    }

    public OrderFilterDto setSubServiceName(String subServiceName) {
        this.subServiceName = subServiceName;
        return this;
    }

    public Date getMinDate() {
        return minDate;
    }

    public OrderFilterDto setMinDate(Date minDate) {
        this.minDate = minDate;
        return this;
    }

    public Date getMaxDate() {
        return maxDate;
    }

    public OrderFilterDto setMaxDate(Date maxDate) {
        this.maxDate = maxDate;
        return this;
    }
}
