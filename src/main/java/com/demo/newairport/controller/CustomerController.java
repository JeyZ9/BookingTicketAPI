package com.demo.newairport.controller;
import com.demo.newairport.entity.CustomerEntity;
import com.demo.newairport.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customers")
@CrossOrigin(origins = "http://localhost:5173")
public class CustomerController {


    private  final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @DeleteMapping("/drop/{customerId}")
    public void dropCustomer(@PathVariable("customerId") Long customerId) {
        customerService.dropCustomer(customerId);
    }

//    @PostMapping("/create")
//    public void addCustomer(@RequestBody CustomerEntity, @RequestParam("firstName") String firstName,
//                               @RequestParam("lastName") String lastName,
//                               @RequestParam("email") String email,
//                               @RequestParam("number") int number,
//                               @RequestParam("nationality") String nationality,
//                               @RequestParam("dateOfBirth") Date dateOfBirth
//                               ){
//        try{
//            CustomerEntity customerEntity = new CustomerEntity(firstName, lastName, email, number, nationality, dateOfBirth);
//            customerService.createCustomer(customerEntity);
//        }catch (Exception e){
//            throw new RuntimeException(e);
//        }
//    }

    @PostMapping("/create")
    public ResponseEntity<CustomerEntity> addCustomer(@RequestBody CustomerEntity customerEntity) {
        try {
            CustomerEntity createdCustomer = customerService.createCustomer(customerEntity);
            return ResponseEntity.ok(createdCustomer);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PutMapping("/update/{customerId}")
    public ResponseEntity<CustomerEntity> updateCustomer(@PathVariable Long customerId, @RequestBody CustomerEntity customerEntity){
        try{
            CustomerEntity updatedCustomer = customerService.updateCustomer(customerId, customerEntity);
            return ResponseEntity.status(HttpStatus.CREATED).body(updatedCustomer);
        }catch (RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/get")
    public List<CustomerEntity> getFlights(){
        return customerService.getCustomer();
    }

    @GetMapping("/get/{customerId}")
    public Optional<CustomerEntity> getCustomerById(@PathVariable Long customerId){
        return customerService.getCustomerById(customerId);
    }
}
