package cn.bobdeng.rbac;

import lombok.*;

import java.util.List;
import java.util.Optional;

@EqualsAndHashCode
@NoArgsConstructor
public class Tenant implements Entity<Integer, TenantDescription> {
    @Setter
    @Getter
    private Integer id;
    @Getter
    @Setter
    private TenantDescription description;
    @Setter
    private Users users;
    @Setter
    private LoginNames loginNames;


    public Tenant(TenantDescription tenantDescription) {

        this.description = tenantDescription;
    }

    public Tenant(Integer id, TenantDescription tenantDescription) {
        this.id = id;
        this.description = tenantDescription;
    }

    @Override
    public Integer identity() {
        return id;
    }

    @Override
    public TenantDescription description() {
        return description;
    }

    public User addUser(UserDescription userDescription) {
        return users.save(new User(userDescription));
    }

    public LoginName addLoginName(LoginName loginName) {
        return loginNames.save(loginName);
    }

    public interface Users extends EntityList<Integer, User> {
        User save(User user);

        List<User> findByName(String name);

        Optional<User> findByAccount(String account);
    }

    interface LoginNames extends EntityList<Integer, LoginName> {

    }
}
