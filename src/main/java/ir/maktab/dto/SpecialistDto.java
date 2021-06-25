package ir.maktab.dto;

import ir.maktab.data.enums.UserRole;
import ir.maktab.data.enums.UserStatus;
import ir.maktab.service.validation.LoginValidation;
import ir.maktab.service.validation.RegisterValidation;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

public class SpecialistDto extends UserDto {
    private Double rate;
    @NotNull(message = "Please upload your photo")
    private byte[] photo;
    private List<SubServiceDto> services = new ArrayList<>();
    private List<OfferDto> offers = new ArrayList<>();
    private List<CommentDto> comments = new ArrayList<>();
    private List<OrderDto> orders = new ArrayList<>();
    @Email(message = "Invalid Email")
    @NotBlank(message = "Enter the email!", groups = {LoginValidation.class, RegisterValidation.class})
    private String email;

    public String getEmail() {
        return email;
    }

    public SpecialistDto setEmail(String email) {
        this.email = email;
        return this;
    }

    public SpecialistDto() {
        super.setWallet(0.0);
        super.setRole(UserRole.Specialist);
        super.setSituation(UserStatus.New);
        this.rate=0.0;
    }
    public List<OrderDto> getOrders() {
        return orders;
    }

    public SpecialistDto setOrders(List<OrderDto> orders) {
        this.orders = orders;
        return this;
    }

    public Double getRate() {
        return rate;
    }

    public SpecialistDto setRate(Double rate) {
        this.rate = rate;
        return this;
    }

    public byte[] getImage() {
        return photo;
    }

    public SpecialistDto setImage(byte[] image) {
        this.photo = image;
        return this;
    }

    public List<SubServiceDto> getServices() {
        return services;
    }

    public SpecialistDto setServices(List<SubServiceDto> services) {
        this.services = services;
        return this;
    }

    public List<OfferDto> getOffers() {
        return offers;
    }

    public SpecialistDto setOffers(List<OfferDto> offers) {
        this.offers = offers;
        return this;
    }

    public List<CommentDto> getComments() {
        return comments;
    }

    public SpecialistDto setComments(List<CommentDto> comments) {
        this.comments = comments;
        return this;
    }

}
