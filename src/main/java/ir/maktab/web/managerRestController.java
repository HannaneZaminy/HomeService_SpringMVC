package ir.maktab.web;

import ir.maktab.dto.FilterUsersDto;
import ir.maktab.dto.OrderDto;
import ir.maktab.dto.OrderFilterDto;
import ir.maktab.dto.UserDto;
import ir.maktab.service.OrderService;
import ir.maktab.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/managerApi")
@RestController
public class managerRestController {
    private final UserService userService;
private final OrderService orderService;
    public managerRestController(UserService userService, OrderService orderService) {
        this.userService = userService;
        this.orderService = orderService;
    }

    @GetMapping
    @ResponseBody
    public List<UserDto> findAll() {
        return userService.fetchAllUsers();
    }

    @PostMapping(value = "/filterUsers",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<?> filterUsers(@RequestBody FilterUsersDto filterUsersDto) {
        List<UserDto> list = userService.filterUsers(filterUsersDto);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    @PostMapping(value = "/filterOrder",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<?> filterOrder(@RequestBody OrderFilterDto filterDto) {
        List<OrderDto> list = orderService.filterOrders(filterDto);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
