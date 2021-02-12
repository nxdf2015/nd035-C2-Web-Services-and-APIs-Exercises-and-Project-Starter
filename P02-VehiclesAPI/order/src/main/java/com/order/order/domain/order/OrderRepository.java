package com.order.order.domain.order;

import com.order.order.domain.order.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order,Long > {

    public Optional<Order>  findByVehicleId(long id);

}
