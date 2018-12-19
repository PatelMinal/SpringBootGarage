package com.minal.springboot.database.hello.mySpringBootDatabaseGarage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.minal.springboot.database.hello.mySpringBootDatabaseGarage.model.*;

@Repository
public interface mySpringBootGarageRepository extends JpaRepository<mySpringBootGarageDataModel,Long> {

}


