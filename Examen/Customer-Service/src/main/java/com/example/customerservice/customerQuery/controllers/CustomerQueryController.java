package com.example.customerservice.customerQuery.controllers;


import com.example.commonapi.query.GetAllClientsQuery;
import com.example.commonapi.query.GetClientById;
import com.example.customerservice.customerQuery.entities.Customer;
import com.example.customerservice.customerQuery.repositories.CustomerRepository;
import lombok.AllArgsConstructor;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client/queries")
@AllArgsConstructor
@CrossOrigin("*")
public class CustomerQueryController {

    private QueryGateway queryGateway;
    private CustomerRepository customerRepository;

    @GetMapping("/getAllClients")
    public List<Customer> getAllClients(){
        return queryGateway.query(new GetAllClientsQuery(),
                ResponseTypes.multipleInstancesOf(Customer.class)).join();
    }

    @QueryHandler
    public List<Customer> on(GetAllClientsQuery query){
        return customerRepository.findAll();
    }

    @GetMapping("/getClient/{id}")
    public Customer getClient(@PathVariable String id){
        return queryGateway.query(new GetClientById(id),
                ResponseTypes.instanceOf(Customer.class)).join();
    }

    @QueryHandler
    public Customer on(GetClientById query){
        return customerRepository.findById(query
                .getId()).get();
    }
}
