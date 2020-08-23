package spring.core.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Role {

    @Id//dodaje tabele role(zwykły urzytkownik, administrator)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int roleId;
    private RoleUserEnum roleName;


}
