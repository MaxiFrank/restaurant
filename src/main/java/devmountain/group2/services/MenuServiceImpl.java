package devmountain.group2.services;

import devmountain.group2.entities.MenuEntity;
import devmountain.group2.repositories.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MenuServiceImpl {
    @Autowired
    private MenuRepository menuRepository;

    public List<MenuEntity> getAllMenus() {
        return menuRepository.findAll();
    }
}
