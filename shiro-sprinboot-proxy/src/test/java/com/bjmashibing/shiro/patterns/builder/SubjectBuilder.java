package com.bjmashibing.shiro.patterns.builder;

import java.util.Date;

/**
 * <p></p>
 *
 * @author sunzhiqiang23
 * @date 2020-06-13 17:28
 */
public class SubjectBuilder {
    private int id = 1;
    private String firstname = "first";
    private String lastname = "last";
    private Date birthdate = new Date();
    private String street = "street";

    public SubjectBuilder(int id, String firstname, String lastname, Date birthdate, String street) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthdate = birthdate;
        this.street = street;
    }

    public SubjectBuilder Build() {
        return new SubjectBuilder(id, firstname, lastname, birthdate, street);
    }

    public SubjectBuilder WithFirstName(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public SubjectBuilder WithLastName(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public SubjectBuilder WithBirthDate(Date birthdate) {
        this.birthdate = birthdate;
        return this;
    }

    public SubjectBuilder WithStreet(String street) {
        this.street = street;
        return this;
    }
}
