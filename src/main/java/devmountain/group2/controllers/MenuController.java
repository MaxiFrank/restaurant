package devmountain.group2.controllers;

import devmountain.group2.entities.MenuEntity;
import devmountain.group2.services.MenuServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("menu")
public class MenuController {

    @Autowired
    private MenuServiceImpl menuService;

    @GetMapping(path="/", produces = "application/json")
    public @ResponseBody List<MenuEntity> getAllMenus() {
        return menuService.getAllMenus();
    }
}
