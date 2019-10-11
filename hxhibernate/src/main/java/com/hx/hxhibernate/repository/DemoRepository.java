package com.hx.hxhibernate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hx.hxhibernate.entity.DemoEntity;
 
 
@Repository
public interface DemoRepository extends JpaRepository<DemoEntity, Integer>{
    
    public DemoEntity findById(String id);
    
    public DemoEntity save(DemoEntity user);
    
    @Query(value = "SELECT u FROM DemoEntity u WHERE name=:name")
    public DemoEntity findName(@Param("name") String name);
 
}
