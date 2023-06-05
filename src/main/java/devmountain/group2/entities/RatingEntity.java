package devmountain.group2.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    //this entity is for individual dish ratings mapped by the user who rated it
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    private int rating;
    @ManyToOne
    @JsonBackReference
    private DishEntity dish;
    @ManyToOne
    @JsonBackReference
    private UserEntity user;
}
