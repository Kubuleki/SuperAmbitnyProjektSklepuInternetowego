package spring.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.core.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
        public User findByNameAndLastName(String userName, String UserLastName);
}
