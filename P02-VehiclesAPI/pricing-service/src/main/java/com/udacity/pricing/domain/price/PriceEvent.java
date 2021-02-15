package com.udacity.pricing.domain.price;

import com.netflix.ribbon.proxy.annotation.Http;
import com.udacity.pricing.service.PricingService;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleAfterDelete;
import org.springframework.data.rest.core.annotation.HandleBeforeDelete;
import org.springframework.data.rest.core.annotation.HandleBeforeSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.net.http.HttpRequest;

@RepositoryEventHandler(Price.class)
@Component
public class PriceEvent {


    @Autowired
    PriceRepository repository;

    @HandleAfterDelete
    public void handleBeforeDelete(Price price){
        price.setPrice(PricingService.randomPrice());
        repository.save(price);
    }


}
