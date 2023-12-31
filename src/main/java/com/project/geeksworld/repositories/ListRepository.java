package com.project.geeksworld.repositories;

import com.project.geeksworld.models.ListEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListRepository extends JpaRepository<ListEntity, Long> {

}