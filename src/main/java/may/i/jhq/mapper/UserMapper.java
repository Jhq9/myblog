package may.i.jhq.mapper;

import may.i.jhq.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Created by jinhuaquan on 2017/7/11.
 */
@Mapper
public interface UserMapper {

//    @Options(keyColumn = "id",useGeneratedKeys = true)

//    @Insert("INSERT INTO USER(name,email,role,create_time) VALUES(#{name},#{email},#{role},#{createTime})")
    Long insert(User user);

    User findByEmail(@Param("email") String email);
}
