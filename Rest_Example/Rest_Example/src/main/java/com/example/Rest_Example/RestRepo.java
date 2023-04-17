package com.example.Rest_Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.example.Rest_Example.model.restExample;

@RepositoryRestResource(collectionResourceRel="restexamples",path="restexamples")
public interface RestRepo extends JpaRepository<restExample,Integer>{
    
}
