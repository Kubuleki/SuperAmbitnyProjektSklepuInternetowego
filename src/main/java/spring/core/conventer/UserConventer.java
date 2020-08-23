package spring.core.conventer;

import spring.core.dto.UserDto;
import spring.core.model.User;

public class UserConventer {

    public static UserDto mapToDto(User user){
        return UserDto.builder()
                .userId(user.getUserId())
                .userLogin(user.getUserLogin())
                .userPassword(user.getUserPassword())
                .userName(user.getUserName())
                .userLastName(user.getUserLastName())
                .userAddress(user.getUserAddress())
                .build();

    }

    public static User mapFromDto(UserDto user){
        return User.builder()
                .userLogin(user.getUserLogin())
                .userPassword(user.getUserPassword())
                .userName(user.getUserName())
                .userLastName(user.getUserLastName())
                .userAddress(user.getUserAddress())
                .build();
    }
}
