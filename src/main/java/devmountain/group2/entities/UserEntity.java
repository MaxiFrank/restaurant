package devmountain.group2.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import devmountain.group2.dtos.UserDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "Users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(unique = true)
    private String username;

    @Column(unique = true)
    private String password;

// TODO do we need to implement one to many with reservation entity?

    public UserEntity(UserDto userDto) {
        if (userDto.getUsername() != null) {
            this.username = userDto.getUsername();
        }

        if (userDto.getPassword() != null) {
            this.password = userDto.getPassword();
        }
    }
}
