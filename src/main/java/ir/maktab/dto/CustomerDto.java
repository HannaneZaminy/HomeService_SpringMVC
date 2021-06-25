package ir.maktab.dto;

import ir.maktab.data.enums.UserRole;
import ir.maktab.data.enums.UserStatus;
import ir.maktab.service.validation.LoginValidation;
import ir.maktab.service.validation.RegisterValidation;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

public class CustomerDto extends UserDto {
    private List<OrderDto> orders = new ArrayList<>();
    private List<CommentDto> comments = new ArrayList<>();
    @Email(message = "Invalid Email")
    @NotBlank(message = "Email Can Not Be Null!", groups = {LoginValidation.class, RegisterValidation.class})
    private String email;
    public CustomerDto() {
        super.setWallet(0.0);
        super.setRole(UserRole.Customer);
        super.setSituation(UserStatus.New);
    }

    public List<OrderDto> getOrders() {
        return orders;
    }

    public CustomerDto setOrders(List<OrderDto> orders) {
        this.orders = orders;
        return this;
    }

    public List<CommentDto> getComments() {
        return comments;
    }

    public CustomerDto setComments(List<CommentDto> comments) {
        this.comments = comments;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public CustomerDto setEmail(String email) {
        this.email = email;
        return this;
    }
}
