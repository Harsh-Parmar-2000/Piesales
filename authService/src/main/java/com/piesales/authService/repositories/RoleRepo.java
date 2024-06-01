package com.piesales.authService.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.piesales.authService.entities.Role;

public interface RoleRepo  extends JpaRepository<Role, Integer>{

}