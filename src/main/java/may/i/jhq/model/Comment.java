package may.i.jhq.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by jinhuaquan on 2017/7/11.
 */
@Data
public class Comment implements Serializable{

    private static final long serialVersionUID = 1L;

    private Long id;

    private String content;

    private Long user;

    private Long article;

    private String status;

    private Date createTime;
}
