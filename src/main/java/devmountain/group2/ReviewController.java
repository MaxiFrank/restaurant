package devmountain.group2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Review")
public class ReviewController {
    @Autowired
    private ReviewServiceImpl reviewService;

    @PostMapping(path = "/CreateReview", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> createReview(@RequestBody CreateReviewPojo createReviewPojo) {
        try {
            reviewService.createReview(createReviewPojo);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
