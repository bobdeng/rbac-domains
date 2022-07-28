package cn.bobdeng.rbac;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public final class LoginNameDescription {
    private String name;
    private User user;
}
