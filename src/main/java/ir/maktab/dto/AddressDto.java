package ir.maktab.dto;


public class AddressDto {
    private String city;
    private String street;
    private String zipCod;

    public String getCity() {
        return city;
    }

    public AddressDto setCity(String city) {
        this.city = city;
        return this;
    }

    public String getStreet() {
        return street;
    }

    public AddressDto setStreet(String street) {
        this.street = street;
        return this;
    }

    public String getZipCod() {
        return zipCod;
    }

    public AddressDto setZipCod(String zipCod) {
        this.zipCod = zipCod;
        return this;
    }


}
