package cn.bobdeng.rbac.domain.config;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class ConfigurerImpl implements ConfigurationContext.Configurer {
    private ParameterRepository parameterRepository;

    public ConfigurerImpl(ParameterRepository parameterRepository) {
        this.parameterRepository = parameterRepository;
    }

    @Override
    public List<Parameter> listParameters() {
        return parameterRepository.list().collect(Collectors.toList());
    }

    @Override
    public void saveParameters(List<Parameter> parameters) {
        parameters.stream().map(Parameter::getDescription)
                .forEach(ParameterDescription::validate);
        Map<String, String> values = parameters.stream().collect(Collectors.toMap(Parameter::identity, parameter -> parameter.description().getValue()));
        parameterRepository.list()
                .filter(parameter -> parameter.isChanged(values))
                .forEach(parameter -> {
                    String key = parameter.identity();
                    parameterRepository.save(new Parameter(parameter.getId(), new ParameterDescription(values.get(key), key)));
                });
    }

    @Override
    public Optional<Parameter> getParameterByName(String name) {
        return parameterRepository.findByName(name);
    }

}
