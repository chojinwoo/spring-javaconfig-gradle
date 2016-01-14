package com.spring.javaconfig.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.dialect.Oracle12cDialect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.instrument.classloading.InstrumentationLoadTimeWeaver;
import org.springframework.orm.hibernate5.HibernateExceptionTranslator;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.naming.NamingException;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by bangae1 on 2016-01-11.
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = {"com.spring.javaconfig.wa.**.repository"})
@PropertySource(value = { "classpath:application.properties" })
public class DataSourceConfig {

    @Autowired
    Environment env;

    @Bean
    public DataSource dataSource() throws NamingException {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl(env.getProperty("jdbc.log4jdbc.url"));
        dataSource.setDriverClassName(env.getProperty("jdbc.log4jdbc.driver"));
        dataSource.setUsername(env.getProperty("jdbc.username"));
        dataSource.setPassword(env.getProperty("jdbc.password"));
        dataSource.setMinIdle(10);
        dataSource.setMaxActive(100);
        dataSource.setMaxWait(10000);
        dataSource.setInitialSize(10);
//        dataSource.setValidationQuery("select 1 from dual");
        return dataSource;
    }

    @Bean
    public PlatformTransactionManager transactionManager()
    {
        EntityManagerFactory factory = entityManagerFactory().getObject();
        return new JpaTransactionManager(factory);
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory()
    {
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setGenerateDdl(Boolean.TRUE);
        vendorAdapter.setShowSql(Boolean.TRUE);

        try {
            factory.setDataSource(dataSource());
        } catch (NamingException e) {
            e.printStackTrace();
        }
        factory.setJpaVendorAdapter(vendorAdapter);
        factory.setPackagesToScan("com.spring.javaconfig.wa.users.entity");

        Properties jpaProperties = new Properties();
        jpaProperties.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
        jpaProperties.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
        factory.setJpaProperties(jpaProperties);
        factory.afterPropertiesSet();
        factory.setLoadTimeWeaver(new InstrumentationLoadTimeWeaver());
        return factory;
    }

    @Bean
    public HibernateExceptionTranslator hibernateExceptionTranslator()
    {
        return new HibernateExceptionTranslator();
    }
}
