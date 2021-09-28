package com.idrunk.serviceTest;
import com.idrunk.models.Booking;
import com.idrunk.models.Tafel;
import com.idrunk.models.User;
import com.idrunk.repositories.BookingRepository;
import com.idrunk.repositories.TafelRepository;
import com.idrunk.repositories.UserRepository;
import com.idrunk.services.BookingServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BookingServiceImplTest {

    @Mock
    UserRepository userRepository;

    @Mock
    TafelRepository tafelRepository;

    @Mock
    BookingRepository bookingRepository;

    @InjectMocks
    private BookingServiceImpl bookingService;

    @Captor
    ArgumentCaptor<Booking> bookingCaptor;

    @Test
    public void getBookingsTest() {
        when(bookingRepository.findAll()).thenReturn(List.of(new Booking(), new Booking()));
        List<Booking> bookingList =  bookingService.getBookings();
        assertEquals(2, bookingList.size());
    }

//    @Test
//    public void getBookingsByUsernameTest() {
//        Booking booking = new Booking();
//
//        User user = new User();
//        user.setUsername("Hansadmin");
//
////        when(bookingRepository.findBookingByUser(userRepository.findById("Hansadmin").get())).thenReturn((List<Booking>) booking.getUser());
//          when(bookingRepository.findBookingByUser(user)).thenReturn((List<booking>));
//        var bookings = bookingService.getBookingsByUserName("Hansadmin");
//        verify(bookingRepository, times(1)).findAll();
//    }

    @Test
    public void getBookingByIdTest() {
        Booking booking = new Booking();
        booking.setId(1L);
        Long id = booking.getId();
        when(bookingRepository.getById(id)).thenReturn(booking);

        var booking1 = bookingService.getBooking(1L);
        assertThat(booking1.getId()).isEqualTo(1L);
    }

    @Test
    public void planBookingTest() {
        Booking booking = new Booking();
        booking.setId(1000L);

        User user = new User();
        user.setUsername("testUser");
        when(userRepository.findById("testUser")).thenReturn(Optional.of(user));

        Tafel tafel = new Tafel();
        tafel.setId(1001L);
        when(tafelRepository.findById(1001L)).thenReturn(Optional.of(tafel));

        bookingService.planBooking(LocalDateTime.parse("2021-09-14T14:00:00"), LocalDateTime.parse("2021-09-14T16:00:00"),  1001L, "testUser");
        verify(bookingRepository).save(bookingCaptor.capture());

        booking = bookingCaptor.getValue();
        assertThat(booking.getUser()).isEqualTo(user);
    }
}
