package com.example.demo.controllers;

import com.example.demo.models.Department;
import com.example.demo.repositories.DepartmentRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

import java.util.ArrayList;

@Controller
public class DepartmentController {


    @GetMapping("/departments")
    public String allDepartments(Model model){
        DepartmentRepository repo = new DepartmentRepository();

        ArrayList<Department> list = repo.getAllDepartments();
        /*for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }*/
        model.addAttribute("departments", list);
        return "departments";
    }
}
