package com.gnrsoft.springboot_test;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

/*
 * spring 启动类
 */
@EnableAutoConfiguration
@SpringBootApplication
@ComponentScan
@MapperScan("com.gnrsoft.springboot_test.mapper")
public class Application {

	/**
	 * 
	 * <B>方法名称：构建数据源</B><BR>
	 * <B>概要说明：</B><BR>
	 * 
	 * @return
	 */
	@Bean
	@ConfigurationProperties(prefix = "spring.datasoucre",locations="classpath:db.properties")
	public DataSource getDataSource() {
		return new org.apache.tomcat.jdbc.pool.DataSource();
	}

	/**
	 * 
	 * <B>方法名称：构建 MyBatis 入口类 SqlSessionFactory </B><BR>
	 * <B>概要说明：</B><BR>
	 * 
	 * @return
	 * @throws Exception
	 */
	@Bean
	public SqlSessionFactory sqlSessionFactoryBean() throws Exception {
		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
		factoryBean.setDataSource(getDataSource());
		PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		factoryBean.setMapperLocations(resolver.getResources("classpath:/mybatis/*.xml"));
		return factoryBean.getObject();
	}

	/**
	 * 
	 * <B>方法名称：事务管理器 </B><BR>
	 * <B>概要说明：</B><BR>
	 * 
	 * @return
	 */
	@Bean
	public PlatformTransactionManager transactionManager() {
		return new DataSourceTransactionManager(getDataSource());
	}

}
