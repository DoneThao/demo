package com.example.elearningdemoservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import com.example.elearningdemoservice.dto.UserDTO;
import com.example.elearningdemoservice.mapper.UserMapper;
import com.example.elearningdemoservice.model.User;
import com.example.elearningdemoservice.repository.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    private final PasswordEncoder encoder;

    public List<UserDTO> getAllUsers() {
        return userMapper.listUserToListUserDTO(userRepository.findAll());
    }

    public UserDTO findById(Long id){
        return userMapper.userToUserDTO(userRepository.findById(id).orElse(null));
    }
    public void save(UserDTO userDTO) {
        userDTO.setPassword(encoder.encode(userDTO.getPassword()));

        userRepository.save(userMapper.userDtoToUser(userDTO));
    }

    public void update(UserDTO userDTO) {
        User user = userRepository.findById(userDTO.getId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Khong tim thay tai nguyen!!!"));
        userDTO.setPassword(encoder.encode(user.getPassword()));

        userRepository.save(userMapper.userDtoToUser(userDTO));
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
