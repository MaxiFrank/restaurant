package devmountain.group2;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "dish_ratings")
@Getter
@Setter
@NoArgsConstructor
public class RatingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    private int rating;
    private Long dishId; //TODO need to update to add foreign key here once dish entity done
    private Long reviewerUserId; //TODO need to update foreign key once user entity done
}
