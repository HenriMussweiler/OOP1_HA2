public class Address {
    private String street;
    private String streetNumber;
    private String zipcode;
    private String city;

    public Address(String street, String streetNumber, String zipcode, String city) {
        this.street = street;
        this.streetNumber = streetNumber;
        this.zipcode = zipcode;
        this.city = city;
    }

    public String toString (){
        return this.street + " " + this.streetNumber + "\n"
                + this.zipcode + " " + this.city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
