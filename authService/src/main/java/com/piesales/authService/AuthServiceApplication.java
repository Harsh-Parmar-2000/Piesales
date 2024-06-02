package com.piesales.authService;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.client.RestTemplate;

import com.piesales.authService.config.AppConstants;
import com.piesales.authService.entities.Role;
import com.piesales.authService.entities.User;
import com.piesales.authService.repositories.RoleRepo;
import com.piesales.authService.repositories.UserRepo;

import org.springframework.boot.CommandLineRunner;
@EnableEurekaClient
@SpringBootApplication
public class AuthServiceApplication implements CommandLineRunner{
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private UserRepo userRepo;

	@Autowired
	private RoleRepo roleRepo;

	public static void main(String[] args) {
		SpringApplication.run(AuthServiceApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	@Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

	@Override
	public void run(String... args) throws Exception {
		try {

			Role role = new Role();
			role.setId(AppConstants.ADMIN_USER);
			role.setName("ROLE_ADMIN");

			Role role1 = new Role();
			role1.setId(AppConstants.NORMAL_USER);
			role1.setName("ROLE_NORMAL");

			List<Role> roles = Arrays.asList(role, role1);

			List<Role> result = this.roleRepo.saveAll(roles);
			
			result.forEach(r -> {
				System.out.println(r.getName());
			});

			Set<Role> addNormalRole = new HashSet<Role>();
			addNormalRole.add(role1);

			User normalUser = new User();
			normalUser.setId(1);
			normalUser.setEmail("user@piesales.com");
			normalUser.setAbout("I am an user"); ;
			normalUser.setPassword(passwordEncoder.encode("password"));
			normalUser.setName("User 1");
			normalUser.setRoles(addNormalRole);
			this.userRepo.save(normalUser);



			User normalUser2 = new User();
			normalUser2.setId(2);
			normalUser2.setEmail("user2@piesales.com");
			normalUser2.setAbout("I am an user"); ;
			normalUser2.setPassword(passwordEncoder.encode("password"));
			normalUser2.setName("User 2");
			normalUser2.setRoles(addNormalRole);
			this.userRepo.save(normalUser2);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
