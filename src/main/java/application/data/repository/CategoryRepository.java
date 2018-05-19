package application.data.repository;

import application.data.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ManhNguyen on 3/30/18.
 */
public interface CategoryRepository extends JpaRepository<Category, Integer> {

    @Query("select u from tbl_category u where u.parentid = :parentid")
    List<Object[]> findCategoryByParentid(@Param("parentid") int parentid);

    List<Category> findAll();
}
