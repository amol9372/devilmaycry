package practice.amol.springsecuritybasic.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import practice.amol.springsecuritybasic.security.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    
	Optional<User> findByUserName(String userName);
}
