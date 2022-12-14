package cn.bobdeng.rbac.domain;

import cn.bobdeng.rbac.domain.rbac.RoleDescription;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RoleDescriptionTest {
    @Test
    public void has_permission(){
        assertTrue(new RoleDescription("", Arrays.asList("user.create"))
                .hasSomePermission(new String[]{"user.create"}));
        assertTrue(new RoleDescription("", Arrays.asList("user.create"))
                .hasSomePermission(new String[]{"user.create","user.new"}));
    }
    @Test
    public void has_no_permission(){
        assertFalse(new RoleDescription("", Arrays.asList("user.create"))
                .hasSomePermission(new String[]{"user.new"}));
    }
}