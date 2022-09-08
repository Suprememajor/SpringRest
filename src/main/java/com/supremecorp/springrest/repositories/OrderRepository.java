package com.supremecorp.springrest.repositories;

import com.supremecorp.springrest.domains.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}
