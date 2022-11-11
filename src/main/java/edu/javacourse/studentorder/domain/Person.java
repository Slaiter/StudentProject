package edu.javacourse.studentorder.domain;

import java.time.LocalDate;

public abstract class   Person {

    protected String surName;
    protected String givenName;
    private String patronymic;
    private LocalDate dateOfBirth;
    private Address address;

    public Person() {
    }

    public Person(String surName, String givenName, String patronymic, LocalDate dataOfBirth) {
        this.surName = surName;
        this.givenName = givenName;
        this.patronymic = patronymic;
        this.dateOfBirth = dataOfBirth;
    }

    public String getPersonString() {
        return surName + " " + givenName;
    }


    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public abstract void doSomething();

    public String getSurName() {
        return surName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "surName='" + surName + '\'' +
                ", givenName='" + givenName + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", address=" + address +
                '}';
    }
}

