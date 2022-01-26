package ua.com.alevel.config;


import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserDetailsService userDetailsService;

    public WebSecurityConfig(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }


    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager customAuthenticationManager() throws Exception {
        return authenticationManager();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        String[] staticResources = {
                "/css/**",
                "/images/**",
                "/fonts/**",
                "/js/**",
                "/resources/**",
        };

        http
                .authorizeRequests()
                .antMatchers(staticResources).permitAll()
                .antMatchers("/movies/**", "/client/registration", "/open/dashboard/**", "/").permitAll()
//                .antMatchers("/doctor/**").access("hasRole('ROLE_DOCTOR')")
                .antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
                .antMatchers("/client/**").access("hasRole('ROLE_CLIENT')")
//                .antMatchers("/doctors/**", "/patients/**", "/departments/**").access("hasAnyRole('ROLE_ADMIN', 'ROLE_CLIENT','ROLE_DOCTOR')")
                .anyRequest().authenticated()
//                .and().formLogin().loginPage("/login").defaultSuccessUrl("/dashboard").permitAll()
                .and().formLogin().loginPage("/login").permitAll()
                .and().logout().logoutUrl("/logout").logoutSuccessUrl("/open/dashboard/");
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
    }
}