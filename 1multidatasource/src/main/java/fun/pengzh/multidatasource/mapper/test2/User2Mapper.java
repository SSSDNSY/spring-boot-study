package fun.pengzh.multidatasource.mapper.test2;

import fun.pengzh.multidatasource.entity.UserEntity;
import fun.pengzh.multidatasource.enums.UserSexEnum;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author fun.pengzh
 * @class pengzh.fun.multidatasource.mapper.test2.UserMapper
 * @desc
 * @since 2021-04-21
 */
public interface User2Mapper {

    @Select("SELECT * FROM users")
    @Results({
            @Result(property = "userSex", column = "user_sex", javaType = UserSexEnum.class),
            @Result(property = "nickName", column = "nick_name")
    })
    List<UserEntity> getAll();

    @Select("SELECT * FROM users WHERE id = #{id}")
    @Results({
            @Result(property = "userSex", column = "user_sex", javaType = UserSexEnum.class),
            @Result(property = "nickName", column = "nick_name")
    })
    UserEntity getOne(Long id);

    @Insert("INSERT INTO users(userName,passWord,user_sex) VALUES(#{userName}, #{passWord}, #{userSex})")
    void insert(UserEntity user);

    @Update("UPDATE users SET userName=#{userName},nick_name=#{nickName} WHERE id =#{id}")
    void update(UserEntity user);

    @Delete("DELETE FROM users WHERE id =#{id}")
    void delete(Long id);
}
