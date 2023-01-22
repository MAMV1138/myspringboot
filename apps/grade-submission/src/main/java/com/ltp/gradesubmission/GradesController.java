package com.ltp.gradesubmission;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GradesController {

    public List<Grade> studentGrades = new ArrayList<>();

    @GetMapping("/grades")
    public String index(Model model) {

        model.addAttribute("grades", studentGrades);
        return "grades";
    }

    @GetMapping("/form")
    public String myForm(Model model, @RequestParam(required = false) String name) {
        int result = findIndex(name);

        if (result == -10) {
            model.addAttribute("grade", new Grade());
        } else {
            model.addAttribute("grade", studentGrades.get(result));
        }

        return "form";
    }

    @PostMapping("/submitHandler")
    public String submitForm(Grade grade) {
        // if grade is not in the studentslist then insert
        int index = findIndex(grade.getName());
        if (index == -10) {
            studentGrades.add(grade);
        } else {
            studentGrades.set(index, grade);
        }
        // if grade is in the studentlist then modify object

        return "redirect:/grades";
    }

    private int findIndex(String name) {

        for (int i = 0; i < studentGrades.size(); i++) {
            if (studentGrades.get(i).getName().equals(name)) {
                return i;
            }
        }
        return -10;
    }

}
