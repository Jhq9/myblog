package may.i.jhq.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by jinhuaquan on 2017/7/19.
 */
@Data
public class ArticlePageDto implements Serializable{

    private int pageNo;

    private int pageSize;

    private String type;

    private String keyWords;
}
