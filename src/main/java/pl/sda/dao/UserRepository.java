package pl.sda.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sda.model.Bikes;
import pl.sda.model.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {

    Users findByLogin(String login);
    Users findByUserId(Integer userId);
    Users findByBike(Bikes bike);

}
