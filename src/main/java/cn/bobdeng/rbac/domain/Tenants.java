package cn.bobdeng.rbac.domain;

import java.util.Optional;

public class Tenants {
    private TenantRepository tenantRepository;

    public Tenants(TenantRepository tenantRepository) {

        this.tenantRepository = tenantRepository;
    }

    public Tenant add(TenantDescription tenantDescription) {
        return this.tenantRepository.save(new Tenant(tenantDescription));
    }

    public Optional<Tenant> findById(Integer id) {
        return this.tenantRepository.findByIdentity(id);
    }
}
