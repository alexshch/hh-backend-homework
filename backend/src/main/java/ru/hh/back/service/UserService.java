package ru.hh.back.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.hh.back.dao.UserDao;
import ru.hh.back.dto.UserRequestDto;
import ru.hh.back.dto.UserResponseDto;
import ru.hh.back.entity.UserEntity;
import ru.hh.back.entity.UserType;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserDao userDao;
    @Autowired
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional
    public List<UserResponseDto> getUsers(String type) {
        var users = userDao.getUser(type.toUpperCase());
        return users.stream().map(Mapper::map).collect(Collectors.toList());
    }

    @Transactional
    public Integer saveUser(UserRequestDto user) {
        return userDao.save(new UserEntity(user.getName(), UserType.valueOf(user.getType())));
    }
}
