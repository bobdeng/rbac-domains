package cn.bobdeng.rbac;

import lombok.Data;

@Data
public class UserAccount {
    private String account;

    public UserAccount(String account) {
        this.account = account;
    }
}
