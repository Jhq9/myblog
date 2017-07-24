package may.i.jhq.mapper;

import may.i.jhq.dto.CommentsDto;
import may.i.jhq.model.Comment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by jinhuaquan on 2017/7/11.
 */
@Mapper
public interface CommentMapper {

    Long save(Comment comment);

    int deleteById(Long id);

    List<CommentsDto> findAllByArticle(Long article);
}
