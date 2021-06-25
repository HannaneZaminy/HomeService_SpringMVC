package ir.maktab.web;

import ir.maktab.configuration.LastViewInterceptor;
import ir.maktab.dto.ManagerDto;
import ir.maktab.dto.SpecialistDto;
import ir.maktab.dto.SubServiceDto;
import ir.maktab.service.ManagerService;
import ir.maktab.service.ServiceService;
import ir.maktab.service.SpecialistService;
import ir.maktab.service.SubServiceService;
import ir.maktab.service.exception.InvalidPasswordException;
import ir.maktab.service.exception.NotFoundManagerException;
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
@RequestMapping(value = "/admin")
@SessionAttributes({"admin","manager"})
public class ManagerController {
    private static final Logger logger = Logger.getLogger(ManagerController.class);
    private final ManagerService managerService;
    public ManagerController(ManagerService managerService, SpecialistService specialistService, ServiceService serviceService, SubServiceService subServiceService) {
        this.managerService = managerService;

    }

    @GetMapping("/profile")
    public ModelAndView goToProfilePage() {
        return new ModelAndView("managerPage", "admin", new ManagerDto());
    }

    @GetMapping("/login")
    public ModelAndView goToLoginPage() {
        return new ModelAndView("managerLoginPage", "admin", new ManagerDto());
    }

    @PostMapping("/login")
    public String getSignIn(@ModelAttribute("manager") @Valid ManagerDto managerDto)
            throws NotFoundManagerException, InvalidPasswordException {

        managerService.loginManager(managerDto);
        return "managerPage";
    }


   @ExceptionHandler({NotFoundManagerException.class, InvalidPasswordException.class})
    public ModelAndView errorHandler(Exception e, HttpServletRequest request) {
        Map<String, Object> model = new HashMap<>();
        model.put("error", e.getLocalizedMessage());
        model.put("admin", new ManagerDto());
        String lastView = (String) request.getSession().getAttribute(LastViewInterceptor.LAST_VIEW_ATTRIBUTE);
        return new ModelAndView(lastView, model);
    }

    @ExceptionHandler(value = BindException.class)
    public ModelAndView bindHandler(BindException ex, HttpServletRequest request) {
        String lastView = (String) request.getSession().getAttribute(LastViewInterceptor.LAST_VIEW_ATTRIBUTE);
        return new ModelAndView(lastView, ex.getBindingResult().getModel());

    }
}
