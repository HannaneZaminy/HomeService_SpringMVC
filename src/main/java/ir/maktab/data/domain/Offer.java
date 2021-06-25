package ir.maktab.data.domain;

import ir.maktab.data.enums.OfferStatus;
import org.hibernate.annotations.CreationTimestamp;


import javax.persistence.*;
import java.util.Date;

@Entity
public class Offer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false, foreignKey = @ForeignKey(name = "ORDER_OFFER_FK"))
    private CustomerOrder orders;
    @CreationTimestamp
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date SubmitOffer;
    private Double offerPrice;
    private Long durationOfWork;
    @Temporal(value = TemporalType.TIME)
    private Date startTime;
    @ManyToOne
    @JoinColumn(name = "Offer_id", nullable = false, foreignKey = @ForeignKey(name = "OFFER_SPECIALIST_FK"))
    private Specialist specialist;
    @Enumerated(EnumType.STRING)
    private OfferStatus offerSituation;

    public Offer() {
    }

    public Offer(Integer id, CustomerOrder orders, Date submitOffer, Double offerPrice, Long durationOfWork, Date startTime, Specialist specialist, OfferStatus offerSituation) {
        this.id = id;
        this.orders = orders;
        SubmitOffer = submitOffer;
        this.offerPrice = offerPrice;
        this.durationOfWork = durationOfWork;
        this.startTime = startTime;
        this.specialist = specialist;
        this.offerSituation = offerSituation;
    }

    public Integer getId() {
        return id;
    }

    public Offer setId(Integer id) {
        this.id = id;
        return this;
    }

    public CustomerOrder getOrders() {
        return orders;
    }

    public Offer setOrders(CustomerOrder orders) {
        this.orders = orders;
        return this;
    }

    public Date getSubmitOffer() {
        return SubmitOffer;
    }

    public Offer setSubmitOffer(Date submitOffer) {
        SubmitOffer = submitOffer;
        return this;
    }

    public Double getOfferPrice() {
        return offerPrice;
    }

    public Offer setOfferPrice(Double offerPrice) {
        this.offerPrice = offerPrice;
        return this;
    }

    public Long getDurationOfWork() {
        return durationOfWork;
    }

    public Offer setDurationOfWork(Long durationOfWork) {
        this.durationOfWork = durationOfWork;
        return this;
    }

    public Date getStartTime() {
        return startTime;
    }

    public Offer setStartTime(Date startTime) {
        this.startTime = startTime;
        return this;
    }

    public Specialist getSpecialist() {
        return specialist;
    }

    public Offer setSpecialist(Specialist specialist) {
        this.specialist = specialist;
        return this;
    }

    public OfferStatus getOfferSituation() {
        return offerSituation;
    }

    public Offer setOfferSituation(OfferStatus offerSituation) {
        this.offerSituation = offerSituation;
        return this;
    }
}
