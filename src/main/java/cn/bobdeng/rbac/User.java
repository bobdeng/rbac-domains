package cn.bobdeng.rbac;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@EqualsAndHashCode
@NoArgsConstructor
public class User implements Entity<Integer, UserDescription> {
    @Getter
    @Setter
    private Integer id;
    @Getter
    @Setter
    private UserDescription description;


    public User(Integer id, UserDescription description) {
        this.id = id;
        this.description = description;
    }

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
