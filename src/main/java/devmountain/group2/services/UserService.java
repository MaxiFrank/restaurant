package devmountain.group2.services;

import devmountain.group2.dtos.UserDto;
import jakarta.transaction.Transactional;

import java.util.List;

public interface UserService {
    @Transactional
    List<String> addUser(UserDto userDto);

    @Transactional
    List<String> userLogin(UserDto userDto);

    @Transactional
    List<String> userLogout(UserDto userDto);
}
