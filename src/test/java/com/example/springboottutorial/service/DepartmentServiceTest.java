package com.example.springboottutorial.service;

import com.example.springboottutorial.entity.Department;
import com.example.springboottutorial.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentServiceTest {

    @Autowired
    private DepartmentService departmentService;
    @MockBean
    private DepartmentRepository departmentRepository;

    @BeforeEach
    void setUp() {
        Department department =
                Department.builder().departmentName("IT")
                        .departmentAddress("Istanbul")
                        .departmentCode("IT-6")
                        .departmentId(1L)
                        .build();

        Mockito.when(departmentRepository.findByDepartmentNameIgnoreCase("IT"))
                .thenReturn(Arrays.asList(department));

    }

    @Test
    @DisplayName("get data based on valid department name")
    public void whenValidDepartmentName_thanDepartmentShouldFound() {

        String departmentName = "IT";
        List<Department> found = departmentService.fetchDepartmentByName(departmentName);

        assertEquals(departmentName, found.get(0).getDepartmentName());
    }
}