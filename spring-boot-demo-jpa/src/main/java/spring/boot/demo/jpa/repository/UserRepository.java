package spring.boot.demo.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.boot.demo.jpa.entity.User;

public interface UserRepository extends JpaRepository<User,Integer> {
}
