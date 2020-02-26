package badwomen.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @description:
 * @author: tanhao
 * @time: 2020/2/26 1:46
 */
@Data
public class Employee implements Serializable {
    private Integer id;
    private String username;
    private String password;
    private String salt;
    private String role;
}