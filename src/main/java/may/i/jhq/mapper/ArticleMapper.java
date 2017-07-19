package may.i.jhq.mapper;

import may.i.jhq.dto.ArticleDto;
import may.i.jhq.dto.ArticleIntroDto;
import may.i.jhq.dto.ArticlePageDto;
import may.i.jhq.model.Article;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by jinhuaquan on 2017/7/11.
 */
@Mapper
public interface ArticleMapper {

    Long save(Article article);

    int update(@Param("articleDto") ArticleDto articleDto);

    List<ArticleIntroDto> findPageArts(@Param("articlePageDto")ArticlePageDto articlePageDto);
    Article findById(@Param("id") Long id);

    int deleteById(@Param("id") Long id);

    int countArticles(@Param("articlePageDto")ArticlePageDto articlePageDto);

}
