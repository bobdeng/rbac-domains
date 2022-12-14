package cn.bobdeng.rbac.domain;

import cn.bobdeng.rbac.domain.rbac.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserStatusTest {
    @Test
    public void test(){
        assertEquals(User.UserStatus.Normal, User.UserStatus.of("normal"));
        assertEquals(User.UserStatus.Locked, User.UserStatus.of("locked"));
    }
}