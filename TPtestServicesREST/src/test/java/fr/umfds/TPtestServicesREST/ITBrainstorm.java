package fr.umfds.TPtestServicesREST;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;



public class ITBrainstorm {
	

		
		@Test
		public void brainstormTest() throws Exception {

			try {
			List<Brainstorm> test = new ArrayList<Brainstorm>();
			BrainstormResource database = new BrainstormResource();
			test = database.getBrainstorm();
			
			assertNotNull(test);
			
			System.out.println("Dans l'ordre : ");
			for(Brainstorm i : test) {
				System.out.println(i.nom);
			}
			
			}catch(Exception e) {
				e.printStackTrace();
			}
		
		}
		@SuppressWarnings("static-access")
		@Test
		public void DBTest() throws Exception {

			try {
				List<Brainstorm> test2 = new ArrayList<Brainstorm>();
				
				 BrainstormResource dbTest = Mockito.mock(BrainstormResource.class); 

				Mockito.when(dbTest.getBrainstorm()).thenReturn(test2);
				assertNotNull(test2);
				
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		

	}

