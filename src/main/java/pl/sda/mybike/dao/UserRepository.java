package pl.sda.mybike.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sda.mybike.model.User;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User findByLogin(String login);

    User findByUserId(Integer userId);

}