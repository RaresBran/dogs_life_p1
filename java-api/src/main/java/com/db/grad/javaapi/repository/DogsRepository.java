package com.db.grad.javaapi.repository;

import com.db.grad.javaapi.model.Dog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DogsRepository extends JpaRepository<Dog, Long>
{
    public Optional<Dog> findById(long uniqueId);
    @Query(nativeQuery = true, value = "select * from dogs where name = :name")
    List<Dog> findByName(Dog name);
}