package com.example.demo.controllers;

import com.example.demo.models.Employee;
import com.example.demo.repositories.EmployeeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

import java.util.ArrayList;

@Controller
public class EmployeeController {

    private Employee targetSearch;
    private boolean targetIsNull;


    @GetMapping("/employees")
    public String allEmployees(Model model){
        EmployeeRepository repo = new EmployeeRepository();

        ArrayList<Employee> list = repo.getAllEmployes();
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        model.addAttribute("employees", list);
        return "employees";
    }

    @GetMapping("/singleEmployee")
    public String singleEmployee(Model model){

        if(!targetIsNull){
            model.addAttribute("noId","");
        }else{
            model.addAttribute("noId","No Employee with this ID");
        }
        return "SearchEmployees";
    }
    @GetMapping("/foundEmployee")
    public String foundEmployee(Model model){
        model.addAttribute("employees",targetSearch);
        return "/TargetEmployee";
    }
    @PostMapping("/SearchForEmployees")
    public String searchEmployees(WebRequest dataFromForm) {
        EmployeeRepository employeeRepo = new EmployeeRepository();
        int employeeId = Integer.parseInt(dataFromForm.getParameter("id"));
        targetSearch = employeeRepo.searchForEmployee(employeeId);

        if (targetSearch.getName() != null) {
            targetIsNull = false;
            return "redirect:/foundEmployee";
        }else {
            targetIsNull = true;
            return "redirect:/singleEmployee";
        }
    }



    //--------------------------------------------------------------------------------------------------------------
    @GetMapping("/createEmployee")
    public String createEmployee(Model model){

        return "CreateEmployee";
    }
    @PostMapping("/employeeCreator")
    public String employeeCreator(WebRequest dataFromForm){
        EmployeeRepository employeeRepo = new EmployeeRepository();
        int id = Integer.parseInt(dataFromForm.getParameter("id"));
        String name = dataFromForm.getParameter("name");
        String job = dataFromForm.getParameter("job");
        String manager = dataFromForm.getParameter("manager");
        String hireDate = dataFromForm.getParameter("hireDate");
        int salary = Integer.parseInt(dataFromForm.getParameter("salary"));
        int commision = Integer.parseInt(dataFromForm.getParameter("commision"));
        String department = dataFromForm.getParameter("department");

        employeeRepo.createEmployee(id, name, job, manager, hireDate, salary, commision, department);

        return "redirect:/employees";
    }
}
