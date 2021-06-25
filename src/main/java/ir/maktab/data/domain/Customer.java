package ir.maktab.data.domain;

import ir.maktab.data.enums.UserRole;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Customer extends Users {
    @Column(unique = true, nullable = false)
    private String email;
    @OneToMany
    private List<CustomerOrder> orders = new ArrayList<>();
    @OneToMany(mappedBy = "customer")
    private List<Comments> comments = new ArrayList<>();

    public String getEmail() {
        return email;
    }

    public Customer setEmail(String email) {
        this.email = email;
        return this;
    }

    public Customer() {
        this.setRole(UserRole.Customer);
    }


    public List<CustomerOrder> getOrders() {
        return orders;
    }

    public Customer setOrders(List<CustomerOrder> orders) {
        this.orders = orders;
        return this;
    }

    public List<Comments> getComments() {
        return comments;
    }

    public Customer setComments(List<Comments> comments) {
        this.comments = comments;
        return this;
    }
}
