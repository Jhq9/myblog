package may.i.jhq.mapper;

import may.i.jhq.model.Role;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by jinhuaquan on 2017/7/11.
 */
@Mapper
public interface RoleMapper {

    Role findByName(String name);

    Role findById(Long id);

}
