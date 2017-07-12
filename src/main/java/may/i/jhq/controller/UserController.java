package may.i.jhq.controller;

import may.i.jhq.dto.UserDto;
import may.i.jhq.model.Role;
import may.i.jhq.model.User;
import may.i.jhq.service.RoleService;
import may.i.jhq.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * Created by jinhuaquan on 2017/7/11.
 */
@RestController
//@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private Md5PasswordEncoder md5PasswordEncoder;

    @Autowired
    private RoleService roleService;

    @PostMapping("/user/save")
    public Long saveUser(@RequestBody UserDto userDto){
        User user = new User();
        user.setCreateTime(new Date());
        user.setPassword(md5PasswordEncoder.encodePassword(userDto.getPassword(),""));
        Role role = roleService.findRoleById(userDto.getRoleId());
        user.setRole(role);
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());

        userService.saveUser(user);
        user = userService.findUserByEmail(user.getEmail());
        System.out.println("user:"+user+"     role:"+role.toString());
        return user.getId();
    }

    @GetMapping("/login")
    public String login(@RequestHeader String email,@RequestHeader String password)
    {
        System.out.println(email);
//        password = md5PasswordEncoder.encodePassword(password,"may");
//        System.out.println(password);
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(email,password);
        System.out.println(token);
       try {
           // 用户名密码登陆效验
           Authentication authentication = authenticationManager.authenticate(token);
           SecurityContext ctx = SecurityContextHolder.createEmptyContext();
           SecurityContextHolder.setContext(ctx);
           SecurityContextHolder.getContext().setAuthentication(authentication);
           System.out.println(authentication.isAuthenticated());
       }catch (AuthenticationException e){
           e.printStackTrace();
            return "Authentication fail!";
       }
        return "Login Susscess";
    }

//    @PreAuthorize("hasAnyRole('author','reader')")
    @GetMapping("/hello")
    public String hello(){
        return "Hello";
    }

    @PreAuthorize("hasAnyRole('author','reader')")
    @GetMapping("/home")
    public String welcome(){
        return "welcome";
    }

    @GetMapping("/logout")
    public String logout(){
        return "logOut";
    }

}
