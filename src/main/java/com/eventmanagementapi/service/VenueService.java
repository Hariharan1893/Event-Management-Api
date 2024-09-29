package com.eventmanagementapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eventmanagementapi.model.Venue;
import com.eventmanagementapi.repository.VenueRepo;

@Service
public class VenueService {

	@Autowired
	private VenueRepo venuerepo;

	public List<Venue> getAllVenue() {
		return venuerepo.findAll();
	}

	public Venue getVenueById(Long id) {
		return venuerepo.findById(id).orElseThrow(() -> new RuntimeException("No category found"));
	}

	public Venue createVenue(Venue ven) {
		return venuerepo.save(ven);
	}

	public void deleteVenue(Long id) {
		Optional<Venue> exist = venuerepo.findById(id);

		if (exist != null) {
			venuerepo.deleteById(id);
		} else {
			throw new RuntimeException("No Venue	 to delete");
		}
	}
}
