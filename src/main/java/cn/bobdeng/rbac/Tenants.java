package cn.bobdeng.rbac;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class Tenants {
    private TenantRepository tenantRepository;

    public Tenants(TenantRepository tenantRepository) {

        this.tenantRepository = tenantRepository;
    }

    public void add(TenantDescription tenantDescription) {
        this.tenantRepository.save(new Tenant(tenantDescription));
    }
}
