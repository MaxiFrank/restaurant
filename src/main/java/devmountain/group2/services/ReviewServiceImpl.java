package devmountain.group2.services;

import devmountain.group2.dtos.CreateReviewPojo;
import devmountain.group2.entities.ReviewEntity;
import devmountain.group2.repositories.ReviewRepository;
import devmountain.group2.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewServiceImpl implements ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;
    @Override
    public void createReview(CreateReviewPojo createReviewPojo) {
        ReviewEntity reviewEntity = new ReviewEntity();
        reviewEntity.setReviewContent(createReviewPojo.getReviewContent());
        //TODO need to update once user entity is up to validate and query using user repository reviewEntity.setReviewerId();
        reviewRepository.save(reviewEntity);
    }
}
