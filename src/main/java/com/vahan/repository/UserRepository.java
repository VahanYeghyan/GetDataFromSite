package com.vahan.repository;

/**
 * Created by vahan on 2/2/17.
 */

import com.vahan.domain.Users;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
@Configuration
public interface UserRepository extends JpaRepository<Users, Integer> {
    Users findByUsername(String userName);
}
