package ir.maktab.web;

import ir.maktab.configuration.LastViewInterceptor;
import ir.maktab.dto.OfferDto;
import ir.maktab.dto.ServiceDto;
import ir.maktab.service.ServiceService;
import ir.maktab.service.exception.DuplicatedServiceException;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/service")
public class ServiceController {
    private final ServiceService service;
    private static final Logger logger = Logger.getLogger(ServiceController.class);

    public ServiceController(ServiceService service) {
        this.service = service;
    }


    @GetMapping(value = "/addNewService")
    public String addNewService(Model model) {
        model.addAttribute("newService", new ServiceDto());
        return "addNewService";
    }

    @PostMapping(value = "/addNewService")
    public String addNewService(@ModelAttribute("newService") @Valid ServiceDto serviceDto) throws DuplicatedServiceException {
        service.saveNewService(serviceDto);
        return "managerPage";
    }

    @ExceptionHandler({DuplicatedServiceException.class})
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
