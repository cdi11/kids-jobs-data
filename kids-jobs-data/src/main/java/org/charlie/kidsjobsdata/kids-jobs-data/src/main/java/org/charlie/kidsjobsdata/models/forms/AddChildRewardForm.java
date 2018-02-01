package org.charlie.kidsjobsdata.models.forms;

import org.charlie.kidsjobsdata.models.Child;
import org.charlie.kidsjobsdata.models.Reward;

import javax.validation.constraints.NotNull;

public class AddChildRewardForm {


    @NotNull
    private int childId;

    @NotNull
    private int rewardId;

    private Iterable<Reward> rewards;

    private Child child;

    public AddChildRewardForm() {}

    public AddChildRewardForm(Iterable<Reward> rewards, Child child) {
        this.rewards = rewards;
        this.child = child;

    }

    public int getChildId() {return childId; }

    public void setChildId(int childId) { this.childId = childId; }

    public int getRewardId() {return rewardId; }

    public void setRewardId(int rewardId) {this.rewardId= rewardId; }

    public Iterable<Reward> getRewards() { return rewards; }

    public Child getChild() {
        return child;
    }

}

