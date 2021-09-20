package com.ganesh;

import com.ganesh.models.Address;
import com.ganesh.models.Gender;
import com.ganesh.models.Student;
import com.ganesh.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
//@RequiredArgsConstructor
public class SpringMongoJpaDemoAppApplication {

//    private final StudentRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(SpringMongoJpaDemoAppApplication.class, args);

	}

	@Bean
	CommandLineRunner runner(StudentRepository repository, MongoTemplate mogTemplate){
		return  args -> {
			Address address = new Address("India", "Karnataka", "560012");
			String email = "ganesh@gmail.com";
			Student student = new Student(
				"Ganesh",
				"Kumar",
				    email,
					Gender.MALE,
                    address,
					List.of("Computer Science", "Math"),
					BigDecimal.TEN,
					LocalDateTime.now()
			);
		 // usingMongoTemplateAndQuery(repository, mogTemplate, email, student);

			/* Using Customs Query */
			repository.findStudentByEmail(email)
					.ifPresentOrElse(s -> {
						System.out.println(s+ " ==> already exists");
					}, () -> {
						System.out.println("Inserting student "+ student);
						repository.insert(student);
					});
		};
	}


	private void usingMongoTemplateAndQuery(StudentRepository repository, MongoTemplate mogTemplate, String email, Student student) {
		/* Ist way mongo Query */
		Query query = new Query();
		query.addCriteria(Criteria.where("email").is(email));
		List<Student> students = mogTemplate.find(query, Student.class);
		if(students.size() > 1){
			throw  new IllegalStateException("Found many students with email "+ email);
		}
		if(students.isEmpty()){
			System.out.println("Inserting student "+ student);
			repository.insert(student);
		}else {
			System.out.println(student + "==> already exists");
		}

		//repository.insert(student);
	}

}
