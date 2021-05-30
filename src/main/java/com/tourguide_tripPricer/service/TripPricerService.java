package com.tourguide_tripPricer.service;

import java.util.List;
import java.util.UUID;
import tripPricer.Provider;

public interface TripPricerService {

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
  List<Provider> getPrice(String tripPricerApiKey, UUID userId, int numberOfAdults, int numberOfChildren,
      int tripDuration,
      int cumulatativeRewardPoints);

}
