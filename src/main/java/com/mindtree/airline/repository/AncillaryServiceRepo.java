package com.mindtree.airline.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.airline.entity.AncillaryService;
@Repository
public interface AncillaryServiceRepo extends JpaRepository<AncillaryService, Integer> {

}
