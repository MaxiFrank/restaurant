package devmountain.group2.repositories;

import devmountain.group2.entities.DishEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DishRepository extends JpaRepository<DishEntity, Long>  {
}
