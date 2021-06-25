package ir.maktab.data.domain;

import ir.maktab.data.enums.OrderStatus;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class CustomerOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Double finalPrice;
    private String description;
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date dateOfOrderRegistration;
    @Temporal(TemporalType.DATE)
    private Date dateOfWork;
    @Enumerated(value = EnumType.STRING)
    private OrderStatus situation;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    @ManyToOne
    private SubService subService;
    @OneToMany()
    private List<Offer> offers = new ArrayList<>();
    @ManyToOne
    private Specialist specialist;
    private Address address;
    @OneToMany
    private List<OrderInf> orderInfs=new ArrayList<>();

    public List<OrderInf> getOrderInfs() {
        return orderInfs;
    }

    public CustomerOrder setOrderInfs(List<OrderInf> orderInfs) {
        this.orderInfs = orderInfs;
        return this;
    }

    public Integer getId() {
        return id;
    }

    public CustomerOrder setId(Integer id) {
        this.id = id;
        return this;
    }

    public Address getAddress() {
        return address;
    }

    public CustomerOrder setAddress(Address address) {
        this.address = address;
        return this;
    }

    public Double getFinalPrice() {
        return finalPrice;
    }

    public CustomerOrder setFinalPrice(Double proposedPrice) {
        this.finalPrice = proposedPrice;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public CustomerOrder setDescription(String jobDescription) {
        this.description = jobDescription;
        return this;
    }

    public Date getDateOfOrderRegistration() {
        return dateOfOrderRegistration;
    }

    public CustomerOrder setDateOfOrderRegistration(Date dateOfOrderRegistration) {
        this.dateOfOrderRegistration = dateOfOrderRegistration;
        return this;
    }

    public Date getDateOfWork() {
        return dateOfWork;
    }

    public CustomerOrder setDateOfWork(Date dateOfWork) {
        this.dateOfWork = dateOfWork;
        return this;
    }

    public OrderStatus getSituation() {
        return situation;
    }

    public CustomerOrder setSituation(OrderStatus situation) {
        this.situation = situation;
        return this;
    }

    public Customer getCustomer() {
        return customer;
    }

    public CustomerOrder setCustomer(Customer customer) {
        this.customer = customer;
        return this;
    }

    public SubService getSubService() {
        return subService;
    }

    public CustomerOrder setSubService(SubService subService) {
        this.subService = subService;
        return this;
    }

    public List<Offer> getOffers() {
        return offers;
    }

    public CustomerOrder setOffers(List<Offer> offers) {
        this.offers = offers;
        return this;
    }

    public Specialist getSpecialist() {
        return specialist;
    }

    public CustomerOrder setSpecialist(Specialist specialist) {
        this.specialist = specialist;
        return this;
    }
}
