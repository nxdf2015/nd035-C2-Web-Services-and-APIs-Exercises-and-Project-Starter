package com.udacity.boogle.maps;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/maps")
public class MapsController {

    @Autowired
    AddressService addressService;

    @GetMapping
    public Address get(@RequestParam Double lat, @RequestParam Double lon) {
        return   addressService.getAddress(lon,lat).getAddress();
    }
}
