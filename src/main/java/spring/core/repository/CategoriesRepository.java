package spring.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.core.model.Categories;

@Repository
public interface CategoriesRepository extends JpaRepository<Categories, Long> {
}
