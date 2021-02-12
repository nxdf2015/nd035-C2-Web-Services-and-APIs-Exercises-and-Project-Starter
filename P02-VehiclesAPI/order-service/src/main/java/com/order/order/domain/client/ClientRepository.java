package com.order.order.domain.client;

import com.order.order.domain.client.Client;
import com.order.order.domain.client.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Person> {
    public Optional<Client> findByPersonName(String name);
}
