package ir.maktab.data.domain;

import ir.maktab.data.enums.UserRole;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Specialist extends Users {
    @Column(unique = true, nullable = false)
    private String email;
    private Double rate;
    @OneToMany()
    private List<Offer> offers = new ArrayList<>();
    @OneToMany
    private List<CustomerOrder> orders = new ArrayList<>();
    @Lob
    @Column(columnDefinition = "BLOB", length = 300000)
    private byte[] image;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(name = "specialist_services", joinColumns = {@JoinColumn(name = "specialist_id", referencedColumnName = "id", nullable = false, updatable = false)}, inverseJoinColumns = {@JoinColumn(name = "service_id", referencedColumnName = "id", nullable = false, updatable = false)})
    private List<SubService> services = new ArrayList<>();





    public Specialist() {
        this.setRole(UserRole.Specialist);
    }


    public Double getRate() {
        return rate;
    }

    public Specialist setRate(Double rate) {
        this.rate = rate;
        return this;
    }

    public byte[] getImage() {
        return image;
    }

    public Specialist setImage(byte[] image) {
        this.image = image;
        return this;
    }

    public List<SubService> getServices() {
        return services;
    }

    public Specialist setServices(List<SubService> services) {
        this.services = services;
        return this;
    }

    public List<Offer> getOffers() {
        return offers;
    }

    public Specialist setOffers(List<Offer> offers) {
        this.offers = offers;
        return this;
    }


    public List<CustomerOrder> getOrders() {
        return orders;
    }

    public Specialist setOrders(List<CustomerOrder> orders) {
        this.orders = orders;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Specialist setEmail(String email) {
        this.email = email;
        return this;
    }
}
