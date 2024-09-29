package com.eventmanagementapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eventmanagementapi.model.Event;
import com.eventmanagementapi.repository.EventRepo;

@Service
public class EventService {

	@Autowired
	private EventRepo eventrepo;

	public List<Event> getAllEvents() {
		return eventrepo.findAll();
	}

	public Event getEventById(Long id) {
		return eventrepo.findById(id)
				.orElseThrow(() -> new RuntimeException("Event not found with this id"));
	}

	public Event createEvent(Event event) {
		return eventrepo.save(event);
	}

	public Event updateEvent(Long id, Event eventDetails) {
		Optional.ofNullable(eventDetails)
		.orElseThrow(() -> new RuntimeException("Event details should not be null"));

		eventDetails.setEvent_id(id);

		return eventrepo.save(eventDetails);
	}
	
	public void deleteEvent(Long id) {
		Event existingEvent = getEventById(id);
		if(existingEvent != null) {
			eventrepo.delete(existingEvent);
		}else {
			throw new RuntimeException("No events to be deleted");
		}
		
	}

}
