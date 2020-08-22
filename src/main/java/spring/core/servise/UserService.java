package spring.core.servise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.core.conventer.UserConventer;
import spring.core.dto.UserDto;
import spring.core.model.User;
import spring.core.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserDto> getAllUsers(){
        final List<User> users = userRepository.findAll();
        return users
                .stream()
                .map(UserConventer::mapToDto)
                .collect(Collectors.toList());
    }

    public void addNewUser(UserDto newUser){
        final User user = UserConventer.mapFromDto(newUser);
        userRepository.save(user);
    }
}
