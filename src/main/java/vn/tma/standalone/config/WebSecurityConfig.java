package vn.tma.standalone.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import vn.tma.standalone.security.CustomSuccessHandler;
import vn.tma.standalone.service.impl.CustomUserDetailsService;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private CustomUserDetailsService userDetailsService;

    private CustomSuccessHandler customSuccessHandler;

    public WebSecurityConfig(CustomUserDetailsService userDetailsService,
                             CustomSuccessHandler customSuccessHandler){
        this.userDetailsService = userDetailsService;
        this.customSuccessHandler = customSuccessHandler;
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.
                csrf().disable()
                .authorizeRequests()
                .antMatchers("/", "index", "/css/*", "/js/*").permitAll()
                .antMatchers("/admin/home").hasAuthority("ADMIN")
                .antMatchers("/home").hasAnyAuthority("USER","ADMIN")
                .and()
                .formLogin()
                    .loginProcessingUrl("/j_spring_security_check")
                    .loginPage("/login")
                    .successHandler(customSuccessHandler)
                    .failureUrl("/login?incorrectAccount")
                    .usernameParameter("j_username")
                    .passwordParameter("j_password")
                .and()
                .logout()
                    .logoutUrl("/logout")
                    .logoutRequestMatcher(new AntPathRequestMatcher("/logout", "GET"))
                    .clearAuthentication(true)
                    .invalidateHttpSession(true)
                    .deleteCookies("JSESSIONID")
                    .logoutSuccessUrl("/login");

    }

}
