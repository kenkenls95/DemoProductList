package application.data.repository;

import application.data.model.UserRole;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;


public interface IUserRoleRepository extends CrudRepository<UserRole, Integer> {

    @Transactional(readOnly = true)
    @Query("select u from tbl_userrole u where u.userId = :id")
    Iterable<UserRole> findRolesOfUser(@Param("id") int userId);

    @Query("select r from tbl_userrole r where r.userId=:userId")
    UserRole findRoleIdByUserId(@Param("userId") int userId);

    @Query("select u from tbl_userrole u")
    ArrayList<UserRole> getUserRole();
}
