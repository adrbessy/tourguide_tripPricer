package com.tourguide_tripPricer.controller;


import com.tourguide_tripPricer.service.TripPricerService;
import java.util.List;
import java.util.UUID;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tripPricer.Provider;

@RestController
public class TripPricerController {

  private static final Logger logger = LogManager.getLogger(TripPricerController.class);

  @Autowired
  TripPricerService tripPricerService;

  /**
   * Get the price for a trip
   * 
   * @param tripPricerApiKey         the API key of the trip pricer
   * @param userId                   the user id
   * @param numberOfAdults           the number of adults
   * @param numberOfChildren         the number of children
   * @param tripDuration             the trip duration
   * @param cumulatativeRewardPoints the cumulative reward points
   * @return a list of Providers
   */
  @GetMapping("/price")
  public List<Provider> getPrice(@RequestParam String tripPricerApiKey, @RequestParam UUID userId,
      @RequestParam int numberOfAdults, @RequestParam int numberOfChildren, @RequestParam int tripDuration,
      @RequestParam int cumulatativeRewardPoints) {
    logger.info("Get request with the endpoint 'userLocation'");
    List<Provider> price = tripPricerService.getPrice(tripPricerApiKey, userId, numberOfAdults,
        numberOfChildren,
        tripDuration, cumulatativeRewardPoints);
    return price;
  }

}
