package com.udacity.pricing;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.DiscoveryClient;
import com.udacity.pricing.domain.price.Price;
import com.udacity.pricing.domain.price.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceProcessor;

import java.util.List;
import java.util.stream.IntStream;

/**
 * Creates a Spring Boot Application to run the Pricing Service
 */

@SpringBootApplication
@EnableDiscoveryClient
public class PricingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PricingServiceApplication.class, args);
    }


    @Bean
    public CommandLineRunner initData(PriceRepository priceRepository){
        return (String ... args) -> {
            IntStream.range(0,10)
                    .forEach(i -> {
                        priceRepository.save(new Price("USD", i));
                    });

        };
    }

}
