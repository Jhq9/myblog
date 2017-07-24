package may.i.jhq;

import may.i.jhq.model.Article;
import may.i.jhq.model.Comment;
import may.i.jhq.model.User;
import may.i.jhq.service.ArticleService;
import may.i.jhq.service.CommentService;
import may.i.jhq.service.UserService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by jinhuaquan on 2017/7/20.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {DataSourceAutoConfiguration.class,MyblogApplication.class})
public class CommentServiceTest {

    @Autowired
    private CommentService commentService;

    @Autowired
    private UserService userService;

    @Autowired
    private ArticleService articleService;

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
    }

    @Test
    public void testCommentSave(){
        User user = userService.findUserByEmail("1044038055@qq.com");
        Article article = articleService.findById(1L);
        Comment comment = new Comment();
        comment.setContent("good");
        comment.setUser(user.getId());
        comment.setArticle(article.getId());
        comment.setStatus("新建");

        int id = commentService.addComment(comment);
        Assert.assertSame(1,id);
    }



}
