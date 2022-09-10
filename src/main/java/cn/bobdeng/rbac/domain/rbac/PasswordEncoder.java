package cn.bobdeng.rbac.domain.rbac;

public interface PasswordEncoder {
    String encode(String rawPassword);
    boolean matches(String rawPassword,String encodedPassword);
}
