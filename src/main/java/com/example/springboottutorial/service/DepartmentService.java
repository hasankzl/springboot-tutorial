package com.example.springboottutorial.service;

import com.example.springboottutorial.entity.Department;
import com.example.springboottutorial.error.DepartmentNotFountException;

import java.util.List;

public interface DepartmentService {
    Department saveDepartment(Department department);

    List<Department> fetchDepartmentList();

    Department fetchDepartmentById(Long id) throws DepartmentNotFountException;

    void deleteDepartmentById(Long id);

    Department updateDepartment(Long departmentId, Department department);

    List<Department> fetchDepartmentByName(String deparmentName);
}
