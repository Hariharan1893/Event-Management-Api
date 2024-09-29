package com.eventmanagementapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eventmanagementapi.dto.EventAttendeeDto;
import com.eventmanagementapi.model.EventAttendee;
import com.eventmanagementapi.service.EventAttendeeService;

@RestController
@RequestMapping("/api/attendees")
public class EventAttendeeController {

	@Autowired
	private EventAttendeeService attendeeservice;

	// get all the available attendee for the events

	@GetMapping("/getallattendees")
	public ResponseEntity<?> getAllAttendee() {
		try {
			return new ResponseEntity<>(attendeeservice.getAllAttendees(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NO_CONTENT);
		}
	}

	// get a single attendee based on the id

	@GetMapping("/getattendee/{id}")
	public ResponseEntity<?> getAttendeeById(@PathVariable Long id) {
		try {
			EventAttendee attendee = attendeeservice.getAttendeeById(id);

			return new ResponseEntity<>(attendee, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	// add the new attendee to the event

	@PostMapping("/addattendee/{eventId}")
	public ResponseEntity<?> createAttendee(@PathVariable Long eventId, @RequestBody EventAttendee attendee) {

		try {
			EventAttendeeDto createdAttendee = attendeeservice.createAttendee(eventId, attendee);

			return ResponseEntity.ok(createdAttendee);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_IMPLEMENTED);
		}
	}

	// delete the existing attendee

	@DeleteMapping("/deleteattendee/{id}")
	public void deleteAttendee(@PathVariable Long id) {
		attendeeservice.deleteAttendee(id);
	}

}
