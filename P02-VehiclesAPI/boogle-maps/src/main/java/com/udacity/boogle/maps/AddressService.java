package com.udacity.boogle.maps;

import com.udacity.boogle.maps.Address;
import com.udacity.boogle.maps.Map;
import com.udacity.boogle.maps.MockAddressRepository;
import com.udacity.boogle.maps.repository.AddressRepository;
import com.udacity.boogle.maps.repository.MapRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AddressService {
    @Autowired
    MapRepository mapRepository;

    @Autowired
    AddressRepository addressRepository;

    public Map getAddress(double lon, double lat){
       Map map = mapRepository.findByLonAndLat(lon,lat);


        if(map == null){
            Address address = MockAddressRepository.getRandom() ;
            System.out.println(address);
             addressRepository.save(address);
             mapRepository.save(Map.of(lon,lat,address));
             map= Map.of(lon,lat,address);
        }
        return map ;
    }
}
