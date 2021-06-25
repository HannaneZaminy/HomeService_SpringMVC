package ir.maktab.web;

import ir.maktab.configuration.LastViewInterceptor;
import ir.maktab.dto.SpecialistDto;
import ir.maktab.dto.OfferDto;
import ir.maktab.dto.OrderDto;
import ir.maktab.service.OfferService;
import ir.maktab.service.exception.*;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("offer")
@SessionAttributes({"newOffer"})
public class OfferController {
    private final OfferService offerService;
    private static final Logger logger = Logger.getLogger( OfferController.class);
    public OfferController(OfferService offerService) {
        this.offerService = offerService;
    }


    @GetMapping("/sendOffer/{id}")
    public ModelAndView sendOffer(@PathVariable("id") Integer id, HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        SpecialistDto expert = (SpecialistDto) session.getAttribute("specialist");
        SpecialistDto loginExpert = (SpecialistDto) session.getAttribute("loginSpecialist");
        OfferDto offerDto = new OfferDto();
        OrderDto dto = new OrderDto();
        dto.setId(id);
        offerDto.setOrders(dto);
        if (expert != null) {
            offerDto.setSpecialistDto(expert);
        }
        if (loginExpert != null) {
            offerDto.setSpecialistDto(loginExpert);
        }
        return new ModelAndView("addNewOffer", "newOffer", offerDto);
    }

    @PostMapping("/createOffer")
    public String createOffer(@ModelAttribute("newOffer") @Valid OfferDto dto, HttpServletRequest request)
            throws LessOfferPriceException,
            NotSubServiceInExpertsListException,
            NotFoundSpecialistException,
            NotFoundOrderException {

        HttpSession session = request.getSession(false);
        OfferDto newOffer = (OfferDto) session.getAttribute("newOffer");
        dto.setSpecialistDto(newOffer.getSpecialistDto());
        dto.getOrders().setId(newOffer.getOrders().getId());
        offerService.saveNewOffer(dto);
        return "specialistHomePage";
    }


    @GetMapping("/selectOffer/{id}")
    public String changeSituation(@PathVariable("id") Integer id)
            throws NotFoundOrderException {
        offerService.changeSituation(id);
        return "customerHomePage";

    }


    @ExceptionHandler({LessOfferPriceException.class, NotSubServiceInExpertsListException.class
            , NotFoundSpecialistException.class, NotFoundOrderException.class})
    public ModelAndView errorHandler(Exception e, HttpServletRequest request) {
        Map<String, Object> model = new HashMap<>();
        logger.error("exception occurred: " + e.getMessage());
        model.put("error", e.getLocalizedMessage());
        model.put("newOffer", new OfferDto());
        String lastView = (String) request.getSession().getAttribute(LastViewInterceptor.LAST_VIEW_ATTRIBUTE);
        return new ModelAndView(lastView, model);
    }

    @ExceptionHandler(value = BindException.class)
    public ModelAndView bindHandler(BindException ex, HttpServletRequest request) {
        String lastView = (String) request.getSession().getAttribute(LastViewInterceptor.LAST_VIEW_ATTRIBUTE);
        logger.error("exception occurred: " + ex.getMessage());
        return new ModelAndView(lastView, ex.getBindingResult().getModel());

    }

}
