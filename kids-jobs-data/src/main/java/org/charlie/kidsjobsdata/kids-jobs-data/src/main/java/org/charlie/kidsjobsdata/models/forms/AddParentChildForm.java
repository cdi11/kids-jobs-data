package org.charlie.kidsjobsdata.models.forms;

import org.charlie.kidsjobsdata.models.Child;
import org.charlie.kidsjobsdata.models.Parent;
import org.charlie.kidsjobsdata.models.Reward;

import javax.validation.constraints.NotNull;

public class AddParentChildForm {

    @NotNull
    private int parentId;

    @NotNull
    private int childId;

    private Iterable<Child> children;

    private Parent parent;

    public AddParentChildForm() {}

    public AddParentChildForm(Iterable<Child> children, Parent parent) {
        this.children = children;
        this.parent = parent;

    }

    public int getParentId() {return parentId; }

    public void setParentId(int parentId) { this.parentId = parentId; }

    public int getChildId() {return childId; }

    public void setChildId(int childId) {this.childId= childId; }

    public Iterable<Child> getChildren() { return children; }

    public Parent getParent() {
        return parent;
    }

}

