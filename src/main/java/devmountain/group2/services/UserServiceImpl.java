package devmountain.group2.services;

import devmountain.group2.dtos.UserDto;
import devmountain.group2.entities.UserEntity;
import devmountain.group2.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public List<String> addUser(UserDto userDto){
        List<String> response = new ArrayList<>();
        UserEntity user = new UserEntity(userDto);
        userRepository.saveAndFlush(user);
        response.add("/#signin");
        return response;
    }

    @Override
    @Transactional
    public List<String> userLogin(UserDto userDto) {
        List<String> response = new ArrayList<>();
        response.add("/#reserve");
        Optional<UserEntity> userOptional = userRepository.findByUsername(userDto.getUsername());
        if (userOptional.isPresent()) {
            if (passwordEncoder.matches(userDto.getPassword(), userOptional.get().getPassword())) {
                response.add("You've logged in");
                response.add(String.valueOf(userOptional.get().getUserId()));
                response.add(String.valueOf(userOptional.get().getPassword()));
            } else {
                response.add("Username or password incorrect");
            }
        } else {
            response.add("Username or password incorrect");
        }
        return response;
    }

    @Override
    @Transactional
    public List<String> userLogout(UserDto userDto) {
        List<String> response = new ArrayList<>();
        response.add("/");
        Optional<UserEntity> userOptional = userRepository.findByUsername(userDto.getUsername());
        if (userOptional.isPresent()) {
            response.add("you've logged out");
        } else {
            response.add("You were not logged in");
        }
        return response;
    }
}
