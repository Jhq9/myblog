package may.i.jhq;

import may.i.jhq.dto.ArticleDto;
import may.i.jhq.dto.ArticleIntroDto;
import may.i.jhq.dto.ArticlePageDto;
import may.i.jhq.model.Article;
import may.i.jhq.model.User;
import may.i.jhq.service.ArticleService;
import may.i.jhq.service.UserService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

/**
 * Created by jinhuaquan on 2017/7/18.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {DataSourceAutoConfiguration.class,MyblogApplication.class})
public class ArticleServiceTest {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private UserService userService;

    @Before
    public void insertArticle(){



        User user = userService.findUserByEmail("1044038055@qq.com");

        Article article = new Article();

        article.setContent("你好啊");
        article.setKeyWords("test");
        article.setTitle("测试文档");
        article.setType("TEST");
        article.setUser(user);

        articleService.saveNewArticle(article);

        Article article2 = new Article();

        article2.setContent("你好啊2");
        article2.setKeyWords("test2");
        article2.setTitle("测试文档2");
        article2.setType("TEST2");
        article2.setUser(user);

        articleService.saveNewArticle(article2);
    }

    @Test
    public void testFindById(){
        User user = userService.findUserById(4L);
        System.out.println(user);
        Article article = articleService.findById(1l);
        System.out.println(article);
    }


    @Test
    public void testFindPageArts(){
        ArticlePageDto articlePageDto = new ArticlePageDto();
        articlePageDto.setPageNo(1);
        articlePageDto.setPageSize(10);
        articlePageDto.setKeyWords("es");
        articlePageDto.setType("");
        List<ArticleIntroDto> articleIntroDtos = articleService.getPageArts(articlePageDto);
        System.out.println(articleIntroDtos);
        Assert.assertSame(articleIntroDtos.size(),2);

    }


    @Test
    public void testUpdateArt(){
        ArticleDto articleDto = new ArticleDto();
        articleDto.setId(1L);
        articleDto.setKeyWords("修改");
        articleDto.setType("内容修改");
        articleDto.setTitle("修改");
        articleDto.setUpdateTime(new Date());
        articleDto.setContent("update");

        Article article = articleService.updateArticle(articleDto);

        System.out.println(article);
    }

    @Test
    public void testDeleteArtById(){
        System.out.println(articleService.deleteArtById(1L));
    }

    @Test
    public void testCountArticles(){
        ArticlePageDto articlePageDto = new ArticlePageDto();
        articlePageDto.setPageNo(1);
        articlePageDto.setPageSize(10);
        articlePageDto.setKeyWords("es");
        articlePageDto.setType("");

        int num = articleService.countArticle(articlePageDto);
        Assert.assertSame(2,num);
    }
}
