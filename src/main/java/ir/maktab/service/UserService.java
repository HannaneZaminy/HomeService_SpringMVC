package ir.maktab.service;

import ir.maktab.dto.FilterUsersDto;
import ir.maktab.dto.UserDto;

import java.util.List;

public interface UserService {
    void saveNewUser(UserDto userDto);
    List<UserDto> filterUsers(FilterUsersDto dto);
    List<UserDto> fetchAllUsers();
}
