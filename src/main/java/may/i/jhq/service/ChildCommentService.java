package may.i.jhq.service;

import lombok.AllArgsConstructor;
import may.i.jhq.mapper.ChildCommentMapper;
import may.i.jhq.model.ChildComment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by jinhuaquan on 2017/7/11.
 */
@Service
@Transactional
@AllArgsConstructor
public class ChildCommentService {

    private final ChildCommentMapper childCommentMapper;


    public Long saveChildComment(ChildComment childComment){
        return childCommentMapper.save(childComment);
    }

    public List<ChildComment> findByParentComment(Long parentComment){
        return childCommentMapper.findByParentComment(parentComment);
    }

}
