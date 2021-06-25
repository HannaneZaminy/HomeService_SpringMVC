package ir.maktab.web;

import ir.maktab.configuration.LastViewInterceptor;
import ir.maktab.dto.*;
import ir.maktab.service.ServiceService;
import ir.maktab.service.SpecialistService;
import ir.maktab.service.OrderService;
import ir.maktab.service.SubServiceService;
import ir.maktab.service.exception.*;
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
@RequestMapping(value = "/specialist")
@SessionAttributes({"specialist", "loginSpecialist"})
public class SpecialistController {
    private final SpecialistService specialistService;
    private final ServiceService serviceService;
    private final SubServiceService subServiceService;
    private final OrderService orderService;
    private static final Logger logger = Logger.getLogger(SpecialistController.class);

    public SpecialistController(SpecialistService expertService, ServiceService serviceService, SubServiceService subServiceService, OrderService orderService) {
        this.specialistService = expertService;
        this.serviceService = serviceService;
        this.subServiceService = subServiceService;
        this.orderService = orderService;
    }

    @GetMapping("/register")
    public ModelAndView goToSpecialistRegisterPage() {
        return new ModelAndView("specialistRegisterPage", "specialist", new SpecialistDto());
    }


    @PostMapping(value = "/register")
    public String saveNewSpecialist(@ModelAttribute("specialist") @Validated(RegisterValidation.class) SpecialistDto expertDto, Model model)
            throws DuplicatedEmailAddressException {
        SpecialistDto expert = specialistService.saveNewSpecialist(expertDto);
        return "specialistHomePage";
    }

    @GetMapping("/profile")
    public String goToProfile() {
        return "specialistHomePage";
    }

    @GetMapping("/login")
    public ModelAndView goToLoginExpertPage() {
        return new ModelAndView("specialistLoginPage", "loginSpecialist", new SpecialistDto());
    }

    @PostMapping("/login")
    public String loginSpecialist(@ModelAttribute("loginSpecialist") @Validated(LoginValidation.class) SpecialistDto dto, Model model)
            throws NotFoundSpecialistException, InvalidPasswordException {
        SpecialistDto specialistDto = specialistService.loginSpecialist(dto);
        model.addAttribute("credit", specialistDto.getWallet());
        return "specialistHomePage";
    }

    @GetMapping("/changePassword")
    public String changePassword(Model model) {
        model.addAttribute("changePassword", new SpecialistDto());
        return "specialistPassworsChange";
    }

    @GetMapping("/showRate")
    public String showRate(HttpServletRequest request,Model model) {
        HttpSession session = request.getSession(false);
        SpecialistDto specialistDto = (SpecialistDto) session.getAttribute("specialist");
        SpecialistDto loginloginSpecialist = (SpecialistDto) session.getAttribute("loginSpecialist");
        if (specialistDto != null) {
            model.addAttribute("specialistRate",specialistDto.getWallet());
        }
        if (loginloginSpecialist != null) {
            model.addAttribute("specialistRate",loginloginSpecialist.getWallet());
        }

        return  "ratePage";
    }



    @GetMapping("/selectService")
    public String selectService(Model model, HttpServletRequest request) {
        model.addAttribute("newService", new SubServiceDto());
        model.addAttribute("serviceList", serviceService.fetchAllServices());
        HttpSession session = request.getSession();
        session.setAttribute("serviceList", serviceService.fetchAllServices());
        session.setAttribute("newService", model.getAttribute("newService"));
        session.setAttribute("selectedService",new ServiceDto());
        return "selectServiceForSpecialist";
    }
//nul mishe ?
    @GetMapping("/selectService/{id}")
    public String selectService(@PathVariable("id") Integer id,HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        SpecialistDto specialist = (SpecialistDto) session.getAttribute("specialist");
        SpecialistDto loginSpecialist = (SpecialistDto) session.getAttribute("loginSpecialist");
        SpecialistDto dto = new SpecialistDto();
       // ServiceDto selectedService = (ServiceDto) session.getAttribute("selectedService");
        SubServiceDto subServiceDto = new SubServiceDto();
        subServiceDto.setId(id);
       // subServiceDto.setService(selectedService);
        if (specialist != null)
            dto.setEmail(specialist.getEmail());
        if (loginSpecialist != null)
            dto.setEmail(loginSpecialist.getEmail());
        //dto.getServices().add(subServiceDto);
        specialistService.selectServiceForSpecialist(subServiceDto,dto);
        return "specialistHomePage";
    }
    @PostMapping("/changePassword")
    public String changePassword(HttpServletRequest request, @ModelAttribute("changePassword") SpecialistDto dto) {
        HttpSession session = request.getSession(false);
        SpecialistDto specialistDto = (SpecialistDto) session.getAttribute("specialist");
        SpecialistDto loginloginSpecialist = (SpecialistDto) session.getAttribute("loginSpecialist");
        if (specialistDto != null) {
            dto.setEmail(specialistDto.getEmail());
            specialistService.changePassword(dto);
        }
        if (loginloginSpecialist != null) {
            dto.setEmail(loginloginSpecialist.getEmail());
            specialistService.changePassword(dto);
        }
        return "specialistHomePage";
    }
    @GetMapping("/showOrdersToSendOffer")
    public String showOrders(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession(false);
        SpecialistDto specialist = (SpecialistDto) session.getAttribute("specialist");
        SpecialistDto loginSpecialist = (SpecialistDto) session.getAttribute("loginSpecialist");
        if (specialist != null) {
            model.addAttribute("ordersList", orderService.fetchAllOrdersForOfferSpecialist());
        }
        if (loginSpecialist != null) {
            model.addAttribute("ordersList", orderService.fetchAllOrdersForOfferSpecialist());
        }
        return "SpecialistOrdersToSendOffer";
    }

    @PostMapping("/sendOffer")
    public String sendOffer(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession(false);
        SpecialistDto expert = (SpecialistDto) session.getAttribute("specialist");
        SpecialistDto loginExpert = (SpecialistDto) session.getAttribute("loginSpecialist");
        if (expert != null) {
            model.addAttribute("ordersList", orderService.fetchAllOrdersForOfferSpecialist());
        }
        if (loginExpert != null) {
            model.addAttribute("ordersList", orderService.fetchAllOrdersForOfferSpecialist());
        }
        return "SpecialistOrdersToSendOffer";
    }

    @GetMapping("/taskManagement")
    public String showSuggestion(Model model, HttpServletRequest request)
            throws NotFoundOrderException {

        HttpSession session = request.getSession(false);
        SpecialistDto specialist = (SpecialistDto) session.getAttribute("specialist");
        SpecialistDto loginExpert = (SpecialistDto) session.getAttribute("loginSpecialist");
        if (specialist != null) {
            model.addAttribute("orderList", orderService.findBySpecialist(specialist));
        }
        if (loginExpert != null) {
            model.addAttribute("ordersList", orderService.findBySpecialist(loginExpert));
        }
        return "specialistTaskManeger";
    }


    @ExceptionHandler({NotFoundSpecialistException.class, InvalidPasswordException.class, DuplicatedEmailAddressException.class,
            NotFoundSubServiceException.class, NotFoundOrderException.class
    })
    public ModelAndView errorHandler(Exception e, HttpServletRequest request) {
        Map<String, Object> model = new HashMap<>();
        model.put("error", e.getLocalizedMessage());
        model.put("loginSpecialist", new SpecialistDto());
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
