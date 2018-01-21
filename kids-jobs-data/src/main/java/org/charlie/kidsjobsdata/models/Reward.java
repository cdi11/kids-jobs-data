package org.charlie.kidsjobsdata.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;


@Entity
public class Reward {

    @Id
    @GeneratedValue
    private int id;


    @NotNull
    @Size(min = 3, max = 15)
    private String name;

    @ManyToMany
    private List<Child> children;




    public Reward(String name) {
        this();
        this.name = name;

    }

    public int getId() {
        return id;
    }

    public Reward() {

    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Child> getChildren() { return children; }

}
