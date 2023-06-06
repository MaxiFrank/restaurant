package devmountain.group2.services;


import devmountain.group2.entities.ReservationEntity;
import devmountain.group2.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
}
