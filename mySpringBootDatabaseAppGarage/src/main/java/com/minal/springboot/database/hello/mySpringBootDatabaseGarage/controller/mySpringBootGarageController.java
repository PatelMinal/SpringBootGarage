package com.minal.springboot.database.hello.mySpringBootDatabaseGarage.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.minal.springboot.database.hello.mySpringBootDatabaseGarage.repository.mySpringBootGarageRepository;
import com.minal.springboot.database.hello.mySpringBootDatabaseGarage.exception.ResourceNotFoundException;
import com.minal.springboot.database.hello.mySpringBootDatabaseGarage.model.mySpringBootGarageDataModel;
//import com.minal.springboot.database.hello.mySpringBootDatabaseGarage.repository.*;


@RestController
@RequestMapping("/api")
public class mySpringBootGarageController {
	
	@Autowired
	mySpringBootGarageRepository myRepository;
	
	//Method to create a vehicle
			@PostMapping("/vehicle")
			public mySpringBootGarageDataModel createVehicle(@Valid @RequestBody mySpringBootGarageDataModel mSDM) {
				return myRepository.save(mSDM);
			}

		//Method to get a vehicle
			@GetMapping("vehicle/{id}") 
			public void getvehiclebyID(@PathVariable(value = "id")Long vehicleID) {
				mySpringBootGarageDataModel mSDM = myRepository.findById(vehicleID).orElseThrow(() -> new ResourceNotFoundException("Vehicle", "id" ,vehicleID));
}

		//Method to get all vehicles
			@GetMapping("/vehicle")
			public List<mySpringBootGarageDataModel> getAllVehicle(){
				return myRepository.findAll();
			}

		//Method to update a vehicle
			@PutMapping("/vehicle/{id}")
			public mySpringBootGarageDataModel updateVehicle(@PathVariable(value = "id")long vehicleID,
					@Valid @RequestBody mySpringBootGarageDataModel vehicleDetails) {
			
			mySpringBootGarageDataModel mSDM = myRepository.findById(vehicleID).orElseThrow(() -> new ResourceNotFoundException("Vehicle", "id" ,vehicleID));
			
			mSDM.setType(vehicleDetails.getType());
			mSDM.setColour(vehicleDetails.getColour());
			mSDM.setModel(vehicleDetails.getModel());
			
			mySpringBootGarageDataModel updateData = myRepository.save(mSDM);
			return updateData;
			}

			
		//Method to remove a vehicle
			@DeleteMapping("/vehicle/{id}")
			public ResponseEntity<?> deletePerson(@PathVariable(value = "id")Long vehicleID){
				mySpringBootGarageDataModel mSDM = myRepository.findById(vehicleID).orElseThrow(() -> new ResourceNotFoundException("Vehicle", "id" ,vehicleID));
				
				myRepository.delete(mSDM);
				return ResponseEntity.ok().build();
				
			}
	}
		



