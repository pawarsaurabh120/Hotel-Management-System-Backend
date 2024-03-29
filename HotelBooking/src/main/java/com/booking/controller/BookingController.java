package com.booking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.booking.entity.Booking;
import com.booking.exception.BookingNotFoundException;
import com.booking.service.IBookingService;

@RestController
@RequestMapping("/hotel")
@CrossOrigin("*")
public class BookingController {
	
	@Autowired
	private IBookingService iBookingService;
	
	@PostMapping("/booking/add/{RoomNo}")
	public ResponseEntity<Booking> addBooking(@RequestBody Booking booking, @PathVariable int RoomNo){
	    Booking b = iBookingService.addBooking(booking,RoomNo);
		return new ResponseEntity<>(b, HttpStatus.OK);
	}
	
	@PutMapping("/booking/update")
	public Booking updateBooking(@RequestBody Booking booking){
		return iBookingService.updateBooking(booking);
	}
	
	@GetMapping("/booking/getAll")
	public List<Booking> getAllBooking(){
		return iBookingService.getAllBooking();
	}
	
	@GetMapping("/booking/{bookingId}")
	public Booking getBookingById(@PathVariable int bookingId){
		return iBookingService.getBookingById(bookingId);
	}
	
	@DeleteMapping("/booking/delete/{bookingId}")
	public void deleteBooking(@PathVariable int bookingId){
		iBookingService.deleteBooking(bookingId);
	}

}
