package tp.rammour.demo.dao;

import tp.rammour.demo.models.Role;
import tp.rammour.demo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {
    Optional<User> findByPseudo(String pseudo);
}
