package jp.ac.ccmc._2x.kimatsu2021;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
  
  @Autowired
  private AccountService service;

  @Override
  public void configure(WebSecurity web) throws Exception {
    web.ignoring().antMatchers(
      "/js/**", "/css/**", "/img/**", "/webjars/**", "/", "index");
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests()
    .antMatchers("/login").permitAll()
    .anyRequest().authenticated()
    .and()
    .formLogin()
    .loginPage("/login").permitAll()
    .and()
    .logout().logoutUrl("/logout")
    .logoutSuccessUrl("/")
    .invalidateHttpSession(true)
    .deleteCookies("JSESSIONID");
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    // ユーザ名'user', パスワード'user',ロール'USER'のユーザを追加
    auth.inMemoryAuthentication()
    .withUser("user").password(passwordEncorder().encode("password")).roles("USER");
  }

  @Bean
  public PasswordEncoder passwordEncorder() {
    return new BCryptPasswordEncoder();
  }
}
