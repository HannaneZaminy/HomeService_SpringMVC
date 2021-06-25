package ir.maktab.data.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @OneToMany(mappedBy = "service",fetch = FetchType.EAGER)
    private List<SubService> subServices = new ArrayList<>();


    public Integer getId() {
        return id;
    }

    public Service setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Service setName(String name) {
        this.name = name;
        return this;
    }

    public List<SubService> getSubServices() {
        return subServices;
    }

    public Service setSubServices(List<SubService> subServices) {
        this.subServices = subServices;
        return this;
    }


}
