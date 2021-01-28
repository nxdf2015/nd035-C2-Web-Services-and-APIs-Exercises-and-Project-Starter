package com.udacity.pricing;

import com.udacity.pricing.service.PricingService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PricingServiceApiTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    PricingService pricingService;

    @Test
    public void getWithValidId() throws Exception{
        mockMvc.perform(get("/services/price?vehicleId=5"))
                .andExpect(status().isOk());

    }

    @Test
    public void getWithInValidId() throws Exception{
        mockMvc.perform(get("/services/price?vehicleId=20"))
                .andExpect(status().isNotFound());

        mockMvc.perform(get("/services/price?vehicleId=0"))
                .andExpect(status().isNotFound());
    }



}
