package may.i.jhq.mapper;

import may.i.jhq.model.ChildComment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by jinhuaquan on 2017/7/11.
 */
@Mapper
public interface ChildCommentMapper {

    Long save(ChildComment childComment);


    List<ChildComment> findByParentComment(@Param("parentComment") Long parentComment);

}
