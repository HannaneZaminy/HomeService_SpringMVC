package ir.maktab.dto;


import javax.validation.constraints.NotBlank;
import ir.maktab.service.validation.ValidPassword;



public class ManagerDto {
    private Integer id;
    @NotBlank(message = "Enter your username")
    private String userName;
    @ValidPassword
    private String password;

    public Integer getId() {
        return id;
    }

    public ManagerDto setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public ManagerDto setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public ManagerDto setPassword(String password) {
        this.password = password;
        return this;
    }
}
