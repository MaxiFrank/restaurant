package devmountain.group2.services;

import devmountain.group2.dtos.CreateRatingPojo;
import devmountain.group2.entities.DishEntity;
import devmountain.group2.entities.RatingEntity;
import devmountain.group2.entities.UserEntity;
import devmountain.group2.repositories.DishRepository;
import devmountain.group2.repositories.RatingRepository;
import devmountain.group2.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingServiceImpl implements RatingService {
    @Autowired
    private RatingRepository ratingRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DishRepository dishRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void createDishRating(CreateRatingPojo createRatingPojo) {
        RatingEntity ratingEntity = new RatingEntity();
        DishEntity dishEntity = dishRepository.findById(createRatingPojo.getDishId()).orElseThrow(() ->
                new RuntimeException("Dish does not exists"));
        UserEntity userEntity = userRepository.findByUsername(createRatingPojo.getUsername()).orElseThrow(() ->
                new RuntimeException("User does not exists"));
        if (!passwordEncoder.matches(createRatingPojo.getPassword(), userEntity.getPassword())) {
            throw new RuntimeException("Password is incorrect");
        }
        ratingEntity.setRating(createRatingPojo.getRating());
        ratingEntity.setDish(dishEntity);
        ratingEntity.setUser(userEntity);
        ratingEntity.setRating(createRatingPojo.getRating());
        ratingRepository.save(ratingEntity);
    }

    public List<RatingEntity> getAllDishesRatings() {
        return ratingRepository.findAll();
    }

    void deleteDishRating(Long id) {
        ratingRepository.deleteById(id);
    }
}
