package fun.pengzh.multidatasource.controller;

import fun.pengzh.multidatasource.entity.UserEntity;
import fun.pengzh.multidatasource.mapper.test1.User1Mapper;
import fun.pengzh.multidatasource.mapper.test2.User2Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author fun.pengzh
 * @class pengzh.fun.multidatasource.controller.UserController
 * @desc
 * @since 2021-04-21
 */
@RestController
public class UserController {


    @Autowired
    private User1Mapper user1Mapper;

    @Autowired
    private User2Mapper user2Mapper;

    @RequestMapping("/user1/{id}")
    public UserEntity getUser1(@PathVariable Long id) {
        return user1Mapper.getOne(id);
    }

    @GetMapping("/user2/{id}")
    public UserEntity getUser2(@PathVariable Long id) {
        return user2Mapper.getOne(id);
    }

    @GetMapping("/users")
    public List<UserEntity> getUsers() {
        return user2Mapper.getAll();
    }


    @RequestMapping("/add")
    public void save(UserEntity user) {
        user2Mapper.insert(user);
    }

    @RequestMapping(value = "update")
    public void update(UserEntity user) {
        user2Mapper.update(user);
    }

    @RequestMapping(value = "/delete/{id}")
    public void delete(@PathVariable("id") Long id) {
        user1Mapper.delete(id);
    }

    @RequestMapping(value = "/delete2/{id}")
    public void delete2(@PathVariable("id") Long id) {
        user2Mapper.delete(id);
    }

}
