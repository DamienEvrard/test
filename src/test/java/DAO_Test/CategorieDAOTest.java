package DAO_Test;

import DAO.CategorieDAO;
import DAO.DataSourceFactory;
import Entities.Categorie;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;

public class CategorieDAOTest {
	private CategorieDAO myDAO; // L'objet à tester
	private DataSource myDataSource; // La source de données à utiliser
	

	@Before
	public void setUp() throws SQLException {
		myDataSource = DataSourceFactory.getDataSource();
		myDAO = new CategorieDAO(myDataSource);
	}
	
        
	/**
	 * Test of allClient method, of class ClientDAO.
	 * @throws simplejdbc.SQLException
	 */
	@Test
	public void testNumberOfCategories() throws SQLException{
		List<Categorie> result = myDAO.allCategorie();
		assertEquals(8, result.size());
	}
        

	/***
	 * Test of getClient method, of class ClientDAO.
	 * @throws simplejdbc.SQLException
	 */
	@Test
	public void testgetcategorie() throws SQLException {
                //exist
		String cate = "Boissons";
		Categorie result = myDAO.getCategorie(cate);
		assertEquals(cate, result.getLibelle());
                //don't exist
                cate = "test";
                try{
                    result = myDAO.getCategorie(cate);
                    fail("//don't exist");
                }catch(Exception e){
                    
                }
	}
        
        
//
//	/**
//	 * Test of customersInState method, of class DAO.
//	 * @throws simplejdbc.DAOException
//	 */
//	@Test
//	public void testCustomersInState() throws DAOException {
//		String state = "CA";
//		List<CustomerEntity> result = myDAO.customersInState(state);
//		assertEquals(4, result.size());
//	}
//
//	/**
//	 * Test of deleteCustomer method, of class DAO.
//	 * @throws simplejdbc.DAOException
//	 */
//	@Test
//	public void testDeleteUnknownCustomer () throws DAOException {
//		int id = 999;
//		assertEquals(0, myDAO.deleteCustomer(id));
//	}
//
//	/**
//	 * Test of deleteCustomer method, of class DAO.
//	 * @throws simplejdbc.DAOException
//	 */
//	@Test @Ignore
//	public void testDeleteCustomerWithoutOrder () throws DAOException {
//		int id = 25; // Le client 25 n'a pas de bon de commande
//		assertEquals(1, myDAO.deleteCustomer(id));
//	}
//
//	/**
//	 * Test of deleteCustomer method, of class DAO.
//	 */
//	@Test
//	public void testDeleteCustomerWithOrder () {
//		int id = 1; // Le client 1 a des bons de commande
//		try {
//			myDAO.deleteCustomer(id); // Cette ligne doit lever une exception
//			fail(); // On ne doit pas passer par ici
//		} catch (DAOException e) {
//			// On doit passer par ici, violation d'intégrité référentielle
//		}
//	}
	
}
