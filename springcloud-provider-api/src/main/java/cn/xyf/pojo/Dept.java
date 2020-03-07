package cn.xyf.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;


@Data
@NoArgsConstructor
@Accessors(chain = true)
public class Dept implements Serializable {
    private int id;
    private String name;
    private String dbSource;

    public Dept(String name) {
        this.name = name;
    }
}
