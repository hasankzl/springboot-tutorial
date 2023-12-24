package com.example.springboottutorial.service;


import com.example.springboottutorial.entity.Department;
import com.example.springboottutorial.error.DepartmentNotFountException;
import com.example.springboottutorial.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService{

   private final DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> fetchDepartmentList() {
        return departmentRepository.findAll();
    }

    @Override
    public Department fetchDepartmentById(Long id) throws DepartmentNotFountException {
        Optional<Department> department = departmentRepository.findById(id);

        if(!department.isPresent()){
            throw new DepartmentNotFountException("department not found");
        }
        return department.get();

    }

    @Override
    public void deleteDepartmentById(Long id) {
        departmentRepository.deleteById(id);
    }

    @Override
    public Department updateDepartment(Long departmentId, Department department) {
        Department depDB = departmentRepository.findById(departmentId).get();

        if(Objects.nonNull(department.getDepartmentName())
        && !"".equalsIgnoreCase(department.getDepartmentName())){
            depDB.setDepartmentName(department.getDepartmentName());
        }


        if(Objects.nonNull(department.getDepartmentCode())
                && !"".equalsIgnoreCase(department.getDepartmentCode())){
            depDB.setDepartmentCode(department.getDepartmentCode());
        }


        if(Objects.nonNull(department.getDepartmentAddress())
                && !"".equalsIgnoreCase(department.getDepartmentAddress())){
            depDB.setDepartmentAddress(department.getDepartmentAddress());
        }

        return departmentRepository.save(depDB);
    }

    @Override
    public List<Department> fetchDepartmentByName(String departmentName) {
        return departmentRepository.findByDepartmentNameIgnoreCase(departmentName);
    }
}
