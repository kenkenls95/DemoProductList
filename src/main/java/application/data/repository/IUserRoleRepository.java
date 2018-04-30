package application.data.repository;

import application.data.model.UserRole;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;


public interface IUserRoleRepository extends CrudRepository<UserRole, Integer> {

    @Transactional(readOnly = true)
    @Query("select u from tbl_userrole u where u.userId = :id")
    Iterable<UserRole> findRolesOfUser(@Param("id") int userId);

}
