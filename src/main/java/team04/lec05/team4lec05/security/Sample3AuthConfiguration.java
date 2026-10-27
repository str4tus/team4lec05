package team04.lec05.team4lec05.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class Sample3AuthConfiguration {

  /**
   * 認証処理に関する設定（誰がどのようなロールでログインできるか）
   *
   * @return
   */
  @Bean
  public InMemoryUserDetailsManager userDetailsService() {

    // ユーザ名，パスワード，ロールを指定してbuildする
    // このときパスワードはBCryptでハッシュ化されているため，{bcrypt}とつける
    // ハッシュ化せずに平文でパスワードを指定する場合は{noop}をつける

    // customer1 p@ss
    UserDetails customer1 = User.withUsername("customer1")
        .password("{bcrypt}$2y$05$AMTOXjUIlz3zhV/r1bzwJeXAUfrCK.yzHGKY7CkNfv2/9kBHZvDia")
        .roles("CUSTOMER")
        .build();
    // customer2 p@ss
    UserDetails customer2 = User.withUsername("customer2")
        .password("{bcrypt}$2y$05$sQiguGDfev/SRtHtb21pzur4My9knTZ85RUyYpRWczovz/jtm8rmC")
        .roles("CUSTOMER")
        .build();
    // seller p@ss
    UserDetails seller = User.withUsername("seller")
        .password("{bcrypt}$2y$05$ge7Mp9b9PcTLVs0VsQv2keSqt7t2FhUbsyLN.EiYn/qEiWuzrxI3i")
        .roles("SELLER")
        .build();

    // 生成したユーザをImMemoryUserDetailsManagerに渡す（いくつでも良い）
    return new InMemoryUserDetailsManager(customer1, customer2, seller);
  }

}
