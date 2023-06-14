package devmountain.group2.services;

import devmountain.group2.dtos.CreateReviewPojo;
import devmountain.group2.entities.ReviewEntity;
import devmountain.group2.entities.UserEntity;
import devmountain.group2.repositories.ReviewRepository;
import devmountain.group2.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ReviewServiceImpl implements ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Override
    public void createReview(CreateReviewPojo createReviewPojo) {
        ReviewEntity reviewEntity = new ReviewEntity();
        reviewEntity.setReviewContent(createReviewPojo.getReviewContent());
        UserEntity userEntity = userRepository.findByUsername(createReviewPojo.getUsername()).orElseThrow(() ->
                new RuntimeException("User does not exists"));
        if (!passwordEncoder.matches(createReviewPojo.getPassword(), userEntity.getPassword())) {
            throw new RuntimeException("Password is incorrect");
        }
        reviewEntity.setRating(createReviewPojo.getRating());
        reviewRepository.save(reviewEntity);
    }
}
