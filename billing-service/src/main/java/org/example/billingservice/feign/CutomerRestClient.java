package org.example.billingservice.feign;

import jakarta.ws.rs.Path;
import org.example.billingservice.model.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "cutomer-service")
public interface CutomerRestClient {
    @GetMapping("/api/cutomers/{id}")
    Customer getCustomerById(@PathVariable Long id);

    @GetMapping("/api/cutomers/{id}")
    PagedModel<Customer> getAllCustomers();
}
