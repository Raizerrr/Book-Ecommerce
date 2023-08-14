package fpoly.edu.assignment_java5.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fpoly.edu.assignment_java5.identity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByTelephone(int telephone);
    
    List<User> findAll();
    
}
