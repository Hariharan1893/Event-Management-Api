package com.eventmanagementapi.service;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eventmanagementapi.dto.EventAttendeeDto;
import com.eventmanagementapi.model.Event;
import com.eventmanagementapi.model.EventAttendee;
import com.eventmanagementapi.repository.EventAttendeeRepo;
import com.eventmanagementapi.repository.EventRepo;

@Service
public class EventAttendeeService {

	@Autowired
	private EventAttendeeRepo attendeeRepo;

	@Autowired
	private EventRepo eventRepo;

	public List<EventAttendee> getAllAttendees() {
		return attendeeRepo.findAll();
	}

	public EventAttendee getAttendeeById(Long id) {
		return attendeeRepo.findById(id)
				.orElseThrow(() -> new RuntimeException("Could not find the attendee with the given id"));
	}

	public EventAttendeeDto createAttendee(Long eventId, EventAttendee attendee) {
		Optional<Event> eventObj = eventRepo.findById(eventId);

		if (eventObj.isPresent()) {
			Event event = eventObj.get();
			attendee.setEvent(event);

			EventAttendee savedAttendee = attendeeRepo.save(attendee);

			String eventDate = event.getDateTime().format(DateTimeFormatter.ISO_LOCAL_DATE);

			return new EventAttendeeDto(savedAttendee.getId(), savedAttendee.getName(), savedAttendee.getEmail(),
					event.getEvent_id(), event.getEventTitle(), eventDate);
		} else {
			throw new RuntimeException("Event not Found with the given id");
		}
	}

	public void deleteAttendee(Long id) {
		attendeeRepo.deleteById(id);
	}
}
