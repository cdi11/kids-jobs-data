package org.charlie.kidsjobsdata.models;

import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class Parent {

    @Id
    @GeneratedValue
    private int id;


    @NotNull
    @Size(min = 3, max = 15)
    private String name;


    @NotNull
    @Size(min = 8, max = 25)
    private String password;



    @NotNull
    @Size(min = 8, max = 25)
    private String confirm;

    @NotNull
    @Email
    private String email;

    @NotNull
    private int phonenumber;

    @ManyToMany
    private List<Child> children;


    public Parent(String name) {
        this.name = name;

    }

    public int getId() {
        return id;
    }

    public Parent() {

    }

    public void addChild(Child child) { children.add(child);}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirm() {
        return confirm;
    }

    public void setConfirm(String confirm) {
        this.confirm = confirm;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(int phonenumber) {
        this.phonenumber = phonenumber;
    }

    public List<Child> getChildren() { return children; }
}
