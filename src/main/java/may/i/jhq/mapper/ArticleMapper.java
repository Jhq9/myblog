package may.i.jhq.mapper;

import may.i.jhq.model.Article;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by jinhuaquan on 2017/7/11.
 */
@Mapper
public interface ArticleMapper {

    Long save(Article article);


}
