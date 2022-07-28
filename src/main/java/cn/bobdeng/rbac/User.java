package cn.bobdeng.rbac;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode
public class User implements Entity<Integer, UserDescription> {
    @Getter
    @Setter
    private Integer id;
    @Getter
    @Setter
    private UserDescription description;

    public User(UserDescription userDescription) {
        this.description = userDescription;
    }

    @Override
    public Integer identity() {
        return id;
    }

    @Override
    public UserDescription description() {
        return description;
    }
}
