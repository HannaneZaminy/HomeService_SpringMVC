package ir.maktab.service;

import ir.maktab.data.domain.Specialist;
import ir.maktab.data.domain.Offer;
import ir.maktab.data.enums.OfferStatus;
import ir.maktab.data.enums.OrderStatus;
import ir.maktab.data.repository.OffersRepository;
import ir.maktab.dto.*;
import ir.maktab.service.exception.*;
import ir.maktab.service.mapper.SpecialistMapper;
import ir.maktab.service.mapper.OfferMapper;
import ir.maktab.service.mapper.OrderMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OfferServiceImpl implements OfferService {
    private final OffersRepository offersRepository;
    private final OfferMapper offerMapper;
    private final SpecialistMapper specialistMapper;
    private final OrderInfoService orderInfoService;

    private final CustomerService customerService;
    private final OrderMapper orderMapper;
    private final SpecialistService specialistService;
    private final OrderService orderService;

    public OfferServiceImpl(OffersRepository offersRepository,
                            OfferMapper offerMapper,
                            SpecialistMapper specialistMapper,
                            OrderInfoService orderInfoService,
                            CustomerService customerService,
                            OrderMapper orderMapper,
                            SpecialistService specialistService,
                            OrderService orderService) {
        this.offersRepository = offersRepository;
        this.offerMapper = offerMapper;
        this.specialistMapper = specialistMapper;
        this.orderInfoService = orderInfoService;
        this.customerService = customerService;
        this.orderMapper = orderMapper;
        this.specialistService = specialistService;
        this.orderService = orderService;
    }

    @Override
    public void
    saveNewOffer(OfferDto dto) throws LessOfferPriceException, NotFoundSpecialistException, NotFoundOrderException {
        SpecialistDto expertDto = specialistService.findByEmail(dto.getSpecialistDto().getEmail());
        OrderInfDto orderHistoryDto = new OrderInfDto();
        OrderDto orderDto = orderService.findById(dto.getOrders().getId());
        Double basePrice = orderDto.getSubService().getBasePrice();
        dto.setSpecialistDto(expertDto);
        dto.setOrders(orderDto);
        if (dto.getOfferPrice() < basePrice) {
            throw new LessOfferPriceException("Offer Price Is Less Than Sub Service Base Price");
        }
        dto.getOrders().setSituation(OrderStatus.Waiting_for_customer_selection);
        OrderDto order = orderService.updateOrder(dto.getOrders());
        orderHistoryDto.setOrderDto(order);
        orderHistoryDto.setOrderStatus(OrderStatus.Waiting_for_customer_selection);
        orderInfoService.save(orderHistoryDto);
        offersRepository.save(offerMapper.toOffer(dto));
    }

//    @Override
//    public void calcSpecialistMoney(OfferDto dto) {
//
//
//    }

    @Override
    public void updateOffer(OfferDto dto) {
        offersRepository.save(offerMapper.toOffer(dto));

    }


    public List<OfferDto> getOrderOffersSortByRateAndPrice(CustomerDto dto) throws NotFoundCustomerException, NotFoundOrderException {
        CustomerDto customerDto = customerService.findByEmail(dto.getEmail());
        List<OrderDto> orders = orderService.findByCustomer(customerDto).stream().filter(i -> i.getSituation().equals(
                OrderStatus.Waiting_for_customer_selection)).collect(Collectors.toList());
        List<OfferDto> offers = offersRepository.findAll().stream().map(offerMapper::toOfferDto).collect(Collectors.toList());
        List<OfferDto> collect = new ArrayList<>();
        for (OrderDto order : orders) {
            for (OfferDto offer : offers) {
                if (order.getId().equals(offer.getOrders().getId())) {
                    collect.add(offer);
                }
            }
        }
        return collect.stream().filter(i -> i.getOfferStatus().equals(OfferStatus.registered)).collect(Collectors.toList());
    }

    @Override
    public void changeSituation(Integer id) throws NotFoundOrderException {
        OrderInfDto orderHistoryDto = new OrderInfDto();
        Optional<Offer> offer = offersRepository.findById(id);
        offer.get().setOfferSituation(OfferStatus.accepted);
        OrderDto dto = orderService.findById(offer.get().getOrders().getId());
        orderHistoryDto.setOrderDto(dto);
        dto.setSpecialistDto(specialistMapper.toSpecialistDto(offer.get().getSpecialist()));
        dto.setSituation(OrderStatus.Waiting_for_specialist_to_come_Your_place);
        orderHistoryDto.setOrderStatus(OrderStatus.Waiting_for_specialist_to_come_Your_place);
        orderInfoService.save(orderHistoryDto);
        orderService.updateOrder(dto);
        updateOffer(offerMapper.toOfferDto(offer.get()));
    }


    @Override
    public void paymentFromWallet(Integer id, CustomerDto dto)
            throws NotFoundOrderException, NotFoundCustomerException, NotEnoughAccountBalanceException {
        OrderInfDto orderHistoryDto = new OrderInfDto();
        OrderDto byId = orderService.findById(id);
        CustomerDto customerDto = customerService.findByEmail(dto.getEmail());
        Optional<Offer> offer = offersRepository.findByOrders(orderMapper.toOrder(byId));
        Specialist specialist = offer.get().getSpecialist();
        if (offer.get().getOfferPrice() > customerDto.getWallet()) {
            throw new NotEnoughAccountBalanceException("Account balance is not enough !");
        }
        byId.setSituation(OrderStatus.paid);
        orderHistoryDto.setOrderDto(byId);
        orderHistoryDto.setOrderStatus(OrderStatus.paid);
        orderInfoService.save(orderHistoryDto);
        orderService.updateOrder(byId);
        customerDto.setWallet(customerDto.getWallet() - offer.get().getOfferPrice());
        customerService.updateCustomer(customerDto);
        double amount = offer.get().getOfferPrice() * 0.7;
        specialist.setWallet(specialist.getWallet() + offer.get().getOfferPrice() * 0.7);
        //specialistService.updateSpecialistWallet(specialistMapper.toSpecialistDto(specialist),amount);
        specialistService.updateSpecialist(specialistMapper.toSpecialistDto(specialist));
    }

    @Override
    public void onlinePayment(OrderDto orderDto) {
        OrderInfDto orderHistoryDto = new OrderInfDto();
        Optional<Offer> offer = offersRepository.findByOrders(orderMapper.toOrder(orderDto));
        Specialist specialist = offer.get().getSpecialist();
        offersRepository.save(offer.get());
        orderDto.setSituation(OrderStatus.paid);
        orderHistoryDto.setOrderDto(orderDto);
        orderHistoryDto.setOrderStatus(OrderStatus.paid);
        orderInfoService.save(orderHistoryDto);
        orderService.updateOrder(orderDto);
        double amount = offer.get().getOfferPrice() * 0.7;
        specialist.setWallet(specialist.getWallet() + offer.get().getOfferPrice() * 0.7);
       // specialistService.updateSpecialistWallet(specialistMapper.toSpecialistDto(specialist),amount);
        specialistService.updateSpecialist(specialistMapper.toSpecialistDto(specialist));
    }


}

