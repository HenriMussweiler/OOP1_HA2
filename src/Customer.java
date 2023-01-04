public class Customer {
    private String customerNumber;
    private String firstName;
    private String lastName;
    private Address address;



    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }


    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return customerNumber + " " +
                firstName + " " +
                lastName;
    }
}
