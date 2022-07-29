package cn.bobdeng.rbac;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Password implements Entity<Integer, PasswordDescription> {
    private Integer id;
    private PasswordDescription description;

    @Override
    public Integer identity() {
        return id;
    }

    @Override
    public PasswordDescription description() {
        return description;
    }
}
