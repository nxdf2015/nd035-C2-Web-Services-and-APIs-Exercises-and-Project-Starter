package com.udacity.boogle.maps.repository;

import com.udacity.boogle.maps.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AddressRepository extends JpaRepository<Address,Long> {

    public boolean existsByAddress(String  address);
}
