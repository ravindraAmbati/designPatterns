package com.learn.designPatterns.creational.builderPattern;

import java.util.Objects;

/**
 * builder pattern for immutability | complexity | method chaining
 * <p>
 * public class
 * private final fields
 * private constructor
 * getters | equals | hashCode | toString
 * public static inner class builder
 * private fields
 * setters with field names
 * build method - return a new object of the main class
 **/

public class Address {

    private final String firstLine;
    private final String street;
    private final String locality;
    private final String city;
    private final int zipcode;

    private Address(Builder builder) {
        this.firstLine = builder.firstLine;
        this.street = builder.street;
        this.locality = builder.locality;
        this.city = builder.city;
        this.zipcode = builder.zipcode;
    }

    public String getFirstLine() {
        return firstLine;
    }

    public String getStreet() {
        return street;
    }

    public String getLocality() {
        return locality;
    }

    public String getCity() {
        return city;
    }

    public int getZipcode() {
        return zipcode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Address address = (Address) o;

        return Objects.equals(this.firstLine, address.firstLine) &&
                Objects.equals(this.street, address.street) &&
                Objects.equals(this.locality, address.locality) &&
                Objects.equals(this.city, address.city) &&
                Objects.equals(this.zipcode, address.zipcode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstLine, street, locality, city, zipcode);
    }

    @Override
    public String toString() {
        return "Address{" +
                "firstLine='" + this.getFirstLine() + '\'' +
                ", street='" + this.getStreet() + '\'' +
                ", locality='" + this.getLocality() + '\'' +
                ", city='" + this.getCity() + '\'' +
                ", zipcode=" + this.getZipcode() +
                '}';
    }

    public static class Builder {

        private String firstLine;
        private String street;
        private String locality;
        private String city;
        private int zipcode;

        public Builder() {
        }

        public Builder firstLine(String firstLine) {
            this.firstLine = firstLine;
            return this;
        }

        public Builder street(String street) {
            this.street = street;
            return this;
        }

        public Builder locality(String locality) {
            this.locality = locality;
            return this;
        }

        public Builder city(String city) {
            this.city = city;
            return this;
        }

        public Builder zipcode(int zipcode) {
            this.zipcode = zipcode;
            return this;
        }

        public Address build() {
            return new Address(this);
        }
    }
}
