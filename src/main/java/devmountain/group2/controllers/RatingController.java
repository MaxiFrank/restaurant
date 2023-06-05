package devmountain.group2.controllers;

import devmountain.group2.dtos.CreateRatingPojo;
import devmountain.group2.services.RatingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Rating")
public class RatingController {
    @Autowired
    private RatingServiceImpl ratingService;

    @PostMapping(path = "/CreateDishRating", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> createRating(@RequestBody CreateRatingPojo creatingRatingPojo) {
        try {
            ratingService.createDishRating(creatingRatingPojo);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(path = "/GetAllDishRatings", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> getAllRatings() {
        try {
            return new ResponseEntity<>(ratingService.getAllDishesRatings(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}

