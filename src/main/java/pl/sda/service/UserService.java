package pl.sda.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.dao.BikeRepository;
import pl.sda.dao.UserRepository;
import pl.sda.model.Bike;
import pl.sda.model.User;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BikeRepository bikeRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUser(int userId) {
        return userRepository.findByUserId(userId);
    }

    public void rentBike(int bikeId, int userId) {
        userId = 1;
        Bike bike = bikeRepository.findByBikeId(bikeId);
        User user = userRepository.findByUserId(userId);

        bike.setUserBorrowed(user);
        bike.setStationStandingOn(null);

       bikeRepository.save(bike);
    }
}
