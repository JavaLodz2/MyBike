package pl.sda.service;


import pl.sda.model.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();
    User getUser(int userId);
    void restBike(int bikeId, int userId);

}
