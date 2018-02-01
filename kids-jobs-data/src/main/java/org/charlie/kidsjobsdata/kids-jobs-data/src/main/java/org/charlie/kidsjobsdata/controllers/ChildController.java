package org.charlie.kidsjobsdata.controllers;

import org.charlie.kidsjobsdata.models.Child;

import org.charlie.kidsjobsdata.models.Job;
import org.charlie.kidsjobsdata.models.Parent;
import org.charlie.kidsjobsdata.models.Reward;
import org.charlie.kidsjobsdata.models.data.ChildDao;

import org.charlie.kidsjobsdata.models.data.JobDao;
import org.charlie.kidsjobsdata.models.data.ParentDao;
import org.charlie.kidsjobsdata.models.data.RewardDao;
import org.charlie.kidsjobsdata.models.forms.AddChildJobForm;
import org.charlie.kidsjobsdata.models.forms.AddChildRewardForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Controller
@RequestMapping("child")
public class ChildController {

    @Autowired
    private ChildDao childDao;

    @Autowired
    private JobDao jobDao;

    @Autowired
    private RewardDao rewardDao;

    // Request path: /child
    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("children", childDao.findAll());
        model.addAttribute("title", "Children");

        return "child/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddChildForm(Model model) {
        model.addAttribute("title", "Add Child");
        model.addAttribute(new Child());
        model.addAttribute("jobs", jobDao.findAll());
        model.addAttribute("rewards", rewardDao.findAll());
        return "child/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddChildForm(@ModelAttribute @Valid Child newChild,
                                      Errors errors, @RequestParam int jobId, @RequestParam int rewardId,
                                      Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Child");
            model.addAttribute("jobs", jobDao.findAll());
            model.addAttribute("rewards", rewardDao.findAll());

            return "child/add";

        }
        childDao.save(newChild);
        return "redirect:";
    }


    @RequestMapping(value = "signin", method = RequestMethod.GET)
    public String displaySigninForm(Model model) {
        model.addAttribute("title", "Child Sign In");
        model.addAttribute(new Child());

        return "child/signin";
    }

    @RequestMapping(value = "remove", method = RequestMethod.GET)
    public String displayRemoveChildForm(Model model) {
        model.addAttribute("children", childDao.findAll());
        model.addAttribute("title", "Remove Child");
        return "child/remove";
    }

    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String processRemoveChildForm(@RequestParam int[] childIds) {

        for (int childId : childIds) {
            childDao.delete(childId);
        }

        return "redirect:";
    }


    @RequestMapping(value = "single/{childId}", method = RequestMethod.GET)
    public String singleChild(Model model, @PathVariable int childId) {
        Child child = childDao.findOne(childId);
        model.addAttribute("title", child.getName());
        model.addAttribute("jobs", child.getJobs());
        model.addAttribute("rewards", child.getRewards());
        model.addAttribute("childId", child.getId());

        return "child/single";


    }

    @RequestMapping(value = "add-job/{childId}", method = RequestMethod.GET)
    public String addJob(Model model, @PathVariable int childId) {

        Child child = childDao.findOne(childId);

        AddChildJobForm form = new AddChildJobForm(
                jobDao.findAll(),
                child);
        model.addAttribute("title", "Add Job to " + child.getName());
        model.addAttribute("form", form);
        return "child/add-job";
    }


    @RequestMapping(value = "add-job", method = RequestMethod.POST)
    public String addJob(Model model, @ModelAttribute @Valid AddChildJobForm form, Errors errors) {

        if (errors.hasErrors()) {
            model.addAttribute("form", form);
            return "child/add-job";

        }

        Job selectJob = jobDao.findOne(form.getJobId());
        Child theChild = childDao.findOne(form.getChildId());
        theChild.addJob(selectJob);
        childDao.save(theChild);

        return "redirect:/child/single/" + theChild.getId();


    }

    @RequestMapping(value = "add-reward/{childId}", method = RequestMethod.GET)
    public String addReward(Model model, @PathVariable int childId) {

        Child child = childDao.findOne(childId);

        AddChildRewardForm form = new AddChildRewardForm(
                rewardDao.findAll(),
                child);
        model.addAttribute("title", "Add Reward to " + child.getName());
        model.addAttribute("form", form);
        return "child/add-reward";
    }

    @RequestMapping(value = "add-reward", method = RequestMethod.POST)
    public String addReward(Model model, @ModelAttribute @Valid AddChildRewardForm form, Errors errors) {

        if (errors.hasErrors()) {
            model.addAttribute("form", form);
            return "child/add-reward";

        }

        Reward selectReward = rewardDao.findOne(form.getRewardId());
        Child theChild = childDao.findOne(form.getChildId());
        theChild.addReward(selectReward);
        childDao.save(theChild);

        return "redirect:/child/single/" + theChild.getId();

    }
}