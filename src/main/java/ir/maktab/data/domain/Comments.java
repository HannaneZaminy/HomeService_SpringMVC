package ir.maktab.data.domain;

import javax.persistence.*;

@Entity
public class Comments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    private Customer customer;
    private String comment;
    private Double rate;
    @OneToOne
    private CustomerOrder order;


    public Integer getId() {
        return id;
    }

    public Comments setId(Integer id) {
        this.id = id;
        return this;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Comments setCustomer(Customer customer) {
        this.customer = customer;
        return this;
    }


    public String getComment() {
        return comment;
    }

    public Comments setComment(String comment) {
        this.comment = comment;
        return this;
    }

    public Double getRate() {
        return rate;
    }

    public Comments setRate(Double rate) {
        this.rate = rate;
        return this;
    }

    public CustomerOrder getOrder() {
        return order;
    }

    public Comments setOrder(CustomerOrder order) {
        this.order = order;
        return this;
    }
}
