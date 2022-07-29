package cn.bobdeng.rbac;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class PasswordDescription {
    private String password;

    public PasswordDescription(String password) {
        this.password = password;
    }

    public PasswordDescription(RawPassword rawPassword, User.UserPassword userPassword) {
        this.password = userPassword.encodePassword(rawPassword.getRawPassword());
    }
}
