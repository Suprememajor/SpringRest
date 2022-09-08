package com.supremecorp.springrest;

import com.supremecorp.springrest.domains.Employee;
import com.supremecorp.springrest.domains.Order;
import com.supremecorp.springrest.repositories.EmployeeRepository;
import com.supremecorp.springrest.repositories.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(EmployeeRepository employeeRepository, OrderRepository orderRepository) {

        return args -> {
            employeeRepository.save(new Employee("Bilbo Baggins", "burglar"));
            employeeRepository.save(new Employee("Frodo Baggins", "thief"));

            employeeRepository.findAll().forEach(employee -> log.info("Preloaded " + employee));


            orderRepository.save(new Order("MacBook Pro", Order.Status.COMPLETED.toString()));
            orderRepository.save(new Order("iPhone", Order.Status.IN_PROGRESS.toString()));

            orderRepository.findAll().forEach(order -> {
                log.info("Preloaded " + order);
            });
        };
    }
}
