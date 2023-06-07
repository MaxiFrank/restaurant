package devmountain.group2.controllers;

import devmountain.group2.dtos.GetAvailabilityDto;
import devmountain.group2.entities.AvailabilityEntity;
import devmountain.group2.entities.ReservationEntity;
import devmountain.group2.services.AvailabilityServiceImpl;
import devmountain.group2.services.ReservationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
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
    public @ResponseBody List<GetAvailabilityDto> getAllAvailability(@RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date,
        @RequestParam String afterTime
    ) {
        List<ReservationEntity> reservationEntities = reservationService.getReservationsByDate(date);
        List<AvailabilityEntity> availabilityEntities = availabilityService.getAllAvailability(afterTime);
        List<GetAvailabilityDto> availabilityDtos = new ArrayList<>();

        // Initialize the availabilityDtos list from availabilityEntities and find which time slots have reservations
        for (int i = 0; i < availabilityEntities.size(); i++) {
            GetAvailabilityDto availabilityDto = new GetAvailabilityDto();
            availabilityDto.setId(availabilityEntities.get(i).getId());
            availabilityDto.setTableId(availabilityEntities.get(i).getTableId());
            availabilityDto.setTimeSlot(availabilityEntities.get(i).getTimeSlot());
            availabilityDto.setCapacity(availabilityEntities.get(i).getCapacity());
            availabilityDto.setHasReservation(false);
            for (int j = 0; j < reservationEntities.size(); j++) {
                if (reservationEntities.get(j).getAvailabilityId().equals(availabilityDto.getId())) {
                    Timestamp reservationDate = reservationEntities.get(j).getTimestamp(); // YYYY-MM-DD HH:MI:SS // Used only to get the date
                    if (isToday(reservationDate)) {
                        availabilityDto.setHasReservation(true);
                    }
                }
            }
            availabilityDtos.add(availabilityDto);
        }

        // Set hasConflict to true if there is a reservation at the same table < 1 hour before or after the time slot
        for (int i = 0; i < availabilityDtos.size(); i++) {
            for (int j = i + 1; j < availabilityDtos.size(); j++) {
                if (availabilityDtos.get(i).getTableId() == availabilityDtos.get(j).getTableId()) {
                    if (availabilityDtos.get(i).getHasReservation()) {
                        if (timeHasConflict(availabilityDtos.get(i).getTimeSlot(), availabilityDtos.get(j).getTimeSlot())) {
                            availabilityDtos.get(i).setHasConflict(true);
                            availabilityDtos.get(j).setHasConflict(true);
                        }
                    }
                }
            }
        }

        // remove all availabilityDtos from response where hasConflict set to true
        availabilityDtos.removeIf(GetAvailabilityDto::getHasConflict);

        return availabilityDtos;
    }

    public static boolean timeHasConflict(String timeReserved, String otherTime) {
        // Assume the time format is "HH:mm-HH:mm"
        String[] reservedTimes = timeReserved.split("-");
        String[] otherTimes = otherTime.split("-");

        // Only checking the end time of the reserved slot and the start time of the other slot
        LocalTime reservedEndTime = LocalTime.parse(reservedTimes[1]);
        LocalTime otherStartTime = LocalTime.parse(otherTimes[0]);

        long differenceInMinutes = ChronoUnit.MINUTES.between(reservedEndTime, otherStartTime);

        // If the time difference is less than 60 minutes (1 hour), there's a conflict
        return Math.abs(differenceInMinutes) < 60;
    }

    public static boolean isToday(Timestamp timestamp) {
        LocalDateTime timestampDateTime = timestamp.toLocalDateTime();
        LocalDateTime todayDateTime = LocalDateTime.now();

        // Compare the date part only
        LocalDate timestampDate = timestampDateTime.toLocalDate();
        LocalDate todayDate = todayDateTime.toLocalDate();

        return timestampDate.equals(todayDate);
    }

}
