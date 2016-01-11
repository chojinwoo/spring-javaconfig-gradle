package com.spring.javaconfig.wa.users.repository;

import com.spring.javaconfig.wa.users.entity.UsersAuth;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by bangae1 on 2016-01-11.
 */
public interface UsersAuthRepository extends JpaRepository<UsersAuth, String> {
}
