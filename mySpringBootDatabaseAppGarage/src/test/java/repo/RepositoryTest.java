package repo;

import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import com.minal.springboot.database.hello.mySpringBootDatabaseGarage.MySpringBootDatabaseAppGarageApplication;
import com.minal.springboot.database.hello.mySpringBootDatabaseGarage.model.mySpringBootGarageDataModel;
import com.minal.springboot.database.hello.mySpringBootDatabaseGarage.repository.mySpringBootGarageRepository;


@RunWith(SpringRunner.class)
@ContextConfiguration(classes = MySpringBootDatabaseAppGarageApplication.class)
@DataJpaTest

public class RepositoryTest {
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private mySpringBootGarageRepository myRepo;
	
	
	@Test
	public void retrieveByIdTest() {
		mySpringBootGarageDataModel model1 = new mySpringBootGarageDataModel ("Toyata" , "Red" , 244);
		entityManager.persist(model1);
		entityManager.flush();
		assertTrue(myRepo.findById(model1.getId()).isPresent());
		
	}
	
}
