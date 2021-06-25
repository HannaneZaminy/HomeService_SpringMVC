package ir.maktab.service;

import ir.maktab.dto.*;
import ir.maktab.service.exception.NotFoundCustomerException;
import ir.maktab.service.exception.NotFoundOrderException;

import java.util.List;

public interface OrderService {
    void saveNewOrder(OrderDto dto) throws NotFoundCustomerException;

    List<OrderDto> filterOrders(OrderFilterDto dto);
    OrderDto updateOrder(OrderDto dto);

    List<OrderDto> fetchAllOrdersForOfferSpecialist();


    OrderDto findById(Integer id) throws NotFoundOrderException;

    List<OrderDto> findBySpecialist(SpecialistDto dto) throws NotFoundOrderException;
    List<OrderDto> findByCustomer(CustomerDto dto) throws NotFoundOrderException, NotFoundCustomerException;

    void endOfWork(Integer id) throws NotFoundOrderException;


    void startWork(Integer id) throws NotFoundOrderException;


}
