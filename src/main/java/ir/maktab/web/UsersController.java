package ir.maktab.web;

import ir.maktab.dto.*;
import ir.maktab.service.CustomerService;
import ir.maktab.service.SpecialistService;
import ir.maktab.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "user")
public class UsersController {
    private final UserService userService;
    private final CustomerService customerService;
    private final SpecialistService specialistService;
    private static final Logger logger = Logger.getLogger(UsersController.class);
    public UsersController(UserService userService, CustomerService customerService, SpecialistService specialistService) {
        this.userService = userService;
        this.customerService = customerService;
        this.specialistService = specialistService;
    }

    @InitBinder
    public void allowEmptyDateBinding(WebDataBinder binder) {
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }


    @PostMapping(value = "/searchUser")
    public ModelAndView searchUsers(@ModelAttribute("users") FilterUsersDto dto) {

        return new ModelAndView("searchUsersPage", "usersList", userService.filterUsers(dto));

    }
    @GetMapping(value = "/searchUser")
    public String searchUsers(Model model) {
        model.addAttribute("users", new FilterUsersDto());
        logger.info("...searchUsers started...");
//        model.addAttribute("customer", customerService.fetchAllCustomers());
//        model.addAttribute("specialist", specialistService.fetchAllSpecialist());
        return "searchUsersPage";
    }
}
