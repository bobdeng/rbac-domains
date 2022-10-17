package cn.bobdeng.rbac.domain.config;

import java.util.Optional;
import java.util.stream.Stream;

public interface ParameterRepository {
    void save(Parameter parameter);

    Stream<Parameter> list();

    Optional<Parameter> findByName(String name);
}
