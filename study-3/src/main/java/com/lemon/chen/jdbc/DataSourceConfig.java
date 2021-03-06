package com.lemon.chen.jdbc;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * Created by chenhualong on 2016/12/3.
 *
 * 如果项目直接采用的jdbcTemplete，则直接可以注入
 */

//@Configuration
public class DataSourceConfig {


    @Bean(name = "masterDataSource")
    @Qualifier("masterDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.master")
    public DataSource primaryDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "slaveDataSource")
    @Qualifier("slaveDataSource")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.slave")
    public DataSource secondaryDataSource() {
        return DataSourceBuilder.create().build();
    }


    /**
     * 定义不同的template来进行数据库操作
     *
     * @param dataSource
     * @return
     */
    @Bean(name = "masterJdbcTemplate")
    public JdbcTemplate primaryJdbcTemplate(
            @Qualifier("masterDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean(name = "slaveJdbcTemplate")
    public JdbcTemplate secondaryJdbcTemplate(
            @Qualifier("slaveDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}
