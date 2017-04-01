package pl.sda.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.sda.dao.BikeRepository;
import pl.sda.dao.UserRepository;
import pl.sda.model.Bike;
import pl.sda.model.User;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements UserDetailsService {

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
        Bike bike = bikeRepository.findByBikeId(bikeId);
        User user = userRepository.findByUserId(userId);

        bike.setUserBorrowed(user);
        bike.setStationStandingOn(null);
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = userRepository.findByLogin(login);
        List<GrantedAuthority> authorities = new ArrayList<>();

        if (user == null) {
            throw new UsernameNotFoundException(login);
        }
        if (user.getRole().isEmpty() || user.getRole() == null) {
            authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        } else {
            authorities.add(new SimpleGrantedAuthority(user.getRole()));
        }

        return new org.springframework.security.core.userdetails.User(
                user.getLogin(),
                user.getPassword(),
                authorities
        );
    }
}
