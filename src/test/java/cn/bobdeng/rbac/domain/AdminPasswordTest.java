package cn.bobdeng.rbac.domain;

import cn.bobdeng.rbac.domain.rbac.AdminPassword;
import cn.bobdeng.rbac.domain.rbac.PasswordEncoder;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

class AdminPasswordTest {
    PasswordEncoder passwordEncoder = new PasswordEncoder() {
        @Override
        public String encode(String rawPassword) {
            return rawPassword.hashCode() + "";
        }

        @Override
        public boolean matches(String rawPassword, String encodedPassword) {
            return encode(rawPassword).equals(encodedPassword);
        }
    };

    @Test
    public void should_send_password_when_verify_fail() {
        AdminPassword.Notifier notifier = mock(AdminPassword.Notifier.class);
        AdminPassword.Store store = mock(AdminPassword.Store.class);

        AdminPassword adminPassword = new AdminPassword(notifier, store, passwordEncoder);

        assertFalse(adminPassword.verify("123"));

        verify(notifier).notify(anyString());
        verify(store).save(anyString());
    }

    @Test
    public void should_send_password_when_no_password() {

        AdminPassword.Notifier notifier = mock(AdminPassword.Notifier.class);
        AdminPassword.Store store = mock(AdminPassword.Store.class);
        when(store.get()).thenReturn(Optional.empty());
        AdminPassword adminPassword = new AdminPassword(notifier, store, passwordEncoder);

        assertFalse(adminPassword.verify("123"));

        verify(notifier).notify(anyString());
        verify(store).save(anyString());
    }

    @Test
    public void should_success_when_math() {
        AdminPassword.Notifier notifier = mock(AdminPassword.Notifier.class);
        AdminPassword.Store store = mock(AdminPassword.Store.class);
        when(store.get()).thenReturn(Optional.of(""));

        AdminPassword adminPassword = new AdminPassword(notifier, store, new PasswordEncoder() {
            @Override
            public String encode(String rawPassword) {
                return null;
            }

            @Override
            public boolean matches(String rawPassword, String encodedPassword) {
                return true;
            }
        });

        assertTrue(adminPassword.verify("123456"));

        verify(notifier, never()).notify(anyString());
        verify(store, never()).save(anyString());
    }

}