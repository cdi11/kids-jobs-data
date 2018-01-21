package org.charlie.kidsjobsdata.controllers;




        import org.charlie.kidsjobsdata.models.Parent;
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
@RequestMapping("parent")
public class ParentController {

    @Autowired
    private ParentDao parentDao;


    // Request path: /parent
    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("parents", parentDao.findAll());
        model.addAttribute("title", "Parents");

        return "parent/index";
    }

    @RequestMapping(value = "signup", method = RequestMethod.GET)
    public String displayFirstAddParentForm(Model model) {
        model.addAttribute("title", "Parent Signup");
        model.addAttribute(new Parent());

        return "parent/signup";
    }

    @RequestMapping(value = "signup", method = RequestMethod.POST)
    public String processFirstAddParentForm(@ModelAttribute @Valid Parent newParent,
                                       Errors errors, Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Parent Signup");
            return "parent/signup";

        }
        parentDao.save(newParent);
        return "redirect:";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddParentForm(Model model) {
        model.addAttribute("title", "Add Parent");
        model.addAttribute(new Parent());

        return "parent/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddParentForm(@ModelAttribute @Valid Parent newParent,
                                       Errors errors, Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Parent");
            return "parent/add";

        }
        parentDao.save(newParent);
        return "redirect:";
    }


    @RequestMapping(value = "signin", method = RequestMethod.GET)
    public String displaySigninForm(Model model) {
        model.addAttribute("title", "Parent Signin");
        model.addAttribute(new Parent());

        return "parent/signin";
    }




    @RequestMapping(value = "remove", method = RequestMethod.GET)
    public String displayRemoveParentForm(Model model) {
        model.addAttribute("parents", parentDao.findAll());
        model.addAttribute("title", "Remove Parent");
        return "parent/remove";
    }

    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String processRemoveParentForm(@RequestParam int[] parentIds) {

        for (int parentId : parentIds) {
            parentDao.delete(parentId);
        }

        return "redirect:";
    }
}


