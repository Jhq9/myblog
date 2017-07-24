package may.i.jhq.service;

import lombok.AllArgsConstructor;
import may.i.jhq.dto.CommentsDto;
import may.i.jhq.mapper.CommentMapper;
import may.i.jhq.model.Comment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by jinhuaquan on 2017/7/11.
 */
@Service
@Transactional
@AllArgsConstructor
public class CommentService {

    private final CommentMapper commentMapper;

    private static final Logger logger = LoggerFactory.getLogger(CommentService.class);

    public int addComment(Comment comment){
        return commentMapper.save(comment).intValue();
    }

    public List<CommentsDto> getAllComments(Long article){
        List<CommentsDto> result = commentMapper.findAllByArticle(article);
        return result;
    }

}
