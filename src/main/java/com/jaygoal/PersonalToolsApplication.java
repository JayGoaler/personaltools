package com.jaygoal;

import com.jaygoal.windows.MainWindow;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

/**
 * @author jaygoaler
 */
@SpringBootApplication
public class PersonalToolsApplication {

    public static void main(String[] args) {
        SpringApplicationBuilder builder = new SpringApplicationBuilder(PersonalToolsApplication.class);
        ApplicationContext context = builder.headless(false).run(args);
        MainWindow window = context.getBean(MainWindow.class);
        window.setVisible(true);
    }
}
