package spring.core.dto;


import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class UserDto {

    private Long userId;
    @NotEmpty
    @NotNull
    private String userLogin;
    private String userPassword;
    private String userName;
    private String userLastName;
    private String userAddress;
}
