package com.tourguide_tripPricer.unitTest.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.tourguide_tripPricer.service.TripPricerService;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import tripPricer.Provider;

@SpringBootTest
@AutoConfigureMockMvc
public class TestTripPricerController {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  TripPricerService tripPricerServiceMock;

  @Test
  public void testGetPrice() throws Exception {
    String tripPricerApiKey = "";
    UUID userId = UUID.randomUUID();
    int numberOfAdults = 4;
    int numberOfChildren = 2;
    int tripDuration = 5;
    int cumulatativeRewardPoints = 5;
    List<Provider> providerList = null;

    when(tripPricerServiceMock.getPrice(tripPricerApiKey, userId, numberOfAdults, numberOfChildren, tripDuration,
        cumulatativeRewardPoints)).thenReturn(providerList);

    mockMvc
        .perform(get(
            "/price?tripPricerApiKey=" + tripPricerApiKey + "&userId=" + userId + "&numberOfAdults=" + numberOfAdults
                + "&numberOfChildren=" + numberOfChildren + "&tripDuration=" + tripDuration
                + "&cumulatativeRewardPoints=" + cumulatativeRewardPoints))
        .andExpect(status().isOk());
  }

}
