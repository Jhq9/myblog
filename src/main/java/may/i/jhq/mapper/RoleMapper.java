package may.i.jhq.mapper;

import may.i.jhq.model.Role;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;

/**
 * Created by jinhuaquan on 2017/7/11.
 */
@Mapper
@CacheConfig(cacheNames = "role",cacheManager = "redisCacheManager")
public interface RoleMapper {


    Role findByName(String name);

    @Cacheable(key = "#p0")
    Role findById(Long id);


}
