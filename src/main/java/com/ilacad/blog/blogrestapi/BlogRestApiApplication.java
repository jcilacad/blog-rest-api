package com.ilacad.blog.blogrestapi;

import com.ilacad.blog.blogrestapi.entity.Role;
import com.ilacad.blog.blogrestapi.repository.RoleRepository;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "Blog App Rest API",
				description = "Blog App Rest API Documentation",
				version = "v1.0",
				contact = @Contact(
						name = "John Christopher Ilacad",
						email = "johnchristopherilacad27@gmail.com"
				),
				license = @License(
						name = "Apache 2.0"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "Blog App Rest Api Documentation",
				url = "https://github.com/jcilacad/blog-rest-api"
		)
)
public class BlogRestApiApplication implements CommandLineRunner {

	private RoleRepository roleRepository;

	public BlogRestApiApplication(RoleRepository roleRepository) {
		this.roleRepository = roleRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(BlogRestApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Role admin = new Role();
		admin.setName("ROLE_ADMIN");
		roleRepository.save(admin);

		Role user = new Role();
		user.setName("ROLE_USER");
		roleRepository.save(user);

	}
}
