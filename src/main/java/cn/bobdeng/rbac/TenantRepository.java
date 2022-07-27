package cn.bobdeng.rbac;

import java.util.stream.Stream;

public interface TenantRepository {
    Tenant save(Tenant tenant);

    Stream<Tenant> findByName(String name, int from, int to);

}
