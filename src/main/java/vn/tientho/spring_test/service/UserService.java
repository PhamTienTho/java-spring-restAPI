package vn.tientho.spring_test.service;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import vn.tientho.spring_test.exception.DuplicateResourceException;
import vn.tientho.spring_test.exception.ResourceNotFoundException;
import vn.tientho.spring_test.model.User;
import vn.tientho.spring_test.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<User> getAllUsers() {
        return this.userRepository.findAll();
    }

    public User getUserById(Long id) {
        return this.userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Người dùng", "id", id));
    }

    public User createUser(User user) {
        if(this.userRepository.existsByEmail(user.getEmail())) {
            throw new DuplicateResourceException("Người dùng", "Email", user.getEmail());
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return this.userRepository.save(user);
    }

    public User updateUser(User user, long id) {
        if(!this.userRepository.existsById(id)) {
            throw new ResourceNotFoundException("Người dùng", "id", id);
        }
        user.setId(id);
        return this.userRepository.save(user);
    }

    public void deleteUser(Long id) {
        if(!this.userRepository.existsById(id)) {
            throw new ResourceNotFoundException("Người dùng", "id", id);
        }
        this.userRepository.deleteById(id);
    }

    public boolean existsByEmail(String email) {
        return this.userRepository.existsByEmail(email);
    }
}
