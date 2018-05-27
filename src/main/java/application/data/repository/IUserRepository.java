package application.data.repository;

import application.data.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface IUserRepository extends CrudRepository<User, Integer> {

    @Transactional(readOnly = true)
    @Query("select u from tbl_user u where u.email = :email")
    Iterable<User> findByEmail(@Param("email") String email);

    @Transactional(readOnly = true)
    @Query("select u from tbl_user u where u.username = :username")
    Iterable<User> findByUsername(@Param("username") String username);

    @Query("select p.imageurl from tbl_user p where p.username =:username")
    String getImgByUserName(@Param("username") String username);

}

