package ir.maktab.service;

import ir.maktab.dto.CustomerDto;
import ir.maktab.dto.OfferDto;
import ir.maktab.dto.OfferInfDto;
import ir.maktab.dto.OrderDto;
import ir.maktab.service.exception.*;

import java.util.List;

public interface OfferService {
    void saveNewOffer(OfferDto dto) throws LessOfferPriceException, NotSubServiceInExpertsListException, NotFoundSpecialistException, NotFoundOrderException;

//    void calcSpecialistMoney(OfferDto dto);

    void updateOffer(OfferDto dto);


    List<OfferDto> getOrderOffersSortByRateAndPrice(CustomerDto dto ) throws NotFoundCustomerException, NotFoundOrderException;
    void changeSituation(Integer id) throws NotFoundOrderException;
    void paymentFromWallet(Integer id, CustomerDto dto) throws NotFoundOrderException, NotFoundCustomerException, NotEnoughAccountBalanceException;

    void onlinePayment(OrderDto orderDto) throws NotFoundCustomerException;

}
