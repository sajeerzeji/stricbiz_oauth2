package com.stricbiz.oauth.persistence.repository;

import com.stricbiz.oauth.persistence.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author sajeer
 * @date 23/10/20
 */
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}