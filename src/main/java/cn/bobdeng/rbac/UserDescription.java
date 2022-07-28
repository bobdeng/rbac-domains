package cn.bobdeng.rbac;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
@Data
public class UserDescription {
    private String name;

    public UserDescription(String name) {

        this.name = name;
    }
}
