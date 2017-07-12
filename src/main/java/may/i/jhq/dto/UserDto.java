package may.i.jhq.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Email;

/**
 * Created by jinhuaquan on 2017/7/11.
 */
@Data
public class UserDto {

    @Email
    private String email;

    private String password;

    private Long roleId;

    private String name;

}
