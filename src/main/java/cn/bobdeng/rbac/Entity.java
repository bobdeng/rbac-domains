package cn.bobdeng.rbac;

public interface Entity<T, Description> {
    T identity();

    Description description();
}
