package cn.lab.recruitsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class RecruitSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(RecruitSystemApplication.class, args);
    }

}
