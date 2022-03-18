package com.in28minutes.database.databasedemo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import java.util.Date;


@Entity //we could have gone with @Table(name="table in db name too, but here both are same
@NamedQuery(name="find_all_persons", query="select p from Person p") //the Person here is actully our entitiy class name below used, it is not from database, this is actually called JPQL
public class Person {

    @Id //primary key
    @GeneratedValue //hibernate please generate this for us whenever
    private int id;

    //@Column we can give but here also names are same so no need
    private String name;
    private String location;
    private Date birthDate;

    public Person() {

    }

    public Person(int id, String name, String location, Date birthDate) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.birthDate = birthDate;
    }

    //we willallow hibernate to create id for us
    public Person(String name, String location, Date birthDate) {
        this.name = name;
        this.location = location;
        this.birthDate = birthDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}
