package cn.bobdeng.rbac;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
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
