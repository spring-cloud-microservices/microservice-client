package com.quadbaze.microservice.client.controllers;

import com.quadbaze.microservice.client.feign.resource.EmployeeSearchClient;
import com.quadbaze.microservice.common.core.Route;
import com.quadbaze.microservice.domain.entities.Employee;
import com.quadbaze.microservice.domain.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * @author Olatunji O. Longe: Created on (29/05/2018)
 */

@RestController
@RequestMapping(Route.Client.ENTRY_PATH)
public class ClientController {

    private EmployeeSearchClient employeeSearchClient;
    private EmployeeRepository employeeRepository;

    @Autowired
    public ClientController(EmployeeSearchClient employeeSearchClient, EmployeeRepository employeeRepository) {
        this.employeeSearchClient = employeeSearchClient;
        this.employeeRepository = employeeRepository;
    }

    @GetMapping("/employee/{id}")
    public Object findEmployee(@PathVariable Long id) {
        return employeeSearchClient.findById(id);
    }

    @GetMapping("/employees")
    public Collection findAllEmployees() {
        return employeeSearchClient.findAll();
    }

    @PostMapping("/employee")
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    @PutMapping("/employee")
    public Employee updateEmployee(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

}
