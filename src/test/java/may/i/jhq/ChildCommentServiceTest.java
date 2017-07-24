package may.i.jhq;

import may.i.jhq.model.Article;
import may.i.jhq.model.ChildComment;
import may.i.jhq.model.Comment;
import may.i.jhq.model.User;
import may.i.jhq.service.ArticleService;
import may.i.jhq.service.ChildCommentService;
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

import java.util.Date;
import java.util.List;

/**
 * Created by jinhuaquan on 2017/7/20.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {DataSourceAutoConfiguration.class,MyblogApplication.class})
public class ChildCommentServiceTest {

    @Autowired
    private CommentService commentService;

    @Autowired
    private UserService userService;

    @Autowired
    private ArticleService articleService;

    @Autowired
    private ChildCommentService childCommentService;

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
        Comment comment = new Comment();
        comment.setContent("good");
        comment.setUser(user.getId());
        comment.setArticle(article.getId());
        comment.setStatus("新建");

        commentService.addComment(comment);

        ChildComment childComment = new ChildComment();
        childComment.setStatus("新建");
        childComment.setContent("子评论");
        childComment.setFromUser(user.getId());
        childComment.setCreateTime(new Date());
        childComment.setToUser(user.getId());
        childComment.setParentComment(comment.getId());

        Long id = childCommentService.saveChildComment(childComment);

        ChildComment childComment2 = new ChildComment();
        childComment2.setStatus("新建");
        childComment2.setContent("子评论");
        childComment2.setFromUser(user.getId());
        childComment2.setCreateTime(new Date());
        childComment2.setToUser(user.getId());
        childComment2.setParentComment(comment.getId());
        childCommentService.saveChildComment(childComment2);
        System.out.println("id"+id);
    }


    @Test
    public void testFindChildComment(){

        List<ChildComment> childComments = childCommentService.findByParentComment(1L);
        Assert.assertSame(1,childComments.size());
    }

    @Test
    public void testGetAllComments(){
        System.out.println(commentService.getAllComments(1L));
    }


}
