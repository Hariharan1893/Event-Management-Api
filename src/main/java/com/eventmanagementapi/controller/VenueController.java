package com.eventmanagementapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.eventmanagementapi.model.Venue;
import com.eventmanagementapi.service.VenueService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/venue")
public class VenueController {

	@Autowired
	private VenueService venueservice;

	@GetMapping("/getallvenue")
	public List<Venue> getallVenue() {
		return venueservice.getAllVenue();
	}

	@GetMapping("/getvenue/{venue_id}")
	public Venue getVenueById(@PathVariable Long venue_id) {

		return venueservice.getVenueById(venue_id);
	}
	
	@PostMapping("createvenue")
	public ResponseEntity<Venue> createVenue(@Valid @RequestBody Venue venue){
		Venue createdVenue = venueservice.createVenue(venue);
		return ResponseEntity.ok(createdVenue);			
	}
	
	@DeleteMapping("deletevenue/{venue_id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteVenue(@PathVariable Long venue_id) {
		venueservice.deleteVenue(venue_id);
	}
	

}















