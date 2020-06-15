package io.example.springsecuritydemo.repositories;

/*import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.example.springsecuritydemo.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	User findByUsername(String userName);
	
}
*/

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.example.springsecuritydemo.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	User findByUsername(String username);

}