package com.demo.newairport.controller;

import com.demo.newairport.entity.BookingDetailEntity;
import com.demo.newairport.services.BookingDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/bookigndetail")
public class BookingDetail {
    private final BookingDetailService bookingDetailService;

    @Autowired
    public BookingDetail(BookingDetailService bookingDetailService){
        this.bookingDetailService = bookingDetailService;
    }

    @GetMapping(path = "/get")
    public List<BookingDetailEntity> getBookingDetail(){
        return bookingDetailService.getBookingDetail();
    }

    @PostMapping(path = "/post")
    public ResponseEntity<BookingDetailEntity> postBookingDetail(@RequestBody BookingDetailEntity bookingDetailEntity){
        try {
            BookingDetailEntity addBookingDetail = bookingDetailService.addBookingDetail(bookingDetailEntity);
            return ResponseEntity.ok(addBookingDetail);
        }catch (Exception e){
            throw new RuntimeException(e.getMessage(), e);
        }
    }
}
