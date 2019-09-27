package com.security.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.security.model.User;

@Repository
public interface JPARepository extends CrudRepository<User, Long> {
	@Query(value = "SELECT u FROM Customer u where u.userName = ?1 and u.password = ?2 ")
	Optional<User> login(String username, String password);

	Optional<User> findByToken(String token);
}
