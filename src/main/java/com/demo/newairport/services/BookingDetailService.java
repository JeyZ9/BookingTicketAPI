package com.demo.newairport.services;

import com.demo.newairport.entity.BookingDetailEntity;
import com.demo.newairport.repository.BookingDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingDetailService {
    private final BookingDetailRepository bookingDetailRepository;
    @Autowired
    public BookingDetailService(BookingDetailRepository bookingDetailRepository){
        this.bookingDetailRepository = bookingDetailRepository;
    }

    public List<BookingDetailEntity> getBookingDetail(){
        return bookingDetailRepository.findAll();
    }

    public BookingDetailEntity addBookingDetail(BookingDetailEntity bookingDetailEntity){
        Optional<BookingDetailEntity> bookingDetailEntityOptional = bookingDetailRepository.findBookingDetailEntityBy(bookingDetailEntity.getSeatNum());
            if (bookingDetailEntityOptional.isPresent()){
                throw new IllegalArgumentException("BookingDetailEntity already exists");
            }
            bookingDetailRepository.save(bookingDetailEntity);
            return bookingDetailEntity;
    }

}
