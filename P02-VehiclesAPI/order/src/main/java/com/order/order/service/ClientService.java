package com.order.order.service;

import com.order.order.error.InvalidPersonException;
import com.order.order.domain.client.Client;
import com.order.order.domain.order.Order;
import com.order.order.domain.client.Person;
import com.order.order.domain.client.ClientRepository;
import com.order.order.domain.order.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    OrderRepository orderRepository;
    @Autowired
    OrderService orderService;

    @Autowired
    ClientRepository clientRepository;


    public Client createClient(Person person){
        Client client = Client.from(person);
        return clientRepository.save(client);

    }

    public Client  addOrder(  String name, Order order) throws InvalidPersonException {
        Order finalOrder = order;
        return clientRepository.findByPersonName(name).map(updateClient -> {
            System.out.println(updateClient.getOrders());
             Order saveOrder = orderService.save(finalOrder);
             updateClient.add(saveOrder);

             return clientRepository.save(updateClient);
         }).orElseThrow(InvalidPersonException::new);
    }


    public Client checkout(String name) throws InvalidPersonException{
        return clientRepository.findByPersonName(name)
                .map(client -> {
                     client   =  orderService.checkout(client);
                     List<Order> orders = client.getOrders();
                     client.resetOrder();

                     clientRepository.save(client);
                     orderService.deleteAll(orders);

                     client.setOrders(orders);
                     return client;
                }).orElseThrow(InvalidPersonException::new);
    }
}
