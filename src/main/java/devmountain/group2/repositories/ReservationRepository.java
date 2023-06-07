package devmountain.group2.repositories;

import devmountain.group2.entities.ReservationEntity;
import jakarta.persistence.TemporalType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Temporal;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface ReservationRepository extends JpaRepository<ReservationEntity, Long> {
    @Query("SELECT r FROM ReservationEntity r WHERE r.timestamp >= :startOfDay AND r.timestamp < :startOfNextDay")
    List<ReservationEntity> findAllByDate(@Param("startOfDay") @Temporal(TemporalType.TIMESTAMP) Date startOfDay, @Param("startOfNextDay") @Temporal(TemporalType.TIMESTAMP) Date startOfNextDay);
}
