package ir.maktab.dto;

import ir.maktab.data.domain.Address;
import ir.maktab.data.enums.OrderStatus;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderDto {
    private Integer id;
    private Double proposedPrice;
    @NotBlank(message = "Please enter a description !")
    private String description;
    private Date dateOfOrderRegistration;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @FutureOrPresent(message = "You are in the present")
    private Date dateOfWork;
    private OrderStatus situation;
    private CustomerDto customer;
    private SubServiceDto subService;
    private List<OfferDto> offers = new ArrayList<>();
    private SpecialistDto specialistDto;
    private Address address;

    public Address getAddress() {
        return address;
    }

    public OrderDto setAddress(Address address) {
        this.address = address;
        return this;
    }

    public Integer getId() {
        return id;
    }

    public OrderDto setId(Integer id) {
        this.id = id;
        return this;
    }

    public SpecialistDto getSpecialistDto() {
        return specialistDto;
    }

    public OrderDto setSpecialistDto(SpecialistDto specialistDto) {
        this.specialistDto = specialistDto;
        return this;
    }

    public Double getProposedPrice() {
        return proposedPrice;
    }

    public OrderDto setProposedPrice(Double proposedPrice) {
        this.proposedPrice = proposedPrice;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public OrderDto setDescription(String description) {
        this.description = description;
        return this;
    }

    public Date getDateOfOrderRegistration() {
        return dateOfOrderRegistration;
    }

    public OrderDto setDateOfOrderRegistration(Date dateOfOrderRegistration) {
        this.dateOfOrderRegistration = dateOfOrderRegistration;
        return this;
    }

    public Date getDateOfWork() {
        return dateOfWork;
    }

    public OrderDto setDateOfWork(Date dateOfWork) {
        this.dateOfWork = dateOfWork;
        return this;
    }

    public OrderStatus getSituation() {
        return situation;
    }

    public OrderDto setSituation(OrderStatus situation) {
        this.situation = situation;
        return this;
    }

    public CustomerDto getCustomer() {
        return customer;
    }

    public OrderDto setCustomer(CustomerDto customer) {
        this.customer = customer;
        return this;
    }

    public SubServiceDto getSubService() {
        return subService;
    }

    public OrderDto setSubService(SubServiceDto subService) {
        this.subService = subService;
        return this;
    }

    public List<OfferDto> getOffers() {
        return offers;
    }

    public OrderDto setOffers(List<OfferDto> offers) {
        this.offers = offers;
        return this;
    }


}
