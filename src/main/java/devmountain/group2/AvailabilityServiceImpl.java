package devmountain.group2;

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
