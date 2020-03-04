package spring.boot.demo.spring.data.elasticsearch.repository.service.impl;

import spring.boot.demo.spring.data.elasticsearch.repository.entity.User;
import spring.boot.demo.spring.data.elasticsearch.repository.repository.UserRepository;
import spring.boot.demo.spring.data.elasticsearch.repository.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserRepository userRepository;

    @Override
    public User getById(String id) {
        return userRepository.findById(id).get();
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public User getByName(String name) {
        return userRepository.findByName(name);
    }

    @Override
    public void delete(String id) {
        userRepository.deleteById(id);
    }

    @Override
    public void update(User user) {
        userRepository.delete(user);
        userRepository.save(user);
    }
}
