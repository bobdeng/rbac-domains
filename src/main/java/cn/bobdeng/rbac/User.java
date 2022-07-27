package cn.bobdeng.rbac;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class User {
    private UserDescription userDescription;

    public User(UserDescription userDescription) {
        this.userDescription = userDescription;
    }
}
