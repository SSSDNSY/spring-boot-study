package fun.pengzh.multidatasource.mapper.test1;

import fun.pengzh.multidatasource.entity.UserEntity;

import java.util.List;

/**
 * @author fun.pengzh
 * @class pengzh.fun.multidatasource.mapper.test1.UserMapper
 * @desc
 * @since 2021-04-21
 */
public interface User1Mapper {
    List<UserEntity> getAll();

    UserEntity getOne(Long id);

    void insert(UserEntity user);

    void update(UserEntity user);

    void delete(Long id);
}
