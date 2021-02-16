package com.udacity.vehicles.client.prices;

import com.sun.tools.rngom.util.Uri;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.client.Traverson;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

import static org.springframework.hateoas.MediaTypes.HAL_JSON;

/**
 * Implements a class to interface with the Pricing Client for price data.
 */
@Component
public class PriceClient {

    private static final Logger log = LoggerFactory.getLogger(PriceClient.class);

    private final WebClient client;

    public PriceClient(WebClient pricing) {
        this.client = pricing;
    }

    // In a real-world application we'll want to add some resilience
    // to this method with retries/CB/failover capabilities
    // We may also want to cache the results so we don't need to
    // do a request every time
    /**
     * Gets a vehicle price from the pricing client, given vehicle ID.
     * @param vehicleId ID number of the vehicle for which to get the price
     * @return Currency and price of the requested vehicle,
     *   error message that the vehicle ID is invalid, or note that the
     *   service is down.
     */
    public String  getPrice(Long vehicleId)  {
        try {
            Price price=null ;


             ResponseEntity<Price> response = new RestTemplate().getForEntity("http://localhost:8082/prices/" + vehicleId,Price.class);
             price = response.getBody();

             return String.valueOf(price.getPrice());

           // return String.format("%s %s", price.getCurrency(), price.getPrice());

        } catch (Exception e) {
            log.error("Unexpected error retrieving price for vehicle {}", vehicleId, e);
        }
        return "(consult price)";
    }

    public void update(Long id) {
        client.delete().uri(uriBuilder -> uriBuilder.path("/services-price").pathSegment("" + id).build());

    }
}
