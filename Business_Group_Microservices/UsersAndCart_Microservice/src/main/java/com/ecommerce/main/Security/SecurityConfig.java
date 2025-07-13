package com.ecommerce.main.Security;

import java.beans.Customizer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

//import org.springframework.security.web.RestAuthenticationEntryPoint;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	public static final Logger log = LogManager.getLogger();

	private RestAuthenticationEntryPoint authenticationEntryPoint ;
	
	@Autowired
	  public void BasicAuthSecurity(RestAuthenticationEntryPoint authenticationEntryPoint) {
	    this.authenticationEntryPoint = authenticationEntryPoint;
	  }
	
	/*
	 * @Autowired private RestAuthenticationEntryPoint authenticationEntryPoint;
	 */

	/*
	 * @Override protected void configure(HttpSecurity http) throws Exception {
	 * http.csrf().disable(); }
	 */

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

		log.error("Entered Security filter!!" + System.currentTimeMillis());

		/*
		 * return http.authorizeHttpRequests(request -> request.requestMatchers( new
		 * AntPathRequestMatcher("/user**")) .authenticated()).build() ;
		 */
		http.csrf().disable();

		http.sessionManagement(session -> session
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            ).authorizeRequests().antMatchers("/public/**").permitAll().anyRequest().authenticated().and().httpBasic()
				.authenticationEntryPoint(authenticationEntryPoint);
		return http.build();
	}

}
