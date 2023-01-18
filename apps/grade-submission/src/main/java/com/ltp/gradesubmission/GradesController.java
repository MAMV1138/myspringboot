package com.ltp.gradesubmission;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class GradesController {

    public List<Grade> studentGrades = new ArrayList<>();

    @GetMapping("/grades")
    public String index(Model model) {
        model.addAttribute("grades", studentGrades);
        return "grades";
    }

    @GetMapping("/form")
    public String myForm(Model model) {
        model.addAttribute("grade", new Grade());
        return "form";
    }

    @PostMapping("/submitHandler")
    public String submitForm(Grade grade) {
        studentGrades.add(grade);
        return "redirect:/grades";
    }

}
