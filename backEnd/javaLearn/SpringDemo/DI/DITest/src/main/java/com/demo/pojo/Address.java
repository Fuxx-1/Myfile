package com.demo.pojo;

/**
 * @author Fuxx-1
 * @date 2021年07月23日 15:15
 */
public class Address {
    private String address;

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Address{" +
                "address='" + address + '\'' +
                '}';
    }

    public String getAddress() {
        return address;
    }
}
