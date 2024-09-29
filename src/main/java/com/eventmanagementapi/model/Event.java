package com.eventmanagementapi.model;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Event {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long event_id;
	private String eventTitle;
	private LocalDateTime dateTime;
	
	@OneToMany(mappedBy = "event")
	private List<EventAttendee> attendees;
	
	@ManyToOne
	@JoinColumn(name = "venue_id")
	private Venue venue;
	
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;

	public Long getEvent_id() {
		return event_id;
	}

	public void setEvent_id(Long event_id) {
		this.event_id = event_id;
	}

	public String getEventTitle() {
		return eventTitle;
	}

	public void setEventTitle(String eventTitle) {
		this.eventTitle = eventTitle;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	public List<EventAttendee> getAttendees() {
		return attendees;
	}

	public void setAttendees(List<EventAttendee> attendees) {
		this.attendees = attendees;
	}

	public Venue getVenue() {
		return venue;
	}

	public void setVenue(Venue venue) {
		this.venue = venue;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Event [event_id=" + event_id + ", eventTitle=" + eventTitle + ", dateTime=" + dateTime + ", attendees="
				+ attendees + ", venue=" + venue + ", category=" + category + "]";
	}
	
}
