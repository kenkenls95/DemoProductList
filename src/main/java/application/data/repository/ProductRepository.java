package application.data.repository;

import application.data.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query("select count(p.id) from tbl_product p")
    long getTotalProducts();

    @Query("SELECT u.name FROM tbl_product u")
    List<String> getAllName();

    @Query("select u from tbl_product u where u.name = :name")
    Object findByName(@Param("name") String name);

    ArrayList<Product> findByNameContaining(@Param("name") String name);

    @Query("select p from tbl_product p")
    ArrayList<Product> getAllProducts();

    @Query("select p from tbl_product p where p.id = :id")
    Product findById(@Param("id") int id);
}
