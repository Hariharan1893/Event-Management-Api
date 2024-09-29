package com.eventmanagementapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eventmanagementapi.model.EventAttendee;

@Repository
public interface EventAttendeeRepo extends JpaRepository<EventAttendee, Long> {
 
}
