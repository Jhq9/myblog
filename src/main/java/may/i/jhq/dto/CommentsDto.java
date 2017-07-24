package may.i.jhq.dto;

import lombok.Data;
import may.i.jhq.model.ChildComment;
import may.i.jhq.model.Comment;

import java.io.Serializable;
import java.util.List;

/**
 * Created by jinhuaquan on 2017/7/20.
 */
@Data
public class CommentsDto implements Serializable{

    private Comment comment;

    private List<ChildComment> childComments;
}
