package entities;

public class Customer {
    private int customerId;
    private String name;
    private String address;

    // Constructor
    public Customer(int customerId, String name, String address) {
        this.customerId = customerId;
        this.name = name;
        this.address = address;
    }

    // Getters and Setters
    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer [ID=" + customerId + ", Name=" + name + ", Address=" + address + "]";
    }
}
