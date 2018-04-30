package application.data.repository;

import application.data.model.Role;
import org.springframework.data.repository.CrudRepository;

public interface IRoleRepository extends CrudRepository<Role, Integer> {
}
