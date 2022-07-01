package com.javamaster.pagination.servise;

import com.javamaster.pagination.model.User;
import com.javamaster.pagination.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class UserService {

    private final UserRepository userRepository;

    public Page<User> fetchUsers(Integer page, Integer pageSize, String sortingField, String sortingDirection){
        Sort sort = Sort.by(Sort.Direction.valueOf(sortingDirection), sortingField);
        Pageable pageable = PageRequest.of(page, pageSize, sort);
        return userRepository.findAll(pageable);
    }

    public void enrichDb(){
        List<User> users = new ArrayList<>();
        for (int i = 0; i<1000; i++){
            User u = new User();
            u.setAge(i);
            u.setEmail("email" + i + "@gmail.com");
            u.setLogin("Login" + i);
            users.add(u);
        }
        userRepository.saveAll(users);
    }

}
