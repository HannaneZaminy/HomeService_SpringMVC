package ir.maktab.web;

import ir.maktab.configuration.LastViewInterceptor;
import ir.maktab.dto.*;
import ir.maktab.service.ServiceService;
import ir.maktab.service.SpecialistService;
import ir.maktab.service.SubServiceService;
import ir.maktab.service.exception.DuplicatedServiceException;
import ir.maktab.service.exception.NotFoundServiceException;
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
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("subService")
public class SubServiceController {
    private final SubServiceService subServiceService;
    private final ServiceService service;
    private final SpecialistService specialistService;
    private static final Logger logger = Logger.getLogger(SubServiceController.class);

    public SubServiceController(SubServiceService subServiceService, ServiceService service, SpecialistService specialistService) {
        this.subServiceService = subServiceService;
        this.service = service;
        this.specialistService = specialistService;
    }


    @GetMapping("/addNewSubService")
    public String addNewSubService(Model model) {
        model.addAttribute("newSubService", new SubServiceDto());
        model.addAttribute("serviceList", service.fetchAllServices());
        return "addNewSubService";
    }

    @PostMapping("/addNewSubService")
    public String addNewSubService(@ModelAttribute("newSubService") @Valid SubServiceDto dto) throws DuplicatedServiceException,
            NotFoundServiceException {
        subServiceService.saveNewSubService(dto);
        return "managerPage";

    }

    @GetMapping("/selectService")
    public String createOrder(Model model, HttpServletRequest request) {
        model.addAttribute("newService", new SubServiceDto());
        model.addAttribute("specialist", new SpecialistDto());
        model.addAttribute("specialistList", specialistService.fetchAllSpecialist());
        model.addAttribute("serviceList", service.fetchAllServices());
        HttpSession session = request.getSession();
        session.setAttribute("serviceList", service.fetchAllServices());
        session.setAttribute("newService", model.getAttribute("newService"));
        // session.setAttribute();
        return "selectManagerForSpecialist";
    }

    @PostMapping("/selectService")
    public String createNewOrder(@ModelAttribute("newService") @Valid SubServiceDto serviceDto, HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        serviceDto.getSpecialistDtos();
        return "selectManagerForSpecialist";
    }

    @GetMapping("/getSubServiceAdmin")
    public String getSubServicesForAdmin(@RequestParam("service") String service, Model model,
                                         @SessionAttribute("serviceList") List<ServiceDto> serviceList
            , @SessionAttribute("newService") SubServiceDto dto,
                                         HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        List<SubServiceDto> subServices = subServiceService.getSubServicesByServiceName(service);
        model.addAttribute("newService", dto);
        model.addAttribute("subServiceList", subServices);
        model.addAttribute("serviceList", serviceList);
        model.addAttribute("selectedService", service);
        model.addAttribute("specialistList", specialistService.fetchAllSpecialist());
        return "selectManagerForSpecialist";
    }

    @GetMapping("/getSubService")
    public String getSubServices(@RequestParam("service") String service, Model model,
                                 @SessionAttribute("serviceList") List<ServiceDto> serviceList
            , @SessionAttribute("newOrder") OrderDto dto,
                                 HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        List<SubServiceDto> subServices = subServiceService.getSubServicesByServiceName(service);
        model.addAttribute("newOrder", dto);
        model.addAttribute("subServiceList", subServices);
        model.addAttribute("serviceList", serviceList);
        model.addAttribute("selectedService", service);
        return "addNewOrder";
    }

    @GetMapping("/getSubServiceForSpecialist")
    public String getSubServicesSpecialist(@RequestParam("service") String service, Model model,
                                           @SessionAttribute("serviceList") List<ServiceDto> serviceList
            , @SessionAttribute("newService") SubServiceDto dto,
                                           HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        List<SubServiceDto> subServices = subServiceService.getSubServicesByServiceName(service);
        model.addAttribute("newService", dto);
        model.addAttribute("subServiceList", subServices);
        model.addAttribute("serviceList", serviceList);
        session.setAttribute("selectedService", service);
        model.addAttribute("selectedService", service);
        return "selectServiceForSpecialist";
    }

    /* @GetMapping("/getSubServicePrice")
     public String getSubServicesPrice(@RequestParam("subService") String service, Model model,
                                  @SessionAttribute("serviceList") List<ServiceDto> serviceList
             , @SessionAttribute("newOrder") OrderDto dto,
                                  HttpServletRequest request) {
         HttpSession session = request.getSession(false);
         List<SubServiceDto> subServices = subServiceService.getSubServicesByServiceName(service);
         model.addAttribute("s", dto);
         return "createNewOrderPage";
     }*/
    @ExceptionHandler({DuplicatedServiceException.class, NotFoundServiceException.class})
    public ModelAndView errorHandler(Exception e, HttpServletRequest request) {
        Map<String, Object> model = new HashMap<>();
        model.put("error", e.getLocalizedMessage());
        model.put("newOffer", new OfferDto());
        String lastView = (String) request.getSession().getAttribute(LastViewInterceptor.LAST_VIEW_ATTRIBUTE);
        return new ModelAndView(lastView, model);
    }


    @ExceptionHandler(value = BindException.class)
    public ModelAndView bindHandler(BindException ex, HttpServletRequest request) {
        String lastView = (String) request.getSession().getAttribute(LastViewInterceptor.LAST_VIEW_ATTRIBUTE);
        System.out.println(lastView);
        return new ModelAndView(lastView, ex.getBindingResult().getModel());

    }
}
