package vn.tientho.spring_test.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import vn.tientho.spring_test.model.User;
import vn.tientho.spring_test.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService{

    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = this.userRepository.findByEmail(email);
        if(user == null) {
            throw new UsernameNotFoundException("Không tìm thấy ngừời dùng với email: " + email);
        }
        return org.springframework.security.core.userdetails.User.builder()
            .username(email)
            .password(user.getPassword())
            .roles("USER")
            .build();
    }
}
