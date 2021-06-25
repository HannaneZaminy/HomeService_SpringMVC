package ir.maktab.web;

import ir.maktab.configuration.LastViewInterceptor;
import ir.maktab.dto.*;
import ir.maktab.service.OrderService;
import ir.maktab.service.ServiceService;
import ir.maktab.service.SubServiceService;
import ir.maktab.service.exception.*;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/order")
@SessionAttributes({"newOrder"})
public class OrderController {
    private final ServiceService service;
    private final SubServiceService subServiceServicee;
    private final OrderService orderService;
    private static final Logger logger = Logger.getLogger(OrderController.class);

    public OrderController(ServiceService service, SubServiceService subServiceServicee, OrderService orderService) {
        this.service = service;
        this.subServiceServicee = subServiceServicee;
        this.orderService = orderService;
    }

    @PostMapping(value = "/searchOrder")
    public ModelAndView searchUsers(@ModelAttribute("orders") OrderFilterDto dto) {
        return new ModelAndView("searchOrderPage", "ordersList", orderService.filterOrders(dto));

    }

    @GetMapping(value = "/searchOrder")
    public String searchUsers(Model model) {
        model.addAttribute("orders", new OrderFilterDto());
        model.addAttribute("service", service.fetchAllServices());
        model.addAttribute("subService", subServiceServicee.fetchAllSubServices());
        return "searchOrderPage";
    }
    @GetMapping("/createOrder")
    public String createOrder(Model model, HttpServletRequest request) {
        model.addAttribute("newOrder", new OrderDto());
        model.addAttribute("selectedService", "select");
        model.addAttribute("serviceList", service.fetchAllServices());
        HttpSession session = request.getSession();
        session.setAttribute("serviceList", service.fetchAllServices());
        return "addNewOrder";
    }

    @PostMapping("/createOrder")
    public String createNewOrder(@ModelAttribute("newOrder") @Valid OrderDto dto, HttpServletRequest request)
            throws NotFoundCustomerException {
        HttpSession session = request.getSession(false);
        CustomerDto customer = (CustomerDto) session.getAttribute("customer");
        CustomerDto loginCustomer = (CustomerDto) session.getAttribute("loginCustomer");
        CustomerDto customerDto = new CustomerDto();
        if (customer != null)
            customerDto.setEmail(customer.getEmail());
        if (loginCustomer != null)
            customerDto.setEmail(loginCustomer.getEmail());
        dto.setCustomer(customerDto);
        orderService.saveNewOrder(dto);
        return "customerHomePage";
    }

    @GetMapping("/endOfWork/{id}")
    public String endOfWork(@PathVariable("id")Integer id) throws NotFoundOrderException {
        orderService.endOfWork(id);
        return "specialistHomePage";
    }

    @GetMapping("/startWork/{id}")
    public String startWork(@PathVariable("id")Integer id) throws NotFoundOrderException {
        orderService.startWork(id);
        return "specialistHomePage";
    }


    @ExceptionHandler({NotFoundCustomerException.class,NotFoundOrderException.class})
    public ModelAndView errorHandler(Exception e, HttpServletRequest request) {
        Map<String, Object> model = new HashMap<>();
        model.put("error", e.getLocalizedMessage());
        model.put("newOffer", new OfferDto());
        String lastView = (String) request.getSession().getAttribute(LastViewInterceptor.LAST_VIEW_ATTRIBUTE);
        System.out.println(lastView);
        return new ModelAndView(lastView, model);
    }


    @ExceptionHandler(value = BindException.class)
    public ModelAndView bindHandler(BindException ex, HttpServletRequest request) {
        String lastView = (String) request.getSession().getAttribute(LastViewInterceptor.LAST_VIEW_ATTRIBUTE);
        System.out.println(lastView);
        return new ModelAndView(lastView, ex.getBindingResult().getModel());

    }


}
