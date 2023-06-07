package devmountain.group2.services;


import devmountain.group2.entities.AvailabilityEntity;
import devmountain.group2.repositories.AvailabilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Component
public class AvailabilityServiceImpl {
    @Autowired
    private AvailabilityRepository availabilityRepository;

    public List<AvailabilityEntity> getAllAvailability() {
        return availabilityRepository.findAll();
    }

    public List<AvailabilityEntity> getAllAvailability(String afterTime) {
        LocalTime afterLocalTime = LocalTime.parse(afterTime, DateTimeFormatter.ofPattern("HH:mm"));

        List<AvailabilityEntity> allAvailability = availabilityRepository.findAll();
        List<AvailabilityEntity> filteredAvailability = new ArrayList<>();

        for (AvailabilityEntity availability : allAvailability) {
            String[] timeSlotParts = availability.getTimeSlot().split("-");
            LocalTime startLocalTime = LocalTime.parse(timeSlotParts[0], DateTimeFormatter.ofPattern("HH:mm"));

            if (startLocalTime.isAfter(afterLocalTime)) {
                filteredAvailability.add(availability);
            }
        }

        return filteredAvailability;
    }
}
