package may.i.jhq.config.security;

import may.i.jhq.model.Role;
import may.i.jhq.model.User;
import may.i.jhq.service.RoleService;
import may.i.jhq.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by jinhuaquan on 2017/7/11.
 */
public class GeneratorUserDetailService implements UserDetailsService{

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userService.findUserByEmail(email);

        if (user ==  null){
            throw new UsernameNotFoundException(email);
        }

        Role role = user.getRole();

        SecurityUser securityUser = new SecurityUser(user);

        Collection<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority(role.getName()));

        return securityUser;

    }
}
