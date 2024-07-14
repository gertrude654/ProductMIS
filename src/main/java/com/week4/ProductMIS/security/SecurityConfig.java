//package com.week4.ProductMIS.security;
//
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//
//@Configuration
//public class SecurityConfig {
//
//    //IDENTIFYING ROLES
//    @Bean
//    public InMemoryUserDetailsManager userDetailsManager(){
//
//        UserDetails john = User.builder()
//                .username("john")
//                .password("{noop}test123")
//                .roles("EMPLOYEE")
//                .build();
//
//        UserDetails mary = User.builder()
//                .username("mary")
//                .password("{noop}test123")
//                .roles("EMPLOYEE","MANAGER")
//                .build();
//
//        UserDetails admin = User.builder()
//                .username("admin")
//                .password("{noop}test123")
//                .roles("EMPLOYEE", "MANAGER","ADMIN")
//                .build();
//
//        return new InMemoryUserDetailsManager(john,mary,admin);
//
//    }
//    //RESTRICTING ACCESS TO ROLES
//    @Bean
//    public SecurityFilterChain filterChain (HttpSecurity http) throws Exception{
//        http.authorizeHttpRequests(configure ->
//                configure
//                        .requestMatchers(HttpMethod.GET,"/api/employees").hasRole("EMPLOYEE")
//                        .requestMatchers(HttpMethod.GET,"/api/employees/**").hasRole("EMPLOYEE")
//                        .requestMatchers(HttpMethod.POST,"/api/employees").hasRole("MANAGER")
//                        .requestMatchers(HttpMethod.PUT,"/api/employees").hasRole("MANAGER")
//                        .requestMatchers(HttpMethod.DELETE,"/api/employees/**").hasRole("ADMIN")
//        );
//
//        //use HTTP basic authentication
//        http.httpBasic(Customizer.withDefaults());
//
//        // disable CRSF , REST APIs that use PUT,POST, GET, DELETE
//        http.csrf(csrf -> csrf.disable());
//
//        return http.build();
//
//    }
//}
//
