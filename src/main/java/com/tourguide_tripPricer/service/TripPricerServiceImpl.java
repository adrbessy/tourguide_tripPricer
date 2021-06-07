package com.tourguide_tripPricer.service;

import java.util.List;
import java.util.UUID;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tripPricer.Provider;
import tripPricer.TripPricer;

@Service
public class TripPricerServiceImpl implements TripPricerService {

  private static final Logger logger = LogManager.getLogger(TripPricerServiceImpl.class);

  @Autowired
  TripPricer tripPricer;

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
  @Override
  public List<Provider> getPrice(String tripPricerApiKey, UUID userId, int numberOfAdults, int numberOfChildren,
      int tripDuration, int cumulatativeRewardPoints) {
    logger.debug("in the method getPrice in the class TripPricerServiceImpl");
    return tripPricer.getPrice(tripPricerApiKey, userId, numberOfAdults, numberOfChildren,
        tripDuration, cumulatativeRewardPoints);
  }

}
