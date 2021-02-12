package com.order.order.service;

import com.order.order.domain.client.Client;
import com.order.order.domain.order.Order;
import com.order.order.domain.order.Status;
import com.order.order.domain.order.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    /**
     * checkout orders : compute  total orders
     * @param client
     * @return Client
     */
    public Client checkout(Client client) {
         long total =  client.getOrders()
                  .stream()
                  .map(order -> order.getQuantity() * order.getValue())
                  .reduce(0l, (value,price) -> value + price);
         client.setStatus(new Status(true, total));

         return client;
    }

    /**
     * save order , if one order with same vehicleId already exist update quantity
     * @param order
     * @return order;
     */
    public Order save(Order order) {
       Optional<Order> find = orderRepository.findByVehicleId(order.getVehicleId());
       if (find.isEmpty()){
         return  orderRepository.save(order);
       }
       else {
           find.get().addQuantity(order.getQuantity());
         return   orderRepository.save(find.get());
       }
    }


    /**
     * delete a list of orders
     * @param orders
     */
    public void deleteAll(List<Order> orders) {
        orderRepository.deleteAll(orders);
    }
}
