package com.tourguide_tripPricer.unitTest.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import com.tourguide_tripPricer.service.TripPricerService;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import tripPricer.Provider;
import tripPricer.TripPricer;

@SpringBootTest()
public class TestTripPricerServiceImpl {

  @Autowired
  private TripPricerService tripPricerService;

  @MockBean
  TripPricer tripPricerMock;

  @Test
  public void testGetPrice() {
    String tripPricerApiKey = "";
    UUID userId = UUID.randomUUID();
    int numberOfAdults = 4;
    int numberOfChildren = 2;
    int tripDuration = 5;
    int cumulatativeRewardPoints = 5;
    List<Provider> providerList = null;

    when(tripPricerMock.getPrice(tripPricerApiKey, userId, numberOfAdults, numberOfChildren, tripDuration,
        cumulatativeRewardPoints)).thenReturn(providerList);

    List<Provider> result = tripPricerService.getPrice(tripPricerApiKey, userId, numberOfAdults, numberOfChildren,
        tripDuration,
        cumulatativeRewardPoints);

    assertThat(result).isEqualTo(providerList);
  }

}
