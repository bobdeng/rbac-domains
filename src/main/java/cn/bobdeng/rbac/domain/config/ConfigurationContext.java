package cn.bobdeng.rbac.domain.config;


import java.util.List;
import java.util.Optional;

public interface ConfigurationContext {
    interface Configurer {
        List<Parameter> listParameters();

        void saveParameters(List<Parameter> parameters);

        Optional<Parameter> getParameterByName(String name);
    }

    Configurer configurer();
}
