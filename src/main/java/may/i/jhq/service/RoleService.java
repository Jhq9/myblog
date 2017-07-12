package may.i.jhq.service;

import lombok.AllArgsConstructor;
import may.i.jhq.mapper.RoleMapper;
import may.i.jhq.model.Role;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by jinhuaquan on 2017/7/11.
 */
@Service
@Transactional
@AllArgsConstructor
public class RoleService {

    private RoleMapper roleMapper;

    public Role findRoleById(@Param("name") Long id){
        System.out.println(id);

        Role role = roleMapper.findById(id);
        System.out.println(role);
        return role;
    }

    public Role findRoleByName(@Param("name") String name){
        return roleMapper.findByName(name);
    }

}
