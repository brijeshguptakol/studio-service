package com.brijesh.studio.web.controllers;

import com.brijesh.studio.business.models.BookingDTO;
import com.brijesh.studio.business.services.BookingService;
import com.brijesh.studio.web.models.mappers.CreateBookingRequestMapper;
import com.brijesh.studio.web.models.BookingVM;
import com.brijesh.studio.web.models.CreateBookingRequest;
import com.brijesh.studio.web.models.CreateBookingResponse;
import com.brijesh.studio.web.models.mappers.BookingVMMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@Component
@RequiredArgsConstructor
@RestController
public class BookingController {

    private final BookingService bookingService;

    @PostMapping("/v1/bookings")
    public ResponseEntity<CreateBookingResponse> createBooking(@RequestBody CreateBookingRequest request) {

        Long bookingId = bookingService.createBooking(CreateBookingRequestMapper.mapToDTO(request));

        return ResponseEntity.ok(new CreateBookingResponse(
                request.userId(),
                request.userFullName(),
                request.classId(),
                request.className(),
                request.bookingDate(),
                bookingId
        ));
    }

    @GetMapping("/v1/bookings/{id}")
    public ResponseEntity<BookingVM> getBooking(@PathVariable(value = "id") Long id) {

        BookingDTO booking = bookingService.getBookingById(id);

        return ResponseEntity.ok(BookingVMMapper.mapToVM(booking));
    }

}
