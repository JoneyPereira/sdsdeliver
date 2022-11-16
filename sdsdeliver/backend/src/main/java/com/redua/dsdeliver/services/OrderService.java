package com.redua.dsdeliver.services;

import com.redua.dsdeliver.dto.OrderDTO;
import com.redua.dsdeliver.dto.ProductDTO;
import com.redua.dsdeliver.entities.Order;
import com.redua.dsdeliver.entities.OrderStatus;
import com.redua.dsdeliver.entities.Product;
import com.redua.dsdeliver.repositories.OrderRepository;
import com.redua.dsdeliver.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    @Transactional(readOnly = true)
    public List<OrderDTO> findAll(){
        List<Order> list = orderRepository.findOrdersWithProducts();
        return list.stream().map(x ->new OrderDTO(x)).collect(Collectors.toList());
    }

    @Transactional
    public OrderDTO insert(OrderDTO dto){
        Order order = new Order(null, dto.getAddress(), dto.getLatitude(), dto.getLongitude(), Instant.now(), OrderStatus.PENDING);
        for (ProductDTO p : dto.getProducts()){
            Product product = productRepository.getReferenceById(p.getId());
            order.getProducts().add(product);
        }
        order = orderRepository.save(order);
        return new OrderDTO(order);
    }
}
