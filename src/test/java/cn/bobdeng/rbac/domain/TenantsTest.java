package cn.bobdeng.rbac.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class TenantsTest {
    private TenantRepository tenantRepository;
    private Tenants tenants;

    @BeforeEach
    public void setup() {
        tenantRepository = mock(TenantRepository.class);
        tenants = new Tenants(tenantRepository);
    }

    @Test
    public void new_tenant() {
        TenantDescription tenantDescription = new TenantDescription("租户1");
        tenants.add(tenantDescription);
        verify(tenantRepository).save(new Tenant(tenantDescription));
    }


}
