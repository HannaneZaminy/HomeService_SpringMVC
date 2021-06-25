package ir.maktab.dto;

import ir.maktab.data.enums.UserRole;

import java.util.Date;

public class FilterUsersDto {
    private String name;
    private String lastName;
    private UserRole userRole;
    private Date maxDate;
    private Date minDate;
    private Integer maxNumberOfOffer;
    private Integer minNumberOfOffer;
    private Integer maxNumberOfOrder;
    private Integer minNumberOfOrder;

    public UserRole getUserRole() {
        return userRole;
    }

    public FilterUsersDto setUserRole(UserRole userRole) {
        this.userRole = userRole;
        return this;
    }

    public Date getMaxDate() {
        return maxDate;
    }

    public FilterUsersDto setMaxDate(Date maxDate) {
        this.maxDate = maxDate;
        return this;
    }

    public Date getMinDate() {
        return minDate;
    }

    public FilterUsersDto setMinDate(Date minDate) {
        this.minDate = minDate;
        return this;
    }

    public Integer getMaxNumberOfOffer() {
        return maxNumberOfOffer;
    }

    public FilterUsersDto setMaxNumberOfOffer(Integer maxNumberOfOffer) {
        this.maxNumberOfOffer = maxNumberOfOffer;
        return this;
    }

    public Integer getMinNumberOfOffer() {
        return minNumberOfOffer;
    }

    public FilterUsersDto setMinNumberOfOffer(Integer minNumberOfOffer) {
        this.minNumberOfOffer = minNumberOfOffer;
        return this;
    }

    public Integer getMaxNumberOfOrder() {
        return maxNumberOfOrder;
    }

    public FilterUsersDto setMaxNumberOfOrder(Integer maxNumberOfOrder) {
        this.maxNumberOfOrder = maxNumberOfOrder;
        return this;
    }

    public Integer getMinNumberOfOrder() {
        return minNumberOfOrder;
    }

    public FilterUsersDto setMinNumberOfOrder(Integer minNumberOfOrder) {
        this.minNumberOfOrder = minNumberOfOrder;
        return this;
    }

    public String getName() {
        return name;
    }

    public FilterUsersDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public FilterUsersDto setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public UserRole getRole() {
        return userRole;
    }

    public FilterUsersDto setRole(UserRole userRole) {
        this.userRole = userRole;
        return this;
    }

}
