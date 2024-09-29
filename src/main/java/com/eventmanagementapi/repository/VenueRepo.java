package com.eventmanagementapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eventmanagementapi.model.Venue;


@Repository
public interface VenueRepo extends JpaRepository<Venue, Long>{

}
