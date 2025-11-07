//package com.TaskManagement1.Security;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//public class SecurityConfiguration {
//	
//	@Autowired
//	private JWTUtil jwtUtil;
//	
//	@Bean
//	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//		
//		http.csrf().disable().authorizeHttpRequests(auth -> auth
//				.requestMatchers(" ")
//				.authenticated().anyRequest().permitAll());
//		return http.build();
//	}
//	
//
//}

package com.TaskManagement1.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http
//            .csrf(csrf -> csrf.disable()) // disable CSRF for testing
//            .authorizeHttpRequests(auth -> auth
//                .requestMatchers("/api/userAuthentication/**").permitAll() // allow register/login/welcome
//                .anyRequest().authenticated() // all other APIs need auth
//            );
//
//        return http.build();
//    }
    
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) // disable CSRF for testing
            .authorizeHttpRequests(auth -> auth
                // allow user authentication endpoints
                .requestMatchers("/api/userAuthentication/**").permitAll()
                // allow all Task endpoints for testing
                .requestMatchers("/api/tasks/**").permitAll()
                //UserProfile
                .requestMatchers("/api/userProfile/**").permitAll()
                //Issue
                .requestMatchers("/api/issues/**").permitAll()
                // all other APIs require authentication
                .anyRequest().authenticated()
            );

        return http.build();
    }
}




