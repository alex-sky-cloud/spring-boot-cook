package com.cook.api.lib.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PropertySourceFactory;

import java.util.Objects;
import java.util.Optional;
import java.util.Properties;

import static org.springframework.beans.factory.config.YamlProcessor.MatchStatus.*;

@Slf4j
public class YamlPropertySourceFactory implements PropertySourceFactory {

    /**
     * Обработка пользовательского *-application.yml.
     *
     * <b>assert activeProfile !=null</b>
     * Если не удалось найти активный профиль, будет выброшен{@link  java.lang.AssertionError}
     * c указанием ошибки
     *
     * @param name
     * @param encodedResource
     * @return
     */
    @Override
    public PropertySource<?> createPropertySource(String name, EncodedResource encodedResource) {

        /*Работаем с активным профилем системы.*/
        String profilesActive = "SPRING_PROFILES_ACTIVE";
        String environmentVarProfile = System.getenv(profilesActive);
        String propertyProfile = System.getProperty("spring.profiles.active");

        String activeProfile = Optional
                .ofNullable(environmentVarProfile)
                .orElse(propertyProfile);

        log.info("Form-Api-Client active profile: " + activeProfile);

        /*Если не удалось найти активный профиль, будет выброшен{@link  java.lang.AssertionError}
         * c указанием ошибки */
        assert activeProfile != null;

        YamlPropertiesFactoryBean yamlFactory = new YamlPropertiesFactoryBean();

        /*В YAML документы разделяются '----------'.
        Таким образом, производим сопоставление. Значений указанных в свойстве spring.profiles,
        с профилем, который сейчас выбран в качестве active, так данные под этим профилем и будут
        использоваться*/
        yamlFactory.setDocumentMatchers(properties -> {

            String profileProperty = properties.getProperty("spring.profiles");

            if (profileProperty.isEmpty()) {
                return ABSTAIN;
            }

            if(profileProperty.contains(activeProfile)){
                return FOUND;
            }

            return  NOT_FOUND;
        });

        /*Теперь полученные значения читаем, декодируем символы в соответствующу кодировку(та что используется
        * в приложении по умолчанию (в основном UTF-8)). Исходный документ также должен быть в UTF-8*/
        yamlFactory.setResources(encodedResource.getResource());

        Properties properties = yamlFactory.getObject();
        assert properties != null;

        /*Теперь получаем имя файла и ранее составленный контейнер Properties, с данными
        * прочитанными из *-application.yml и создаем объект, который будет использоваться Spring application context.
        * Этот объект, нужен для наполнения данными beans, которые используют значения из *-application.yml */
        String filename = encodedResource.getResource().getFilename();
        String fileNameNotNull = Objects.requireNonNull(filename);

        return new PropertiesPropertySource(fileNameNotNull, properties);
    }
}
