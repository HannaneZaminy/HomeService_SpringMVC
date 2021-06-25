package ir.maktab.service;

import ir.maktab.data.domain.Customer;
import ir.maktab.data.domain.Specialist;
import ir.maktab.data.domain.CustomerOrder;
import ir.maktab.data.domain.SubService;
import ir.maktab.data.enums.OrderStatus;
import ir.maktab.data.repository.*;
import ir.maktab.dto.*;
import ir.maktab.service.exception.NotFoundOrderException;
import ir.maktab.service.mapper.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository repository;
    private final OrderMapper orderMapper;
    private final SpecialistRepository expertRepository;
    private final OrderInfoService orderInfoService;
    private final SubServiceRepository subServiceRepository;
    private final SubServiceMapper serviceMapper;
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;




    public OrderServiceImpl(OrderRepository repository, OrderMapper orderMapper
            , SubServiceRepository subServiceRepository,
                            SubServiceMapper serviceMapper,
                            CustomerRepository customerRepository,
                            CustomerMapper customerMapper,
                            SpecialistMapper expertMapper,
                            SpecialistRepository expertRepository, CustomerService customerService, OrderInfoService orderInfoService) {
        this.repository = repository;
        this.orderMapper = orderMapper;
        this.subServiceRepository = subServiceRepository;
        this.serviceMapper = serviceMapper;
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
        this.expertRepository = expertRepository;

        this.orderInfoService = orderInfoService;
    }
    @Override
    public List<OrderDto> filterOrders(OrderFilterDto dto) {
        List<CustomerOrder> all = repository.findAll(Specification.where(OrderSpecification.filterOrders(dto)));
        return all.stream().map(orderMapper::toOrderDto).collect(Collectors.toList());
    }
    @Override
    public void saveNewOrder(OrderDto dto)  {
        Optional<SubService> subService = subServiceRepository.findByName(dto.getSubService().getName());
        if (subService.isPresent()) {
            dto.setSubService(serviceMapper.covertToSubServiceDto(subService.get()));
        }
        Optional<Customer> customer = customerRepository.findByEmail(dto.getCustomer().getEmail());
        if (customer.isPresent()) {
            dto.setCustomer(customerMapper.toCustomerDto(customer.get()));
        }
        dto.setSituation(OrderStatus.Waiting_for_specialist_suggestions);
        CustomerOrder save = repository.save(orderMapper.toOrder(dto));
        OrderInfDto orderHistoryDto = new OrderInfDto();
        orderHistoryDto.setOrderDto(orderMapper.toOrderDto(save));
        orderHistoryDto.setOrderStatus(OrderStatus.Waiting_for_specialist_suggestions);
        orderInfoService.save(orderHistoryDto);

    }

    @Override
    public OrderDto updateOrder(OrderDto dto) {
        CustomerOrder save = repository.save(orderMapper.toOrder(dto));
        return orderMapper.toOrderDto(save);

    }

    @Override
    public List<OrderDto> fetchAllOrdersForOfferSpecialist() {
        return repository.findAll()
                .stream().map(orderMapper::toOrderDto).filter(o->o.getSituation().equals(OrderStatus.Waiting_for_specialist_suggestions))
                .collect(Collectors.toList());
    }




    @Override
    public OrderDto findById(Integer id) throws NotFoundOrderException {
        Optional<CustomerOrder> order = repository.findById(id);
        if (order.isPresent()) {
            return orderMapper.toOrderDto(order.get());
        } else {
            throw new NotFoundOrderException("This Order Is Not Available !");
        }
    }

    @Override
    public List<OrderDto> findBySpecialist(SpecialistDto dto) throws NotFoundOrderException {
        Optional<Specialist> specialist= expertRepository.findByEmail(dto.getEmail());
        List<CustomerOrder> orders = repository.findBySpecialist(specialist.get());
        if (orders.size() == 0) {
            throw new NotFoundOrderException("NotFoundOrder ");
        }
        return orders.stream().map(orderMapper::toOrderDto).collect(Collectors.toList());
    }

    @Override
    public List<OrderDto> findByCustomer(CustomerDto dto) throws NotFoundOrderException {
        Optional<Customer> customerDto = customerRepository.findByEmail(dto.getEmail());
        List<CustomerOrder> orders = repository.findByCustomer(customerDto.get());
        if (orders.size() == 0) {
            throw new NotFoundOrderException("The Customer Has No Order History ! ");
        }
        return orders.stream().map(orderMapper::toOrderDto).collect(Collectors.toList());
    }

    @Override
    public void endOfWork(Integer id) throws NotFoundOrderException {
        Optional<CustomerOrder> byId = repository.findById(id);
        if (!byId.isPresent()){
            throw new NotFoundOrderException("This Order Is Not Available !");
        }
        byId.get().setSituation(OrderStatus.done);
        updateOrder(orderMapper.toOrderDto(byId.get()));
        OrderInfDto orderHistoryDto = new OrderInfDto();
        orderHistoryDto.setOrderDto(orderMapper.toOrderDto(byId.get()));
        orderHistoryDto.setOrderStatus(OrderStatus.done);
        orderInfoService.save(orderHistoryDto);
    }


    @Override
    public void startWork(Integer id) throws NotFoundOrderException {
        Optional<CustomerOrder> byId = repository.findById(id);
        if (!byId.isPresent()){
            throw new NotFoundOrderException("This Order Is Not Available !");
        }
        byId.get().setSituation(OrderStatus.started);
        OrderDto dto = updateOrder(orderMapper.toOrderDto(byId.get()));
        OrderInfDto orderHistoryDto = new OrderInfDto();
        orderHistoryDto.setOrderDto(dto);
        orderHistoryDto.setOrderStatus(OrderStatus.started);
        orderInfoService.save(orderHistoryDto);
    }



}


