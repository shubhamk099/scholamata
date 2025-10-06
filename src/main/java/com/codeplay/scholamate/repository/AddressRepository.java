package com.codeplay.scholamate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codeplay.scholamate.domain.entity.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer>{
    
}
