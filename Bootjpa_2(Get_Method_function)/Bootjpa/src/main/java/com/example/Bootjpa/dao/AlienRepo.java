package com.example.Bootjpa.dao;
import org.springframework.data.repository.CrudRepository;
import com.example.Bootjpa.model.Alien;

  public interface AlienRepo extends CrudRepository<Alien,Integer>{
}
