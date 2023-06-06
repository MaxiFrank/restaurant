package devmountain.group2.controllers;

import devmountain.group2.dtos.CreateReservationDto;
import devmountain.group2.entities.ReservationEntity;
import devmountain.group2.services.ReservationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("reservation")
public class ReservationController {

    @Autowired
    private ReservationServiceImpl reservationService;

    @PostMapping (path="/create", produces = "application/json")
    public @ResponseBody ReservationEntity createReservation(CreateReservationDto createReservationDto) {
        ReservationEntity reservationEntity = new ReservationEntity();
        reservationEntity.setTimestamp(LocalDate.now().toString());
        reservationEntity.setUserId(Long.valueOf(createReservationDto.getUsername())); // TODO: validate user id
        reservationEntity.setAvailabilityId(createReservationDto.getAvailabilityId());
        return reservationService.addReservation(reservationEntity);
    }
}
