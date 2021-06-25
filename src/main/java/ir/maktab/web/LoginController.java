package ir.maktab.web;

import ir.maktab.dto.CustomerDto;
import ir.maktab.service.CustomerService;
import ir.maktab.service.ManagerService;
import ir.maktab.service.SpecialistService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/Login")
@SessionAttributes({"customer","manager","specialist"})
public class LoginController {
    private final CustomerService customerService;
    private final ManagerService managerService;
    private final SpecialistService specialistService;

    public LoginController(CustomerService customerService, ManagerService managerService, SpecialistService specialistService) {
        this.customerService = customerService;
        this.managerService = managerService;
        this.specialistService = specialistService;
    }

    @GetMapping("/login")
    public ModelAndView goToLoginPage() {
        return new ModelAndView("customerPage", "loginCustomer", new CustomerDto());
    }

}
