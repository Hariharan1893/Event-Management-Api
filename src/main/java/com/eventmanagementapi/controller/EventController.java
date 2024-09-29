package com.eventmanagementapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.eventmanagementapi.model.Event;
import com.eventmanagementapi.service.EventService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/events/")
public class EventController {

	@Autowired
	private EventService eventservice;

	@GetMapping("/getallevent")
	public List<Event> getAllEvent() {
		return eventservice.getAllEvents();
	}

	@GetMapping("/getevent/{event_id}")
	public ResponseEntity<?> getEventById(@PathVariable Long event_id) {

		Event existing = eventservice.getEventById(event_id);
		if (existing != null) {
			return new ResponseEntity<>(existing, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("No data Found", HttpStatus.NO_CONTENT);
		}
	}
	
	@PostMapping("/addevent")
	public ResponseEntity<?> createEvent(@Valid @RequestBody Event event){
		return new ResponseEntity<>(eventservice.createEvent(event),HttpStatus.CREATED);
	}
	
	@PutMapping("/updateevent/{event_id}")
	public ResponseEntity<?> updateEvent(@PathVariable Long event_id, @RequestBody Event eventDetails){
		Event updatedEvent = eventservice.updateEvent(event_id, eventDetails);
		return ResponseEntity.ok(updatedEvent);
	}
	
	@DeleteMapping("/deleteevent/{event_id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteEvent(@PathVariable Long event_id) {
		eventservice.deleteEvent(event_id);
	}
	
}