package devmountain.group2.services;


import devmountain.group2.entities.ReservationEntity;
import devmountain.group2.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Date;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

@Component
public class ReservationServiceImpl {
    @Autowired
    private ReservationRepository reservationRepository;

    public ReservationEntity addReservation(ReservationEntity reservationEntity) {
        return reservationRepository.saveAndFlush(reservationEntity);
    }

    public List<ReservationEntity> getAllReservations() {
        return reservationRepository.findAll();
    }

    public List<ReservationEntity> getReservationsByDate(LocalDate date) {
        LocalDateTime startOfDay = date.atStartOfDay();
        LocalDateTime startOfNextDay = startOfDay.plusDays(1);
        Date startOfDayDate = Date.from(startOfDay.atZone(ZoneId.systemDefault()).toInstant());
        Date startOfNextDayDate = Date.from(startOfNextDay.atZone(ZoneId.systemDefault()).toInstant());
        return reservationRepository.findAllByDate(startOfDayDate, startOfNextDayDate);
    }
}
