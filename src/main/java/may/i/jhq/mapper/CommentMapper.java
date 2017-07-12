package may.i.jhq.mapper;

import may.i.jhq.model.Comment;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by jinhuaquan on 2017/7/11.
 */
@Mapper
public interface CommentMapper {

    Comment save(Comment comment);

}
