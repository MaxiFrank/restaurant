package devmountain.group2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Rating")
public class RatingController {
    @Autowired
    private RatingServiceImpl ratingService;

    @PostMapping(path = "/CreateMealRating", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> createRating(@RequestBody CreateRatingPojo creatingRatingPojo) {
        try {
            ratingService.createMealRating(creatingRatingPojo);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}

