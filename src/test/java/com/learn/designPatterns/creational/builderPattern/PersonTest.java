package com.learn.designPatterns.creational.builderPattern;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class PersonTest {

    @Test
    public void emptyBuilder() {
        Person person = new Person.Builder().build();
        print(person);
    }

    @Test
    public void builder() {
        Address address = new Address.Builder()
                .firstLine("firstLine")
                .street("street")
                .locality("locality")
                .city("city")
                .zipcode(0)
                .build();

        Person person = new Person.Builder()
                .firstName("firstName")
                .lastName("lastName")
                .dateOfBirth(LocalDate.now())
                .address(address)
                .build();
        print(person);
    }

    @Test
    public void immutability() {
        Address.Builder addressBuilder = new Address.Builder();
        addressBuilder
                .firstLine("firstLine")
                .street("street")
                .locality("locality")
                .city("city")
                .zipcode(0);

        Address address = addressBuilder.build();

        Person.Builder personBuilder = new Person.Builder();

        personBuilder
                .firstName("firstName")
                .lastName("lastName")
                .dateOfBirth(LocalDate.now())
                .address(address);

        Person person = personBuilder.build();

        print(person);

        System.out.println("person or address cannot be changed because there are not setters or constructors");

        Assertions.assertThrows(InstantiationException.class, () -> person.getClass().newInstance(), "person or address cannot be changed because there are not setters or constructors");
        Assertions.assertThrows(NoSuchMethodException.class, () -> person.getClass().getDeclaredConstructor().newInstance(), "person or address cannot be changed because there are not setters or constructors");
    }

    private void print(Person person) {
        System.out.println(person);
    }
}