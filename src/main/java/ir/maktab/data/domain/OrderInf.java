package ir.maktab.data.domain;

import ir.maktab.data.enums.OrderStatus;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
public class OrderInf {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    private CustomerOrder order;
    @Column
    @Enumerated(value = EnumType.STRING)
    private OrderStatus orderSituation;
    @CreationTimestamp
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date changeDate;

    public Integer getId() {
        return id;
    }

    public OrderInf setId(Integer id) {
        this.id = id;
        return this;
    }

    public CustomerOrder getOrder() {
        return order;
    }

    public OrderInf setOrder(CustomerOrder order) {
        this.order = order;
        return this;
    }

    public OrderStatus getOrderSituation() {
        return orderSituation;
    }

    public OrderInf setOrderSituation(OrderStatus orderSituation) {
        this.orderSituation = orderSituation;
        return this;
    }

    public Date getChangeDate() {
        return changeDate;
    }

    public OrderInf setChangeDate(Date changeDate) {
        this.changeDate = changeDate;
        return this;
    }
}
