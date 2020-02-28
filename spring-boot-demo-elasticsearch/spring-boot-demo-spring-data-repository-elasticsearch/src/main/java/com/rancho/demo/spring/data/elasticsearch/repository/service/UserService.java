package com.rancho.demo.spring.data.elasticsearch.repository.service;

import com.rancho.demo.spring.data.elasticsearch.repository.entity.User;

public interface UserService {

    void save(User user);

    void update(User user);

    User getById(String id);

    User getByName(String name);

    void delete(String id);
}
