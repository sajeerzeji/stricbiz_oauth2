package com.stricbiz.oauth.persistence.repository;

import com.stricbiz.oauth.persistence.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author sajeer
 * @date 23/10/20
 */
public interface RoleRepository extends JpaRepository<Role, Long> {
}
