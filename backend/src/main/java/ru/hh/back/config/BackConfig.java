package ru.hh.back.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;
//import ru.hh.back.entity.CompanyEntity;
//import ru.hh.back.entity.NegotiationEntity;
//import ru.hh.back.entity.ResumeEntity;
//import ru.hh.back.entity.UserEntity;
//import ru.hh.back.entity.VacancyEntity;
import ru.hh.nab.common.properties.FileSettings;
import ru.hh.nab.datasource.DataSourceFactory;
import ru.hh.nab.hibernate.MappingConfig;
import ru.hh.nab.hibernate.NabHibernateCommonConfig;
import ru.hh.nab.hibernate.NabHibernateProdConfig;
import ru.hh.nab.starter.NabCommonConfig;
import ru.hh.nab.starter.NabProdConfig;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement(proxyTargetClass = true)
@Import({
        NabProdConfig.class,
        NabHibernateProdConfig.class,
        NabCommonConfig.class,
        NabHibernateCommonConfig.class
        })
public class BackConfig {
        @Bean
        public MappingConfig mappingConfig() {
                //return new MappingConfig(CompanyEntity.class, NegotiationEntity.class, ResumeEntity.class, UserEntity.class, VacancyEntity.class);
                var mappingConfig = new MappingConfig();
                mappingConfig.addPackagesToScan("ru.hh.back.entity");
                return mappingConfig;
        }

        @Bean
        DataSource dataSource(DataSourceFactory dataSourceFactory, FileSettings settings) {
                return dataSourceFactory.create("postgres", false, settings);
        }
}
