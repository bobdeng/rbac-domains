package cn.bobdeng.rbac;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class TenantLoginNamesTest {
    @Test
    public void save_account() {
        Tenant tenant = new Tenant(100, null);
        User user = new User(101, null);
        Tenant.LoginNames loginNames = mock(Tenant.LoginNames.class);
        when(loginNames.save(any(LoginName.class))).thenReturn(
                new LoginName(1, new LoginNameDescription("bob", user))
        );
        tenant.setLoginNames(loginNames);
        LoginNameDescription description = new LoginNameDescription("bob", user);
        LoginName loginName = new LoginName(description);

        LoginName result = tenant.addLoginName(loginName);

        verify(loginNames).save(loginName);
        assertEquals(result, new LoginName(1, new LoginNameDescription("bob", user)));
    }
}
