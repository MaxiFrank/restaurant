package devmountain.group2;

import jakarta.persistence.*;

@Entity
@Table(name = "menu")
public class MenuEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "dishName")
    private String dishName;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private Float price;
}
