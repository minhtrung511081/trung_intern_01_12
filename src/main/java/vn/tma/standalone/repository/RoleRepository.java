package vn.tma.standalone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.tma.standalone.entity.RoleEntity;

public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
}
