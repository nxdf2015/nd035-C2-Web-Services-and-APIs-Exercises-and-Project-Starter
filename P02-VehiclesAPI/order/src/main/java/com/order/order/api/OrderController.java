package com.order.order.api;


import com.order.order.error.InvalidPersonException;
import com.order.order.domain.client.Client;
import com.order.order.domain.order.Order;
import com.order.order.domain.client.Person;
import com.order.order.domain.client.ClientRepository;
import com.order.order.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/service/order")
public class OrderController {

    @Autowired
    ClientService clientService;

    @Autowired
    ClientRepository clientRepository;

    /**
     * description create a new client
     * @param  person with a name
     * @return Client
     */
    @PostMapping("/client")
    public ResponseEntity<Client> createClient(@RequestBody Person person){

        Client client =  clientService.createClient(person);
        return new ResponseEntity(client, HttpStatus.ACCEPTED);

    }



    /**
     * add a new order of a client
     * path   /add/{name}
     * @param order  ,order in the body of the request
     * @param name   , name of the client
     * @return Client
     * @throws InvalidPersonException if client does not exist
     */
    @PostMapping("/add/{name}")
    public ResponseEntity<Client> addOrder(@RequestBody Order order, @PathVariable String name) throws InvalidPersonException {

         return new ResponseEntity(clientService.addOrder(name, order),HttpStatus.ACCEPTED);

    }

    /**
     * checkout orders
     * path  /{name}
     * @param name , name of the client
     * @return Client
     * @throws InvalidPersonException if client does not exist
     */
    @GetMapping("/{name}")
    public ResponseEntity<Client>  checkout(@PathVariable String name) throws InvalidPersonException {
        clientService.checkout(name);
        return new ResponseEntity(clientService.checkout(name), HttpStatus.ACCEPTED);
    }



}
