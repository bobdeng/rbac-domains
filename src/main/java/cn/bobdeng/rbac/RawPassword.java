package cn.bobdeng.rbac;

import lombok.Data;

@Data
public class RawPassword {
    private String rawPassword;

    public RawPassword(String rawPassword) {
        this.rawPassword = rawPassword;
    }
}
