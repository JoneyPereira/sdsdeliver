package com.redua.dsdeliver.repositories;

import com.redua.dsdeliver.entities.Order;
import com.redua.dsdeliver.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
