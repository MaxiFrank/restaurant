package devmountain.group2.controllers;

import devmountain.group2.dtos.GetAvailabilityDto;
import devmountain.group2.entities.AvailabilityEntity;
import devmountain.group2.entities.ReservationEntity;
import devmountain.group2.services.AvailabilityServiceImpl;
import devmountain.group2.services.ReservationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.ZoneId;

@RestController
@RequestMapping("availability")
public class AvailabilityController {

    @Autowired
    private AvailabilityServiceImpl availabilityService;

    @Autowired
    private ReservationServiceImpl reservationService;

    @GetMapping(path="/", produces = "application/json")
    public @ResponseBody List<GetAvailabilityDto> getAllAvailability() {
        List<ReservationEntity> reservationEntities = reservationService.getAllReservations();
        List<AvailabilityEntity> availabilityEntities = availabilityService.getAllAvailability();
        List<GetAvailabilityDto> availabilityDtos = new ArrayList<>();
        for (int i = 0; i < availabilityEntities.size(); i++) {
            GetAvailabilityDto availabilityDto = new GetAvailabilityDto();
            availabilityDto.setId(availabilityEntities.get(i).getId());
            availabilityDto.setTableId(availabilityEntities.get(i).getTableId());
            availabilityDto.setTimeSlot(availabilityEntities.get(i).getTimeSlot());
            availabilityDto.setCapacity(availabilityEntities.get(i).getCapacity());
            boolean isAvailable = true;
            for (int j = 0; j < reservationEntities.size(); j++) {
                if (reservationEntities.get(j).getAvailabilityId() == availabilityDto.getId()) {
                    String reservationDate = reservationEntities.get(j).getTimestamp(); // YYYY-MM-DD HH:MI:SS // Used only to get the date
                    if (isToday(Timestamp.valueOf(reservationDate))) {
                        isAvailable = false;
                    }
                }
            }
            availabilityDto.setAvailable(isAvailable);
            availabilityDtos.add(availabilityDto);
        }
        return availabilityDtos;
    }

    public static boolean isToday(Timestamp timestamp) {
        LocalDate timestampDate = timestamp.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate today = LocalDate.now();

        return timestampDate.equals(today);
    }
}
