package pl.coderslab.conf;

import javax.persistence.EntityManagerFactory;
import javax.validation.Validator;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages= "pl.coderslab")
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "pl.coderslab")
public class AppConfiguration extends WebMvcConfigurerAdapter{

	
	@Bean
	public Validator validator() {
	    return new LocalValidatorFactoryBean();
	}

	
	@Bean
	public LocalEntityManagerFactoryBean entityManagerFactory() {
	    LocalEntityManagerFactoryBean emfb = new LocalEntityManagerFactoryBean();
	    emfb.setPersistenceUnitName("twitterPersistenceUnit");
	    return emfb; }
	@Bean
	public JpaTransactionManager transactionManager(EntityManagerFactory emf) {
	    JpaTransactionManager tm = new JpaTransactionManager(emf);
	    return tm; }
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
		
	}

}
