package ir.maktab.service;

import ir.maktab.data.repository.UserRepository;
import ir.maktab.data.repository.UserSpecification;
import ir.maktab.dto.FilterUsersDto;
import ir.maktab.dto.UserDto;
import ir.maktab.service.mapper.UserMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper mapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper mapper) {
        this.userRepository = userRepository;
        this.mapper = mapper;
    }

    @Override
    public List<UserDto> fetchAllUsers() {
        return userRepository.findAll()
                .stream().map
                        (mapper::toUserDto)
                .collect(Collectors.toList());

    }

    @Override
    public void saveNewUser(UserDto userDto) {

        userRepository.save(mapper.toUser(userDto));
    }

    @Override
    public List<UserDto> filterUsers(FilterUsersDto dto) {
        return userRepository.findAll(UserSpecification.filterUsers(dto)).stream().map(mapper::toUserDto)
                .collect(Collectors.toList());
    }

}
