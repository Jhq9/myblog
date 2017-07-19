package may.i.jhq.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by jinhuaquan on 2017/7/18.
 * 文章简介
 */
@Data
public class ArticleIntroDto implements Serializable{

    private Long id;

    private String title;

    private String keyWords;

    private String type;

    private Date createTime;

    private Date updateTime;

}
