package may.i.jhq.mapper;

import may.i.jhq.model.ChildComment;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by jinhuaquan on 2017/7/11.
 */
@Mapper
public interface ChildCommentMapper {

    Long save(ChildComment childComment);

}
