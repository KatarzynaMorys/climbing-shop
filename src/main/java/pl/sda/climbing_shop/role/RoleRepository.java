package pl.sda.climbing_shop.role;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RoleRepository extends CrudRepository<Role, Integer> {

    Optional<Role> findRoleByNameIsLike(String name);

}
