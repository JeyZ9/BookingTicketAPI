package com.demo.newairport.services;
import com.demo.newairport.entity.CustomerEntity;
import com.demo.newairport.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {


    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<CustomerEntity> getCustomer(){
        return customerRepository.findAll();
    }

    public void dropCustomer(Long customerId){
        boolean exists = customerRepository.existsById(customerId);
        if (!exists){
            throw new IllegalStateException("does not exist customer");
        }
        customerRepository.deleteById(customerId);
    }

    public CustomerEntity createCustomer(CustomerEntity customerEntity){
        Optional<CustomerEntity> customerEntityOptional = customerRepository.findCustomerEntityById(customerEntity.getCustomerId());
            if (customerEntityOptional.isPresent()) {
                throw new IllegalArgumentException("CustomerEntity already");
            }
            customerRepository.save(customerEntity);
        return customerEntity;
    }
}

