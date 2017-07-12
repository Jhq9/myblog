package may.i.jhq.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by jinhuaquan on 2017/7/11.
 */
@Data
public class Article implements Serializable{
    private static final long serialVersionUID = 1L;

    private Long id;

    private String title;

    private byte[] content;

    private String keyWords;

    private String type;

    private Long user;

    private Date createTime;

    private Date updateTime;
}
