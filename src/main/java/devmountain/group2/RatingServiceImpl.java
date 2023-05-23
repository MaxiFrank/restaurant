package devmountain.group2;

import org.springframework.beans.factory.annotation.Autowired;

public class RatingServiceImpl implements RatingService {
    @Autowired
    private RatingRepository ratingRepository;

    @Override
    public void createMealRating(CreateRatingPojo createRatingPojo) {
        RatingEntity ratingEntity = new RatingEntity();
        ratingEntity.setMealId(createRatingPojo.getMealId());
        ratingEntity.setRating(createRatingPojo.getRating());
        //TODO query for user id with provided username and check against provided password to validate
        ratingRepository.save(ratingEntity);
    }
}
