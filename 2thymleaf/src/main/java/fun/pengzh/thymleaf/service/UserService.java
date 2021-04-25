package fun.pengzh.thymleaf.service;

import fun.pengzh.thymleaf.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

/**
 * @author fun.pengzh
 * @class fun.pengzh.thymleaf.service.UserService
 * @desc
 * @since 2021-04-22
 */
public interface UserService {
    List<User> findAll();

    Optional<User> findById(Long id);

    Page<User> findByPage(Pageable pageable);

    void save(User user);

    void delete(Long id);

    void edit(User user);
}
