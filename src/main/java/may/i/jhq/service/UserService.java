package may.i.jhq.service;

import lombok.AllArgsConstructor;
import may.i.jhq.mapper.UserMapper;
import may.i.jhq.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by jinhuaquan on 2017/7/11.
 */
@Service
@AllArgsConstructor
@Transactional
public class UserService {

    private final UserMapper userMapper;


    public Long saveUser(User user){
        return userMapper.insert(user);
    }

    public User findUserByEmail(String email){
//        System.out.println(userMapper.findByEmail(email));
        return userMapper.findByEmail(email);
    }
}
