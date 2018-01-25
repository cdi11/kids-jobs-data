package org.charlie.kidsjobsdata.controllers;

import org.charlie.kidsjobsdata.models.Job;
import org.charlie.kidsjobsdata.models.Parent;
import org.charlie.kidsjobsdata.models.data.ChildDao;
import org.charlie.kidsjobsdata.models.data.JobDao;
import org.charlie.kidsjobsdata.models.data.ParentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;


@Controller
@RequestMapping("job")
public class JobController {

    @Autowired
    private JobDao jobDao;

    @Autowired
    private ChildDao childDao;


    // Request path: /job
    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("jobs", jobDao.findAll());
        model.addAttribute("title", "Jobs");

        return "job/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddJobForm(Model model) {
        model.addAttribute("title", "Add Job");
        model.addAttribute(new Job());

        return "job/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddJobForm(@ModelAttribute @Valid Job newJob,
                                       Errors errors, Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Job");
            return "job/add";

        }
        jobDao.save(newJob);
        return "redirect:";
    }


    @RequestMapping(value = "remove", method = RequestMethod.GET)
    public String displayRemoveJobForm(Model model) {
        model.addAttribute("jobs", jobDao.findAll());
        model.addAttribute("title", "Remove Job");
        return "job/remove";
    }

    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String processRemoveJobForm(@RequestParam int[] jobIds) {

        for (int jobId : jobIds) {
            jobDao.delete(jobId);
        }

        return "redirect:";
    }
}


