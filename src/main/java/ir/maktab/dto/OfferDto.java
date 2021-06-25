package ir.maktab.dto;

import ir.maktab.data.enums.OfferStatus;
import org.springframework.format.annotation.DateTimeFormat;


import javax.validation.constraints.NotNull;
import java.util.Date;

public class OfferDto {
    private Integer id;

    @NotNull(message = "Offer Price  your username !")
    private Double offerPrice;
    private SpecialistDto specialistDto;
    private OfferStatus offerStatus;
    private Long durationOfWork;
    private OrderDto orders;
    private Date SubmitOffer;
    @DateTimeFormat(pattern = "HH:mm")
    private Date startTime;
    public OfferDto() {
        this.offerStatus = OfferStatus.registered;
    }

    public Integer getId() {
        return id;
    }

    public OfferDto setId(Integer id) {
        this.id = id;
        return this;
    }

    public OfferStatus getOfferStatus() {
        return offerStatus;
    }

    public OfferDto setOfferStatus(OfferStatus offerStatus) {
        this.offerStatus = offerStatus;
        return this;
    }

    public Date getSubmitOffer() {
        return SubmitOffer;
    }

    public OfferDto setSubmitOffer(Date submitOffer) {
        SubmitOffer = submitOffer;
        return this;
    }

    public Double getOfferPrice() {
        return offerPrice;
    }

    public OfferDto setOfferPrice(Double offerPrice) {
        this.offerPrice = offerPrice;
        return this;
    }

    public Long getDurationOfWork() {
        return durationOfWork;
    }

    public OfferDto setDurationOfWork(Long durationOfWork) {
        this.durationOfWork = durationOfWork;
        return this;
    }

    public Date getStartTime() {
        return startTime;
    }

    public OfferDto setStartTime(Date startTime) {
        this.startTime = startTime;
        return this;
    }

    public OrderDto getOrders() {
        return orders;
    }

    public OfferDto setOrders(OrderDto orders) {
        this.orders = orders;
        return this;
    }

    public SpecialistDto getSpecialistDto() {
        return specialistDto;
    }

    public OfferDto setSpecialistDto(SpecialistDto specialistDto) {
        this.specialistDto = specialistDto;
        return this;
    }
}
