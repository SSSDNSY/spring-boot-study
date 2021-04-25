package fun.pengzh.thymleaf.repository;

import fun.pengzh.thymleaf.model.User;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

/**
 * @author fun.pengzh
 * @class fun.pengzh.thymleaf.repository.UserRepository
 * @desc
 * @since 2021-04-22
 */
public interface UserRepository extends PagingAndSortingRepository<User, Long> {

    @Override
    void deleteById(Long id);

    @Override
    Optional<User> findById(Long id);
}
