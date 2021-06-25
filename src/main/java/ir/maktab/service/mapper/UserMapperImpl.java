package ir.maktab.service.mapper;

import ir.maktab.data.domain.Users;
import ir.maktab.dto.UserDto;
import org.springframework.stereotype.Component;

@Component
public class UserMapperImpl implements UserMapper {
    @Override
    public Users toUser(UserDto dto) {
        Users user = new Users();
        user.setId(dto.getId());
        user.setName(dto.getName());
        user.setLastName(dto.getLastName());
        user.setPassword(dto.getPassword());
        user.setRole(dto.getRole());
        user.setSituation(dto.getSituation());
        user.setDate(dto.getRegistrationDay());
        user.setWallet(dto.getWallet());
        return user;
    }

    @Override
    public UserDto toUserDto(Users user) {
        UserDto dto = new UserDto();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setLastName(user.getLastName());
        dto.setPassword(user.getPassword());
        dto.setRegistrationDay(user.getDate());
        dto.setRole(user.getRole());
        dto.setSituation(user.getSituation());
        dto.setWallet(user.getWallet());
        return dto;
    }
}
