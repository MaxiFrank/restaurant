package devmountain.group2;

import jakarta.persistence.*;

@Entity
@Table(name = "availability")
public class AvailabilityEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "tableId")
    private int tableId;

    @Column(name = "timeSlot")
    private String timeSlot;

    @Column(name = "isAvailable")
    private boolean isAvailable;
}
