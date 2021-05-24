package com.example.freefire.repository;

import com.example.freefire.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Integer> {
    Role getRoleByName(String name);
}
