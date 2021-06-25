package ir.maktab.web;

import ir.maktab.configuration.LastViewInterceptor;
import ir.maktab.dto.*;
import ir.maktab.service.CustomerService;
import ir.maktab.service.OfferService;
import ir.maktab.service.OrderService;
import ir.maktab.service.exception.*;
import ir.maktab.service.validation.ChangePasswordValidation;
import ir.maktab.service.validation.LoginValidation;
import ir.maktab.service.validation.RegisterValidation;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/customer")
@SessionAttributes({"loginCustomer", "customer", "order"})
public class CustomerController {
    private static final Logger logger = Logger.getLogger(CustomerController.class);
    private final CustomerService customerService;
    private final OrderService orderService;
    private final OfferService offerService;


    public CustomerController(CustomerService customerService, OrderService orderService, OfferService offerService) {
        this.customerService = customerService;
        this.orderService = orderService;
        this.offerService = offerService;
    }

    @GetMapping("/register")
    public ModelAndView goToRegisterPage() {
        return new ModelAndView("customerRegisterPage", "customer", new CustomerDto());
    }

    @PostMapping("/register")
    public String saveNewCustomer(@ModelAttribute("customer") @Validated(RegisterValidation.class) CustomerDto customerDto, Model model)
            throws DuplicatedEmailAddressException {

        customerService.saveNewCustomer(customerDto);
        logger.info(customerDto.getName() + "registered" );
        return "customerHomePage";
    }


    @GetMapping("/login")
    public ModelAndView goToLoginPage() {
        return new ModelAndView("customerPage", "loginCustomer", new CustomerDto());
    }


    @PostMapping("/login")
    public String loginCustomer(@ModelAttribute("loginCustomer") @Validated(LoginValidation.class) CustomerDto customerDto, Model model)
            throws InvalidPasswordException, NotFoundCustomerException {

         customerService.loginCustomer(customerDto);
        logger.info(customerDto.getEmail() + "login" );
        return "customerHomePage";
    }


    @GetMapping("/changePassword")
    public String changePassword(Model model) {
        model.addAttribute("changePassword", new CustomerDto());
        return "customerPassChange";
    }


    @PostMapping("/changePassword")
    public String changePassword(@ModelAttribute("changePassword") @Validated(ChangePasswordValidation.class) CustomerDto dto,
                                 HttpServletRequest request) {

        HttpSession session = request.getSession(false);
        CustomerDto customer = (CustomerDto) session.getAttribute("customer");
        CustomerDto loginCustomer = (CustomerDto) session.getAttribute("loginCustomer");
        if (customer != null)
            dto.setEmail(customer.getEmail());
        customerService.changePassword(dto);
        if (loginCustomer != null)
            dto.setEmail(loginCustomer.getEmail());
        customerService.changePassword(dto);
        return "customerHomePage";
    }

    @GetMapping("/showOrders")
    public String showOrders(Model model, HttpServletRequest request)
            throws NotFoundOrderException, NotFoundCustomerException {

        HttpSession session = request.getSession(false);
        CustomerDto customer = (CustomerDto) session.getAttribute("customer");
        CustomerDto loginCustomer = (CustomerDto) session.getAttribute("loginCustomer");
        if (customer != null)
            model.addAttribute("ordersList", orderService.findByCustomer(customer));
        if (loginCustomer != null)
            model.addAttribute("ordersList", orderService.findByCustomer(loginCustomer));
        return "customerOrders";
    }
    @GetMapping("/showMyWallet")
    public String showMyWallet(Model model) {
        model.addAttribute("customerWallet", new CustomerDto());
        return "showMyWallet";
    }
    @GetMapping("/showOffers")
    public String showOffers(HttpServletRequest request, Model model)
            throws NotFoundCustomerException,
            NotFoundOrderException {

        HttpSession session = request.getSession(false);
        CustomerDto customer = (CustomerDto) session.getAttribute("customer");
        CustomerDto loginCustomer = (CustomerDto) session.getAttribute("loginCustomer");
        if (customer != null)
            model.addAttribute("offersList", offerService.getOrderOffersSortByRateAndPrice(customer));
        if (loginCustomer != null)
            model.addAttribute("offersList", offerService.getOrderOffersSortByRateAndPrice(loginCustomer));
        return "sellectOffersCustomer";
    }
    @GetMapping("/profile")
    public ModelAndView goToProfile() {
        return new ModelAndView("customerHomePage", "loginCustomer", new CustomerDto());
    }
    @GetMapping("/paymentFromWallet/{id}")
    public String paymentFromAccountCredit(@PathVariable("id") Integer id, HttpServletRequest request) throws
            NotFoundCustomerException, NotEnoughAccountBalanceException, NotFoundOrderException {
        HttpSession session = request.getSession(false);
        CustomerDto customer = (CustomerDto) session.getAttribute("customer");
        CustomerDto loginCustomer = (CustomerDto) session.getAttribute("loginCustomer");
        if (customer != null)
            offerService.paymentFromWallet(id, customer);
        if (loginCustomer != null)
            offerService.paymentFromWallet(id, loginCustomer);
        return "customerHomePage";
    }

    @GetMapping("/onlinePayment/{id}")
    public ModelAndView onlinePayment(@PathVariable("id") Integer id, Model model
    ) throws NotFoundOrderException {

        OrderDto orderDto = orderService.findById(id);
        model.addAttribute("order", orderDto);
        return new ModelAndView("onlinePaymentPage", "onlinePayment", new CreditCardInfo());
    }
    @GetMapping("/onlinePayment}")
    public ModelAndView onlinePaymentForIncreaseAccount(Model model)  {
        return new ModelAndView("onlinePaymentPage", "onlinePayment", new CreditCardInfo());
    }
    @PostMapping("/onlinePayment")
    public String onlinePayment(HttpServletRequest request,
                                @ModelAttribute("onlinePayment") @Valid CreditCardInfo info, Model model) throws NotFoundCustomerException {
        HttpSession session = request.getSession(false);
        CustomerDto customer = (CustomerDto) session.getAttribute("customer");
        CustomerDto loginCustomer = (CustomerDto) session.getAttribute("loginCustomer");
        OrderDto orderDto = (OrderDto) session.getAttribute("order");
        String captcha = session.getAttribute("captcha_security").toString();
        String verifyCaptcha = request.getParameter("captcha");
        if (customer != null && captcha.equals(verifyCaptcha)) {
            model.addAttribute("onlinePayment", info);
            offerService.onlinePayment(orderDto);
        } else if (loginCustomer != null && captcha.equals(verifyCaptcha)) {
            model.addAttribute("onlinePayment", info);
            offerService.onlinePayment(orderDto);
        } else {
            model.addAttribute("error", "Captcha Invalid");
            return "onlinePaymentPage";
        }
        return "customerHomePage";
    }


    @ExceptionHandler({NotFoundCustomerException.class, InvalidPasswordException.class,
            DuplicatedEmailAddressException.class, NotFoundOrderException.class
            , NotFoundCustomerException.class, NotEnoughAccountBalanceException.class})
    public ModelAndView errorHandler(Exception e, HttpServletRequest request) {
        Map<String, Object> model = new HashMap<>();
        logger.error("exception occurred: " + e.getMessage());
        model.put("error", e.getLocalizedMessage());
        model.put("loginCustomer", new LoginCustomerDto());
        String lastView = (String) request.getSession().getAttribute(LastViewInterceptor.LAST_VIEW_ATTRIBUTE);
        System.out.println(lastView);
        return new ModelAndView(lastView, model);
    }

    @ExceptionHandler(value = BindException.class)
    public ModelAndView bindHandler(BindException ex, HttpServletRequest request) {
        String lastView = (String) request.getSession().getAttribute(LastViewInterceptor.LAST_VIEW_ATTRIBUTE);
        logger.error("exception occurred: " + ex.getMessage());
        return new ModelAndView(lastView, ex.getBindingResult().getModel());
    }

}
