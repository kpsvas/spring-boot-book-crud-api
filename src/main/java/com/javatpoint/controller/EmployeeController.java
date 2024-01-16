package com.javatpoint.controller;

import com.javatpoint.model.Books;
import com.javatpoint.model.Employee;
import com.javatpoint.repository.EmployeeRepository;
import com.javatpoint.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController
{
    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping("/employees")
    private ResponseEntity<Iterable<Employee>> getAllBooks()
    {
        return new ResponseEntity<>(employeeRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/view-employee/{id}")
    private ResponseEntity<Employee> getBooks(@PathVariable("id") int id)
    {
        return new ResponseEntity<>(employeeRepository.findById(id).get(), HttpStatus.OK);
    }

    @DeleteMapping("/employees/{id}")
    private ResponseEntity<String> deleteBook(@PathVariable("id") int id)
    {
         employeeRepository.deleteById(id);
         return new ResponseEntity<>("Deleted Successfully!", HttpStatus.OK);
    }

    @PostMapping("/add-employee")
    private ResponseEntity<String> saveBook(@RequestBody Employee employee)
    {
        employeeRepository.save(employee);
        return new ResponseEntity<>("Added Successfully!", HttpStatus.OK);
    }
}
