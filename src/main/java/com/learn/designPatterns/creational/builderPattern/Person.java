package com.learn.designPatterns.creational.builderPattern;

import java.time.LocalDate;
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

public class Person {

    private final String firstName;
    private final String lastName;
    private final LocalDate dateOfBirth;
    private final Address address;

    private Person(Builder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.dateOfBirth = builder.dateOfBirth;
        this.address = builder.address;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public Address getAddress() {
        return address;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        Person person = (Person) object;

        return Objects.equals(this.firstName, person.firstName) &&
                Objects.equals(this.lastName, person.lastName) &&
                Objects.equals(this.dateOfBirth, person.dateOfBirth) &&
                Objects.equals(this.address, person.address);

    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, dateOfBirth, address);
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + this.getFirstName() + '\'' +
                ", lastName='" + this.getLastName() + '\'' +
                ", dateOfBirth=" + this.getDateOfBirth() +
                ", address=" + this.getAddress() +
                '}';
    }

    public static final class Builder {

        private String firstName;
        private String lastName;
        private LocalDate dateOfBirth;
        private Address address;

        public Builder() {
        }

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder dateOfBirth(LocalDate dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
            return this;
        }

        public Builder address(Address address) {
            this.address = address;
            return this;
        }

        public Person build() {
            return new Person(this);
        }
    }
}
