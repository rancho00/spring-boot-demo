package spring.boot.demo.spring.data.elasticsearch.repository.repository;

import spring.boot.demo.spring.data.elasticsearch.repository.entity.User;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface UserRepository extends ElasticsearchRepository<User, String> {

    User findByName(String name);
}
