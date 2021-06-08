package com.tourguide_tripPricer.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tripPricer.TripPricer;

@Configuration
public class TourGuideModule {

  @Bean
  public TripPricer getTripPricer() {
    return new TripPricer();
  }

}

