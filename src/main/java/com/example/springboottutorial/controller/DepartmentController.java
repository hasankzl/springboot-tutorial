package com.example.springboottutorial.controller;


import com.example.springboottutorial.entity.Department;
import com.example.springboottutorial.error.DepartmentNotFountException;
import com.example.springboottutorial.repository.DepartmentRepository;
import com.example.springboottutorial.service.DepartmentService;
import com.example.springboottutorial.service.DepartmentServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class DepartmentController {

    private final DepartmentService departmentService;

    private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }


    @PostMapping("/departments")
    public Department saveDepartment(@Valid @RequestBody Department department){
        LOGGER.info("Inside saveDepartment of DepartmentController");
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/departments")
    public List<Department> fetchDepartmentList(){
        LOGGER.info("Inside fetchDepartmentList of DepartmentController");

        return departmentService.fetchDepartmentList();
    }

    @GetMapping("/departments/{id}")
    public Department fetchDepartmentById(@PathVariable Long id) throws DepartmentNotFountException {
        LOGGER.info("Inside fetchDepartmentById of DepartmentController");
        return departmentService.fetchDepartmentById(id);
    }

    @DeleteMapping("/departments/{id}")
    public String deleteDepartmentById(@PathVariable Long id){
        LOGGER.info("Inside deleteDepartmentById of DepartmentController");
         departmentService.deleteDepartmentById(id);
        return "Department deleted successfully";
    }

    @PutMapping("/departments/{id}")
    public Department updateDepartment(@PathVariable("id") Long departmentId,
                                       @RequestBody Department department){
        LOGGER.info("Inside updateDepartment of DepartmentController");

        return departmentService.updateDepartment(departmentId,department);
    }

    @GetMapping("/departments/name/{name}")
    public List<Department> fetchDepartmentByName(@PathVariable("name") String departmentName){
        LOGGER.info("Inside fetchDepartmentByName of DepartmentController");

        return departmentService.fetchDepartmentByName(departmentName);
    }
}
