

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import model.Course;
import model.Student;

@Configuration
public class appConfig {

    @Bean
    public Course course() {
        return new Course("Java Development", 8);
    }

    @Bean
    public Student student() {
        return new Student("Harinder Singh", course());
    }
}
