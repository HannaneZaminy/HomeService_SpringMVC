package ir.maktab.dto;

import ir.maktab.data.enums.UserRole;
import ir.maktab.data.enums.UserStatus;
import ir.maktab.service.validation.ChangePasswordValidation;
import ir.maktab.service.validation.LoginValidation;
import ir.maktab.service.validation.RegisterValidation;
import ir.maktab.service.validation.ValidPassword;

import javax.validation.constraints.*;
import java.util.Date;
import java.util.Objects;

public class UserDto {
    private Integer id;
    @NotBlank(message = "Enter your Name!", groups = {RegisterValidation.class})
    private String name;
    @NotBlank(message = "Last Name Can Not Be Null!", groups = {RegisterValidation.class})
    private String lastName;
    private Date registrationDay;
    private UserRole userRole;
    @ValidPassword(groups = {LoginValidation.class, RegisterValidation.class, ChangePasswordValidation.class})
    @Size(min = 8, message = "Password must be at least 8 characters", groups = {RegisterValidation.class})
    private String password;
    private UserStatus userSituation;

    private Double wallet;

    public UserDto() {
        this.wallet = 0.0;
        this.userSituation = UserStatus.New;
    }

    public Integer getId() {
        return id;
    }

    public UserRole getRole() {
        return userRole;
    }

    public UserDto setRole(UserRole userRole) {
        this.userRole = userRole;
        return this;
    }

    public UserDto setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public UserDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserDto setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserDto setPassword(String password) {
        this.password = password;
        return this;
    }

    public UserStatus getSituation() {
        return userSituation;
    }

    public UserDto setSituation(UserStatus userSituation) {
        this.userSituation = userSituation;
        return this;
    }

    public Date getRegistrationDay() {
        return registrationDay;
    }

    public UserDto setRegistrationDay(Date registrationDay) {
        this.registrationDay = registrationDay;
        return this;
    }

    public Double getWallet() {
        return wallet;
    }

    public UserDto setWallet(Double wallet) {
        this.wallet = wallet;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserDto)) return false;
        UserDto dto = (UserDto) o;
        return getId().equals(dto.getId()) && getName().equals(dto.getName()) && getLastName().equals(dto.getLastName())  && getPassword().equals(dto.getPassword()) && userRole == dto.userRole;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getLastName(), getPassword(), userRole);
    }
}
