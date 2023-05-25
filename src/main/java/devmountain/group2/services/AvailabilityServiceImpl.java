package devmountain.group2.services;


import devmountain.group2.entities.AvailabilityEntity;
import devmountain.group2.repositories.AvailabilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AvailabilityServiceImpl {
    @Autowired
    private AvailabilityRepository availabilityRepository;

    public List<AvailabilityEntity> getAllAvailability() {
        return availabilityRepository.findAll();
    }
}
