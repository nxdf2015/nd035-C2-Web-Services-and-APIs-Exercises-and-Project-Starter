package com.order.order.price;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.reactive.function.client.WebClient;

public class PriceClient {

    @Autowired
    WebClient vehicleClient;

    public Price getCPrice(long id){
        return vehicleClient.get().uri(uriBuilder -> uriBuilder.path("/price/").pathSegment(""+id).build())
                .retrieve()
                .bodyToMono(Price.class)
                .block();

    }
}
