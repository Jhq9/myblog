package may.i.jhq.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by jinhuaquan on 2017/7/11.
 */
@Data
public class ChildComment implements Serializable{

    private static final long serialVersionUID = 1L;

    private Long id;

    /**
     * 父评论的ID
     */
    private Long parentComment;

    private Date createTime;

    private String content;

    private String status;

    /**
     * 所回复的用户
     */
    private Long toUser;

    /**
     * 进行回复的用户
     */
    private Long fromUser;

}
