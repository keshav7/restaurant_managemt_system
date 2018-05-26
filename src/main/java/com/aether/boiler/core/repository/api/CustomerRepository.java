package com.aether.boiler.core.repository.api;

import com.aether.boiler.core.domain.Customer;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by keshav.gupta on 18/05/18.
 */
public interface CustomerRepository extends CrudRepository<Customer, Long> {
}
