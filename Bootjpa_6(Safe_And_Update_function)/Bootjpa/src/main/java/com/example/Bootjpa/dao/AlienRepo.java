package com.example.Bootjpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
// import org.springframework.data.repository.CrudRepository;
import com.example.Bootjpa.model.Alien;

// public interface AlienRepo extends CrudRepository<Alien,Integer>{
public interface AlienRepo extends JpaRepository<Alien,Integer>{
    Alien findByTech(String tech);
    List<Alien> findByAidGreaterThan(int aid);

    @Query("from Alien where tech=?1 order by aname")
    List<Alien> findByTechSorted(String tech);
}
