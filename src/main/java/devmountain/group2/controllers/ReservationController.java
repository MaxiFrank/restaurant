package devmountain.group2.controllers;

import devmountain.group2.dtos.CreateReservationDto;
import devmountain.group2.entities.ReservationEntity;
import devmountain.group2.services.ReservationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

@RestController
@RequestMapping("reservation")
public class ReservationController {

    @Autowired
    private ReservationServiceImpl reservationService;

    @PostMapping(path = "/create", produces = "application/json")
    public @ResponseBody ReservationEntity createReservation(@RequestBody CreateReservationDto createReservationDto) {
        ReservationEntity reservationEntity = new ReservationEntity();
        String dateString = createReservationDto.getDate() + " 00:00:00"; // Add time component to the date string
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date date = dateFormat.parse(dateString);
            Timestamp timestamp = new Timestamp(date.getTime());
            reservationEntity.setTimestamp(timestamp);
        } catch (ParseException e) {
            System.out.println("Error parsing date string");
        }
        // reservationEntity.setUserId(Long.valueOf(createReservationDto.getUsername())); // TODO: validate user id
        reservationEntity.setUserId(0L);
        reservationEntity.setAvailabilityId(createReservationDto.getAvailabilityId());
        return reservationService.addReservation(reservationEntity);
    }

}
