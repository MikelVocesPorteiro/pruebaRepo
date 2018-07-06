package com.ejemplos.spring.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.ejemplos.spring.model.User;

@Configuration
@ComponentScan("com.ejemplos.spring")
@EnableTransactionManagement

    

	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		System.out.println("class = ApplicationContextConfig  --  method = addResourceHandlers -- inicio");
	    registry.addResourceHandler("/static/**").addResourceLocations("/static/");
		///registry.addResourceHandler("/css/**").addResourceLocations("/static/css/");	 
		System.out.println("class = ApplicationContextConfig  --  method = addResourceHandlers -- fin");   
	}
     
    
    @Bean(name = "dataSource")
    public DataSource getDataSource() {
    	System.out.println("class = ApplicationContextConfig  -- bean = dataSource --  method = getDataSource -- inicio");
    	BasicDataSource dataSource = new BasicDataSource();
    	dataSource.setDriverClassName("com.mysql.jdbc.Driver");
    	dataSource.setUrl("jdbc:mysql://10.90.36.39/usersdb");
    	dataSource.setUsername("grupo3");
    	dataSource.setPassword("1234");
    	System.out.println("class = ApplicationContextConfig  -- bean = dataSource --  method = getDataSource -- fin");
    	
    	return dataSource;
    }
    
    
    private Properties getHibernateProperties() {
    	//carga propiedades al objeto conexion
    	System.out.println("class = ApplicationContextConfig  --  method = getHibernateProperties -- inicio");
    	Properties properties = new Properties();
    	properties.put("hibernate.show_sql", "true");
    	properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
    	System.out.println("class = ApplicationContextConfig  --  method = getHibernateProperties -- fin");
    	return properties;
    }
    
    @Autowired
    @Bean(name = "sessionFactory")
    public SessionFactory getSessionFactory(DataSource dataSource) {
    	System.out.println("class = ApplicationContextConfig  -- bean = sessionFactory --  method = getSessionFactory -- inicio");
    	LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
    	sessionBuilder.addProperties(getHibernateProperties());
    	//mapear clase user que es la de las tablas, si tengo mas de una tabla tengo que hacer mas clases y lineas de mapeo
    	sessionBuilder.addAnnotatedClasses(User.class);
    	
    	System.out.println("class = ApplicationContextConfig  -- bean = sessionFactory --  method = getSessionFactory -- fin");
    	return sessionBuilder.buildSessionFactory();
    }
    
	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(
			SessionFactory sessionFactory) {
    	System.out.println("class = ApplicationContextConfig  -- bean = transactionManager --  method = getTransactionManager -- inicio");
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(
				sessionFactory);
    	System.out.println("class = ApplicationContextConfig  -- bean = transactionManager --  method = getSessionFactory -- fin");

		return transactionManager;
	}
    

}
