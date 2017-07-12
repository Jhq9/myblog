package may.i.jhq.config.security;

import may.i.jhq.model.Role;
import may.i.jhq.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by jinhuaquan on 2017/7/11.
 */
public class SecurityUser extends User implements UserDetails{

    private static final long serialVersionUID = 1L;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

        Role role = this.getRole();

        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(role.getName());

        authorities.add(authority);

        return authorities;
    }

    public SecurityUser(User user) {
        if (user!=null){
            this.setRole(user.getRole());
            this.setEmail(user.getEmail());
            this.setPassword(user.getPassword());
            this.setCreateTime(user.getCreateTime());
            this.setId(user.getId());
            this.setName(user.getName());
        }

    }

    @Override
    public String getPassword() {
        return super.getPassword();
    }

    @Override
    public String getUsername() {
        return super.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
