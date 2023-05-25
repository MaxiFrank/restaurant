package devmountain.group2.controllers;

import devmountain.group2.entities.AvailabilityEntity;
import devmountain.group2.services.AvailabilityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("availability")
public class AvailabilityController {

    @Autowired
    private AvailabilityServiceImpl availabilityService;

    @GetMapping(path="/", produces = "application/json")
    public @ResponseBody List<AvailabilityEntity> getAllAvailability() {
        return availabilityService.getAllAvailability();
    }
}
