package org.charlie.kidsjobsdata.models.forms;

import org.charlie.kidsjobsdata.models.Child;
import org.charlie.kidsjobsdata.models.Job;

import javax.validation.constraints.NotNull;

public class AddChildJobForm {

    @NotNull
    private int childId;


    private int jobId;

    private Iterable<Job> jobs;

    private Child child;

    public AddChildJobForm() {}

    public AddChildJobForm(Iterable<Job> jobs, Child child) {
        this.jobs = jobs;
        this.child = child;

    }

    public int getChildId() {return childId; }

    public void setChildId(int childId) { this.childId = childId; }

    public int getJobId() {return jobId; }

    public void setJobId(int jobId) {this.jobId= jobId; }

    public Iterable<Job> getJobs() { return jobs; }

    public Child getChild() {
        return child;
    }

}

