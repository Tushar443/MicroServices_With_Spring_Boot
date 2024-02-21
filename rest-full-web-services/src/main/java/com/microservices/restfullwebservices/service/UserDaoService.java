package com.microservices.restfullwebservices.service;

import com.microservices.restfullwebservices.dao.UserDao;
import com.microservices.restfullwebservices.entity.User;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class UserDaoService {

    private static List<User> userList = new ArrayList<>();

    private static int count = 0;

    static {
        userList.add(new User(++count, "Admin", LocalDate.now().minusYears(30)));
        userList.add(new User(++count, "jim", LocalDate.now().minusYears(14)));
        userList.add(new User(++count, "eve", LocalDate.now().minusYears(50)));
    }

    public List<User> findAll() {
        return userList;
    }

    public User findById(int id) {
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        return userList.stream().filter(predicate).findFirst().orElse(null);

//        for(User user : userList){
//            if(user.getId().equals(id)){
//                return user;
//            }
//        }
//        return null;
    }

    public User createUser(UserDao userDao) {
        User user = new User();
        user.setId(++count);
        BeanUtils.copyProperties(userDao, user);
        userList.add(user);
        return user;
    }

    public boolean deleteById(int id) {
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        return userList.removeIf(predicate);
    }
}
