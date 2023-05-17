package devmountain.group2;

import jakarta.persistence.*;

@Entity
@Table(name = "availability")
public class AvailabilityEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "availability_id")
    private Long id;

    @Column(name = "table_id")
    private int table_id;

    @Column(name = "time_slot")
    private String timeSlot;

    @Column(name = "is_available")
    private boolean isAvailable;
}
