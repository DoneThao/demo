package com.example.elearningdemoservice.mapper;

import org.mapstruct.Mapper;
import com.example.elearningdemoservice.dto.UserDTO;
import com.example.elearningdemoservice.model.User;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User userDtoToUser(UserDTO userDTO);
    UserDTO userToUserDTO(User user);
    List<UserDTO> listUserToListUserDTO(List<User> users);
}
