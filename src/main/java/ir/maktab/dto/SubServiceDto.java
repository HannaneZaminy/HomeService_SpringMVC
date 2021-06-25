package ir.maktab.dto;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class SubServiceDto {
    private Integer id;
    private Double basePrice;
    private String description;
    private String idSpecialist;
    private List<SpecialistDto> specialistDtos = new ArrayList<>();
    private List<OrderDto> orders = new ArrayList<>();
    @NotBlank(message = "Enter your Name !")
    private String name;
    private ServiceDto service;

    public List<SpecialistDto> getSpecialistDtos() {
        return specialistDtos;
    }

    public String getIdSpecialist() {
        return idSpecialist;
    }

    public SubServiceDto setIdSpecialist(String idSpecialist) {
        this.idSpecialist = idSpecialist;
        return this;
    }

    public SubServiceDto setSpecialistDtos(List<SpecialistDto> specialistDtos) {
        this.specialistDtos = specialistDtos;
        return this;
    }

    public Double getBasePrice() {
        return basePrice;
    }

    public SubServiceDto setBasePrice(Double basePrice) {
        this.basePrice = basePrice;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public SubServiceDto setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getName() {
        return name;
    }

    public SubServiceDto setName(String name) {
        this.name = name;
        return this;
    }

    public ServiceDto getService() {
        return service;
    }

    public SubServiceDto setService(ServiceDto service) {
        this.service = service;
        return this;
    }


    public List<OrderDto> getOrders() {
        return orders;
    }

    public SubServiceDto setOrders(List<OrderDto> orders) {
        this.orders = orders;
        return this;
    }

    public Integer getId() {
        return id;
    }

    public SubServiceDto setId(Integer id) {
        this.id = id;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SubServiceDto)) return false;
        SubServiceDto that = (SubServiceDto) o;
        return getId().equals(that.getId()) && getBasePrice().equals(that.getBasePrice()) && getDescription().equals(that.getDescription()) && getName().equals(that.getName()) && getService().equals(that.getService());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getBasePrice(), getDescription(), getName(), getService());
    }
}
