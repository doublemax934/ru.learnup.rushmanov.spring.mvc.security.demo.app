package ru.learnup.rushmanov.spring.mvc.security.demo.app.configuration;


import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;



@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        UserBuilder userBuilder = User.withDefaultPasswordEncoder(); // стандартное шифрование паролей

        auth.inMemoryAuthentication() // при аутентификации будет сравнивать с данными из памяти программы
                .withUser (userBuilder.username("User"). password("User"). roles("USER"))
                .withUser (userBuilder.username("Admin"). password("Admin"). roles("USER", "ADMIN"));
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/registration").not().authenticated()
                .antMatchers("/").permitAll()
                .antMatchers("/viewAllTickets").permitAll()
                .antMatchers("/addNewPerformance").hasRole("ADMIN")
                .antMatchers("/updateInfo").hasRole("ADMIN")
                .antMatchers("/deletePerformance").hasRole("ADMIN")
                .antMatchers("/buyTicket").hasAnyRole("USER", "ADMIN")
                .antMatchers("/refundTicket").hasAnyRole("USER", "ADMIN")
                .and().formLogin();
    }
}
