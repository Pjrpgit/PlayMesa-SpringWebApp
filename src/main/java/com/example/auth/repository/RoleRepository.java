package com.example.auth.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.modelo.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
	
	Role findByName(String name);
}
