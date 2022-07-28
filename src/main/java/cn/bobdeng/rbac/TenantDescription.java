package cn.bobdeng.rbac;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
@Data
public class TenantDescription {
    private String name;

    public TenantDescription(String name) {
        this.name = name;
    }
}
