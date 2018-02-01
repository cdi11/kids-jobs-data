package org.charlie.kidsjobsdata.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Child {

    @Id
    @GeneratedValue
    private int id;


    @NotNull
    @Size(min = 3, max = 15)
    private String name;

    @NotNull
    @Size(min = 8, max = 25)
    private String password;

    @ManyToMany
    private List<Job> jobs;

    @ManyToMany(mappedBy = "children")
    private List<Parent> parents;

    @ManyToMany
    private List<Reward>  rewards;

    public Child(String name) {
        this.name = name;

    }

    public int getId() {
        return id;
    }

    public Child() { }

    public void addJob(Job job) { jobs.add(job); }

    public void addReward (Reward reward) { rewards.add(reward); }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Reward> getRewards() { return rewards; }

    public List<Job> getJobs() { return jobs; }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
