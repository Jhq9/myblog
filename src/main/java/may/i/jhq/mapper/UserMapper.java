package may.i.jhq.mapper;

import may.i.jhq.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;

/**
 * Created by jinhuaquan on 2017/7/11.
 */
@Mapper
@CacheConfig(cacheNames = "userCache",cacheManager = "appEhCacheCacheManager")
public interface UserMapper {

//    @Options(keyColumn = "id",useGeneratedKeys = true)

//    @Insert("INSERT INTO USER(name,email,role,create_time) VALUES(#{name},#{email},#{role},#{createTime})")
    Long insert(User user);

    @Cacheable
    User findByEmail(@Param("email") String email);

    User findById(@Param("id") Long id);

}
