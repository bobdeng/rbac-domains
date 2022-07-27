package cn.bobdeng.rbac;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class TenantDescription {
    private String name;

    public TenantDescription(String name) {
        this.name = name;
    }
}
