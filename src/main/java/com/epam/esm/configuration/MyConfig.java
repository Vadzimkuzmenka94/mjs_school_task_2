package com.epam.esm.configuration;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mchange.v2.c3p0.DriverManagerDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import javax.sql.DataSource;


@Configuration
@ComponentScan(basePackages = "com.epam.esm")
@EnableWebMvc

public class MyConfig {

  @Bean
  public DataSource dataSource () {
      DriverManagerDataSource dataSource = new DriverManagerDataSource();
      dataSource.setDriverClass("org.postgresql.Driver");
      dataSource.setJdbcUrl("jdbc:postgresql://localhost:5432/postgres");
      dataSource.setUser("postgres");
      dataSource.setPassword("admin");
      return dataSource;
  }

  @Bean
    public JdbcTemplate jdbcTemplate () {
      return new JdbcTemplate(dataSource());
  }

/*
    @Bean
    public DataSource dataSource() {
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        try {
            comboPooledDataSource.setDriverClass("org.postgresql.Driver");
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        comboPooledDataSource.setJdbcUrl("jdbc:postgresql://localhost:5432/postgres");
        comboPooledDataSource.setUser("postgres");
        comboPooledDataSource.setPassword("admin");
        return comboPooledDataSource;
    }
*/

/*    @Bean
    public LocalSessionFactoryBean sessionFactoryBean() {
        LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource());
        sessionFactoryBean.setPackagesToScan("com.epam.esm.entity");
        Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgresqlDialect");
        hibernateProperties.setProperty("hibernate.show_sql", "true");

        sessionFactoryBean.setHibernateProperties(hibernateProperties);
        return sessionFactoryBean;
    }*/
}