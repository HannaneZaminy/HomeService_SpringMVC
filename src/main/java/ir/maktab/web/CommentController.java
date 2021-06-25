package ir.maktab.web;

import ir.maktab.configuration.LastViewInterceptor;
import ir.maktab.dto.CommentDto;
import ir.maktab.dto.LoginCustomerDto;
import ir.maktab.dto.OrderDto;
import ir.maktab.service.CommentService;
import ir.maktab.service.SpecialistService;
import ir.maktab.service.exception.*;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/comment")
@SessionAttributes("comment")
public class CommentController {
    private static final Logger logger = Logger.getLogger(CommentController.class);
    private final CommentService commentService;
    private final SpecialistService specialistService;

    public CommentController(CommentService commentService, SpecialistService expertService) {
        this.commentService = commentService;
        this.specialistService = expertService;
    }

    @GetMapping("/addComment/{id}")
    public ModelAndView addComment(@PathVariable("id") Integer id) {
        CommentDto commentDto = new CommentDto();
        OrderDto orderDto = new OrderDto();
        orderDto.setId(id);
        commentDto.setOrderDto(orderDto);
        return new ModelAndView("addNewComment", "comment", commentDto);
    }


    @PostMapping("/addComment")
    public String addComment(@ModelAttribute("comment") @Valid CommentDto dto)
            throws NotFoundOrderException {

        commentService.saveNewComment(dto);
        return "customerHomePage";
    }


    @ExceptionHandler({NotFoundOrderException.class, NotFoundSpecialistException.class})
    public ModelAndView errorHandler(Exception e, HttpServletRequest request) {
        Map<String, Object> model = new HashMap<>();
        logger.error("exception occurred: " + e.getMessage());
        model.put("error", e.getLocalizedMessage());
        model.put("comment", new LoginCustomerDto());
        String lastView = (String) request.getSession().getAttribute(LastViewInterceptor.LAST_VIEW_ATTRIBUTE);
        System.out.println(lastView);
        return new ModelAndView(lastView, model);
    }


    @ExceptionHandler(value = BindException.class)
    public ModelAndView bindHandler(BindException ex, HttpServletRequest request) {
        logger.error("exception occurred: " + ex.getMessage());
        String lastView = (String) request.getSession().getAttribute(LastViewInterceptor.LAST_VIEW_ATTRIBUTE);
        return new ModelAndView(lastView, ex.getBindingResult().getModel());
    }


}

