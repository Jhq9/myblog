package may.i.jhq.service;

import lombok.AllArgsConstructor;
import may.i.jhq.dto.ArticleDto;
import may.i.jhq.dto.ArticleIntroDto;
import may.i.jhq.dto.ArticlePageDto;
import may.i.jhq.mapper.ArticleMapper;
import may.i.jhq.model.Article;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by jinhuaquan on 2017/7/11.
 */
@Service
@Transactional
@AllArgsConstructor
public class ArticleService {

    private final ArticleMapper articleMapper;

    private static final Logger logger = LoggerFactory.getLogger(ArticleService.class);


    /**
     * 保存新文章
     * @param article
     * @return
     */
    public Long saveNewArticle(Article article){
        article.setCreateTime(new Date());

        Long id = articleMapper.save(article);

        return id;
    }

    /**
     * 根据ID查询出文章
     * @param id
     * @return
     */
    public Article findById(Long id){
       Article article = articleMapper.findById(id);
//       System.out.println(article);

        return article;
    }

    /**
     * 分页查询
     * @param articlePageDto
     * @return
     */
    public List<ArticleIntroDto> getPageArts(ArticlePageDto articlePageDto){
//        int start = (pageNo-1)*pageSize;

        return  articleMapper.findPageArts(articlePageDto);
    }

    /**
     * 更新文章信息
     * @param articleDto
     * @return
     */
    public Article updateArticle(ArticleDto articleDto){
        int num = articleMapper.update(articleDto);
        System.out.println("num:"+num);
        Article article = articleMapper.findById(articleDto.getId());

        return article;
    }

    /**
     * 根据ID删除指定的文章
     * @param id
     * @return
     */
    public int deleteArtById(Long id)
    {
        return articleMapper.deleteById(id);
    }

    public int countArticle(ArticlePageDto articlePageDto){
        return  articleMapper.countArticles(articlePageDto);
    }
}
