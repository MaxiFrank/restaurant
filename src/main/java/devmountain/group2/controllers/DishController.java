package devmountain.group2.controllers;

import devmountain.group2.entities.DishEntity;
import devmountain.group2.services.DishServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("dish")
public class DishController {

    @Autowired
    private DishServiceImpl dishService;

    @GetMapping(path="/", produces = "application/json")
    public @ResponseBody List<DishEntity> getAllDishes() {
        return dishService.getAllDishes();
    }
}
