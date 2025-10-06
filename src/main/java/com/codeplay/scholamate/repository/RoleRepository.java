package com.codeplay.scholamate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codeplay.scholamate.domain.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

}
