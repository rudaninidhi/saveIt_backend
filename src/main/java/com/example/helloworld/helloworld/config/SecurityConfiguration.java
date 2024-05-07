//package com.example.helloworld.helloworld.config;
////import com.example.helloworld.helloworld.filter.JwtFilter;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//
//import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserService;
//import org.springframework.security.web.DefaultSecurityFilterChain;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfiguration {
//
//
//    @Autowired
////    private JwtFilter jwtFilter;
//    @Bean
//    AuthenticationManager authenticationManager(
//            AuthenticationConfiguration authenticationConfiguration) throws Exception {
//        return authenticationConfiguration.getAuthenticationManager();
//    }
//
//    @Bean
//    DefaultSecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        return http
//                .authorizeHttpRequests(auth -> auth
//                        .requestMatchers("/").permitAll()
//                        .anyRequest().authenticated())
//                .oauth2Login(oauth2 -> oauth2
//                        .userInfoEndpoint(userInfo -> userInfo
//                                .oidcUserService(new OidcUserService())))
//                .formLogin(Customizer.withDefaults())
//                .build();
//    }
//
//
////    @Bean
////    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
////        return httpSecurity
////                .csrf(csrf->csrf.disable())
////                .authorizeRequests(auth->auth.requestMatchers("/authenticate").permitAll())
////                .authorizeRequests(auth->auth.anyRequest().authenticated())
////                .sessionManagement(sess->sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
////                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
////                .build();
////    }
//
//}
