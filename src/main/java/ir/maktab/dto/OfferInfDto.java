package ir.maktab.dto;

import ir.maktab.data.enums.OfferStatus;

import java.util.Date;

public class OfferInfDto {

    private Date startDate;
    private Date endDate;
    private OfferStatus offerStatus;
    private Double OfferPrice;

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }


    public OfferStatus getOfferStatus() {
        return offerStatus;
    }

    public OfferInfDto setOfferStatus(OfferStatus offerStatus) {
        this.offerStatus = offerStatus;
        return this;
    }

    public Double getOfferPrice() {
        return OfferPrice;
    }

    public OfferInfDto setStartDate(Date startDate) {
        this.startDate = startDate;
        return this;
    }

    public OfferInfDto setEndDate(Date endDate) {
        this.endDate = endDate;
        return this;
    }

    public OfferInfDto setOfferPrice(Double offerPrice) {
        OfferPrice = offerPrice;
        return this;
    }
}
