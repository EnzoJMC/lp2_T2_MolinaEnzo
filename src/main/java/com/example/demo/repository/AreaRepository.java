package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.AreaEntity;

import jakarta.persistence.Entity;

@Entity
public interface AreaRepository extends JpaRepository<AreaEntity,Integer> {

}
