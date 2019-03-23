package com.cursos.springboot.jpa.springbootjpa.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cursos.springboot.jpa.springbootjpa.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
