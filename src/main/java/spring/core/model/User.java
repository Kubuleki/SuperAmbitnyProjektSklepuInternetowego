package spring.core.model;


import lombok.*;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Setter
@Getter

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
