package com.udacity.boogle.maps.repository;

import com.udacity.boogle.maps.Address;
import com.udacity.boogle.maps.Map;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MapRepository extends JpaRepository<Map,Long> {

    public Map  findByLonAndLat(double lon, double lat);
    public boolean existsByAddress(Address address);
}
