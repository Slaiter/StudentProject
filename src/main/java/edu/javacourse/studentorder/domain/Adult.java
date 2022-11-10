package edu.javacourse.studentorder.domain;

import java.time.LocalDate;

public class Adult extends Person {

    private String passportSeria;
    private String passportNumber;
    private LocalDate issueDate;
    private PassportOffice issueDepartment;

    private University university;
    private String studentId;

    public Adult(String surName,
                 String givenName,
                 String patronymic,
                 LocalDate dataOfBirth) {
        super(
            surName,
            givenName,
            patronymic,
            dataOfBirth
        );
    }

    public Adult() {
    }

    public String getSurName() {
        return "";
    }

    public String getPersonString() {
        return surName + " " + givenName + ":" + passportNumber;
    }

    public String getPassportSeria() {
        return passportSeria;
    }

    public void setPassportSeria(String passportSeria) {
        this.passportSeria = passportSeria;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public PassportOffice getIssueDepartment() {
        return issueDepartment;
    }

    public void setIssueDepartment(PassportOffice issueDepartment) {
        this.issueDepartment = issueDepartment;
    }

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    @Override
    public void doSomething() {
        System.out.println("I am adult");
    }
}
