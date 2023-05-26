package devmountain.group2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RatingServiceImpl implements RatingService {
    @Autowired
    private RatingRepository ratingRepository;

    @Override
    public void createDishRating(CreateRatingPojo createRatingPojo) {
        RatingEntity ratingEntity = new RatingEntity();
        ratingEntity.setDishId(createRatingPojo.getDishId());
        ratingEntity.setRating(createRatingPojo.getRating());
        //TODO query for user id with provided username and check against provided password to validate
        ratingRepository.save(ratingEntity);
    }
}
