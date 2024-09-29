package com.eventmanagementapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eventmanagementapi.model.Event;

@Repository
public interface EventRepo extends JpaRepository<Event, Long> {

}
