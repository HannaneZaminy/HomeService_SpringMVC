package ir.maktab.data.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class SubService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Double basePrice;
    private String description;
    private String name;
    @ManyToOne(fetch = FetchType.EAGER)
    private Service service;
    @ManyToMany(mappedBy = "services", fetch = FetchType.EAGER)
    private List<Specialist> specialists = new ArrayList<>();
    @OneToMany(mappedBy = "subService", fetch = FetchType.LAZY)
    private List<CustomerOrder> orders = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public SubService setId(Integer id) {
        this.id = id;
        return this;
    }

    public Double getBasePrice() {
        return basePrice;
    }

    public SubService setBasePrice(Double basePrice) {
        this.basePrice = basePrice;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public SubService setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getName() {
        return name;
    }

    public SubService setName(String name) {
        this.name = name;
        return this;
    }

    public Service getService() {
        return service;
    }

    public SubService setService(Service service) {
        this.service = service;
        return this;
    }

    public List<Specialist> getSpecialists() {
        return specialists;
    }

    public SubService setSpecialists(List<Specialist> specialists) {
        this.specialists = specialists;
        return this;
    }

    public List<CustomerOrder> getOrders() {
        return orders;
    }

    public SubService setOrders(List<CustomerOrder> orders) {
        this.orders = orders;
        return this;
    }
}
