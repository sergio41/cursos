package com.cursos.springboot.jpa.springbootjpa;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.cursos.springboot.jpa.springbootjpa.entity.User;
import com.cursos.springboot.jpa.springbootjpa.service.UserDAOService;

@Component
public class UserDaoServiceCommandLineRunner implements CommandLineRunner{

	@Autowired 
	private UserDAOService userDaoService;
	private static final org.jboss.logging.Logger log = LoggerFactory.logger(UserDaoServiceCommandLineRunner.class);
	
	@Override
	public void run(String... args) throws Exception {
		User user = new User("Jack", "Admin");
		/*long insert = */userDaoService.insert(user);
		log.info("New User is created : " + user);
	}

}
