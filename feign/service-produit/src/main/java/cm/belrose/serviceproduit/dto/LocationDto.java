package cm.belrose.serviceproduit.dto;

public class LocationDto {
    private Long id;
    private String city;
    private Long zipCode;
    private String street;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Long getZipCode() {
        return zipCode;
    }

    public void setZipCode(Long zipCode) {
        this.zipCode = zipCode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Override
    public String toString() {
        return "LocationDto{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", zipCode=" + zipCode +
                ", street='" + street + '\'' +
                '}';
    }
}
