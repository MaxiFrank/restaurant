package devmountain.group2.repositories;

import devmountain.group2.entities.MenuEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<MenuEntity, Long>  {
}
