package com.cursos.springboot.jpa.springbootjpa;

import java.util.List;
import java.util.Optional;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.cursos.springboot.jpa.springbootjpa.entity.User;
import com.cursos.springboot.jpa.springbootjpa.service.UserRepository;

@Component
public class UserRepositoryCommandLineRunner implements CommandLineRunner{

	@Autowired 
	private UserRepository userDaoService;
	private static final org.jboss.logging.Logger log = LoggerFactory.logger(UserRepositoryCommandLineRunner.class);
	
	@Override
	public void run(String... args) throws Exception {
		User user = new User("Jack", "Admin");
		User insert = userDaoService.save(user);
		log.info("New User is created : " + insert);
		
		Optional<User> userWiothIdOne = userDaoService.findById(1L);
		log.info("User is retrieved : " + userWiothIdOne);
		
		List<User> users = userDaoService.findAll();
		log.info("All Users : " + users);
	}

}
