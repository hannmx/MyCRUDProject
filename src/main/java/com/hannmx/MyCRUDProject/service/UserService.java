package com.hannmx.MyCRUDProject.service;

import com.hannmx.MyCRUDProject.model.User;
import com.hannmx.MyCRUDProject.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User saveUser(User user){
        return userRepository.save(user);
    }

    public void deleteById(int id) {
        userRepository.deleteById(id);
    }

    public User update(User user) {
        // Проверяем, существует ли пользователь с таким идентификатором
        if (userRepository.existsById(user.getId())) {
            // Если пользователь существует, то сохраняем обновленные данные
            return userRepository.save(user);
        } else {
            // Если пользователь не существует
            return null;
        }
    }

    public User getOne(int id) {
        // Ищем пользователя по его идентификатору
        return userRepository.findById(id);
    }

}
