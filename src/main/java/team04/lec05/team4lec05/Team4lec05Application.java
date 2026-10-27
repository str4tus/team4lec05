package team04.lec05.team4lec05;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class Team4lec05Application {

  public static void main(String[] args) {
    SpringApplication.run(Team4lec05Application.class, args);
  }

}
