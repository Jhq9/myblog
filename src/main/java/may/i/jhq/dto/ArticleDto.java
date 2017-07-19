package may.i.jhq.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by jinhuaquan on 2017/7/18.
 */
@Data
public class ArticleDto implements Serializable{

    private Long id;

    private String title;

    private String content;

    private String keyWords;

    private String type;

    private Date updateTime;
}
