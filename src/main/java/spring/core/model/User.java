package spring.core.model;


import lombok.*;

import javax.persistence.Entity;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class User {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long userId;
    private String userLogin;
    private String userPassword;
    private String userName;
    private String userLastName;
    private String UserAddress;

}
