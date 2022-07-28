package cn.bobdeng.rbac;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@EqualsAndHashCode
public class LoginName implements Entity<Integer, Object> {
    private Integer id;
    private LoginNameDescription description;

    public LoginName(Integer id, LoginNameDescription description) {
        this.id = id;
        this.description = description;
    }

    public LoginName(LoginNameDescription description) {
        this.description = description;
    }

    @Override
    public Integer identity() {
        return id;
    }

    @Override
    public Object description() {
        return description;
    }
}
