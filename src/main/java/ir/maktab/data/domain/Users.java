package ir.maktab.data.domain;

import ir.maktab.data.enums.UserRole;
import ir.maktab.data.enums.UserStatus;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String lastName;

    @Column(nullable = false)
    private String password;
    @Enumerated(value = EnumType.STRING)
    private UserStatus userSituation;
    @Column
    @CreationTimestamp
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date date;
    @Enumerated(value = EnumType.STRING)
    private UserRole userRole;
    private Double wallet;

    public Users() {
    }

    public Double getWallet() {
        return wallet;
    }

    public Users setWallet(Double credit) {
        this.wallet = credit;
        return this;
    }

    public UserRole getRole() {
        return userRole;
    }

    public Users setRole(UserRole userRole) {
        this.userRole = userRole;
        return this;
    }

    public Integer getId() {
        return id;
    }

    public Users setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Users setName(String name) {
        this.name = name;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Users setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }


    public String getPassword() {
        return password;
    }

    public Users setPassword(String password) {
        this.password = password;
        return this;
    }

    public UserStatus getSituation() {
        return userSituation;
    }

    public Users setSituation(UserStatus userSituation) {
        this.userSituation = userSituation;
        return this;
    }

    public Date getDate() {
        return date;
    }

    public Users setDate(Date date) {
        this.date = date;
        return this;
    }
}
