package com.ltp.gradesubmission;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GradesController {

    public List<Grade> grades = Arrays.asList(
            new Grade("Harry", "Potions", "C-"),
            new Grade("Hermione", "Arithmacy", "A+"),
            new Grade("Neville", "Charms", "A-"));

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("grades", grades);
        return "grades";
    }

    @GetMapping("/form")
    public String myForm(Model model) {
        model.addAttribute("grade", new Grade("Mauricio", "Matematica", "70"));
        return "form";
    }

}
