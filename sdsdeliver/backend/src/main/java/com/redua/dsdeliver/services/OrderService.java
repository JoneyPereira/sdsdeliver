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
        Order order = new Order();
        order.setId(null);
        order.setAddress(dto.getAddress());
        order.setLatitude(dto.getLatitude());
        order.setLongitude(dto.getLongitude());
        order.setMoment(Instant.now());
        order.setStatus(OrderStatus.PENDING);

        for (ProductDTO p : dto.getProducts()){
            Product product = productRepository.getReferenceById(p.getId());
            order.getProducts().add(product);
        }
        order = orderRepository.save(order);
        return new OrderDTO(order);
    }

    @Transactional
    public OrderDTO setDelivered(Long id){
        Order order = orderRepository.getReferenceById(id);
        order.setStatus(OrderStatus.DELIVERED);
        order = orderRepository.save(order);
        return new OrderDTO(order);
    }
}
