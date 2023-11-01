package com.example.SpringDocEx.domain;

import org.springframework.data.annotation.AccessType;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Year;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;

class Person {

    private final @Id Long id;
    private final String firstname, lastname;
    @Indexed private final LocalDate birthday;
    private final int age;

    private String comment;
    private @AccessType(AccessType.Type.PROPERTY) String remarks;

    static Person of(String firstname, String lastname, LocalDate birthday) {
        return new Person(null, firstname, lastname, birthday,
                (int) Duration.between(birthday, LocalDate.now()).get(ChronoUnit.YEARS));
    }

    Person(Long id, String firstname, String lastname, LocalDate birthday, int age) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthday = birthday;
        this.age = age;
    }

    Person withId(Long id) {
        return new Person(id, this.firstname, this.lastname, this.birthday, this.age);
    }

    void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}


