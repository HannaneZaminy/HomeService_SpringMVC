package ir.maktab.web;

import ir.maktab.dto.CustomerDto;
import ir.maktab.dto.SpecialistDto;
import ir.maktab.dto.ManagerDto;
import ir.maktab.dto.UserDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes({"admin","manager"})
public class HomeController {

    @GetMapping
    public String goToHome() {
        return "home";
    }

    @GetMapping(value = "/admin")
    public ModelAndView goToLoginManagerPage() {
        return new ModelAndView("adminLoginPage", "manager", new ManagerDto());
    }
    @GetMapping(value = "/specialist")
    public ModelAndView goToRegisterExpertPage() {
        return new ModelAndView("specialistLoginPage", "loginSpecialist", new SpecialistDto());
    }
    @GetMapping(value = "/customer")
    public ModelAndView goToRegisterCustomerPage() {
        return new ModelAndView("customerPage", "loginCustomer", new CustomerDto());
    }



}
