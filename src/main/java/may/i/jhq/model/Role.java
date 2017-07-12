package may.i.jhq.model;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by jinhuaquan on 2017/7/11.
 */
@Data
public class Role implements Serializable {


    private static final long serialVersionUID = 1L;

    private Long id;

    private String name;

}
