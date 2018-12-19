package integration;


import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import com.minal.springboot.database.hello.mySpringBootDatabaseGarage.MySpringBootDatabaseAppGarageApplication;
import com.minal.springboot.database.hello.mySpringBootDatabaseGarage.model.mySpringBootGarageDataModel;
import com.minal.springboot.database.hello.mySpringBootDatabaseGarage.repository.mySpringBootGarageRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {MySpringBootDatabaseAppGarageApplication.class})
@AutoConfigureMockMvc



public class IntegrationTest {
	
@Autowired
private MockMvc mvc;

@Autowired
private mySpringBootGarageRepository repository;
			
@Before 
public void clearDB() {
	repository.deleteAll();
	//clear repository - helps stop tests from interacting and leaves us a clean test environment
}			


@Test

public void findingAndRetrivevingVehicleFromDatabase()
		throws Exception { 
			repository.save(new mySpringBootGarageDataModel("Toyata","Red", 224));
			mvc.perform(get("/api/vehicle")
			 .contentType(MediaType.APPLICATION_JSON))
		     .andExpect(status().isOk())
		     .andExpect(content()
		     .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
	         .andExpect(jsonPath("$[0].type", is("Toyata")));



	}


@Test
public void addAVehicleToDatabaseTest() throws Exception {
	mvc.perform(MockMvcRequestBuilders.post("/api/vehicle").contentType(MediaType.APPLICATION_JSON)
			.content("{\"type\" : \"Ford\",\"colour\" : \"Blue\", \"model\": 840}"))
	.andExpect(status().isOk()).andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
			.andExpect(jsonPath("$.type", is("Ford")));
}


@Test
public void removeAVehicleFromDatabaseTest() throws Exception {
	mySpringBootGarageDataModel Ford = new mySpringBootGarageDataModel("Ford", "Blue", 840);
	repository.save(Ford);
	mvc.perform(MockMvcRequestBuilders.delete("/api/vehicle/"+ Ford.getId())).andExpect(status().isOk());
	
}


//@Test
//public void updateAVehicleFromDatabaseTest() throws Exception {
	//mySpringBootGarageDataModel Ford = new mySpringBootGarageDataModel("Ford", "Blue", 840);
	//repository.save(Ford);
	//mvc.perform(MockMvcRequestBuilders.delete("/api/vehicle/"+ Ford.getId())).andExpect(status().isOk());


}




	

