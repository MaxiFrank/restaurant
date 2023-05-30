package devmountain.group2.services;

import devmountain.group2.entities.DishEntity;
import devmountain.group2.repositories.DishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DishServiceImpl {
    @Autowired
    private DishRepository dishRepository;

    public List<DishEntity> getAllDishes() {
        return dishRepository.findAll();
    }
}
