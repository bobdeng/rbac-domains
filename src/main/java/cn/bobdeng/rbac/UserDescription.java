package cn.bobdeng.rbac;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class UserDescription {
    private String name;

    public UserDescription(String name) {

        this.name = name;
    }
}
