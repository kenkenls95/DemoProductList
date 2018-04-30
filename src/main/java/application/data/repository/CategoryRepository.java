package application.data.repository;

import application.data.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by ManhNguyen on 3/30/18.
 */
public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
