package com.tdev.crudmaven.repository;
import com.tdev.crudmaven.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;



public interface UserRepository extends JpaRepository<User,Long>{}