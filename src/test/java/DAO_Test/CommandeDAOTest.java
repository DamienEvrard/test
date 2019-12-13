
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO_Test;

import DAO.CommandeDAO;
import DAO.DataSourceFactory;
import Entities.Commande;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Flo
 */
public class CommandeDAOTest {
        private CommandeDAO myDAO; // L'objet à tester
	private DataSource myDataSource; // La source de données à utiliser
        
        @Before
	public void setUp() throws SQLException {
		myDataSource = DataSourceFactory.getDataSource();
		myDAO = new CommandeDAO(myDataSource);
	}
        
        
	/**
	 * Test of allCommande method, of class CommandeDAO.
	 * @throws simplejdbc.SQLException
	 */
	@Test
	public void testNumberOfCommand() throws SQLException{
		List<Commande> result = myDAO.allCommande();
		assertEquals(830, result.size());
	}
        
        /**
	 * Test of getCommande method, of class CommandeDAO.
	 * @throws simplejdbc.SQLException
	 */
	@Test
	public void testgetcommande() throws SQLException {
                //exist
		String commandeClient = "VINET";
		Commande result = myDAO.getCommande(commandeClient);
		assertEquals(commandeClient, result.getClient());
                //don't exist
                commandeClient = "test";
                result = myDAO.getCommande(commandeClient);
                assertEquals(null, result);
	}
        
        /**
	 * Test of NBCommandeParCateg method, of class CommandeDAO.
	 * @throws simplejdbc.SQLException
	 */
	@Test
	public void testNBCommandeParCateg() throws SQLException{
            String dateDeb="1994-01-01";
            String dateFin="1995-01-01";
            Map<String, Integer> attendu = new HashMap<String, Integer>();
            
            attendu.put("Boissons", 56);
            attendu.put("Condiments", 28);
            attendu.put("Desserts", 47);
            attendu.put("Poissons et fruits de mer", 38);
            attendu.put("Produit laitiers", 46);
            attendu.put("Produit secs", 16);
            attendu.put("Pâtes et céréales", 22);
            attendu.put("Viandes", 27);
            
            Map<String, Integer> result = myDAO.getNBCommandeParCateg(dateDeb, dateFin);
            
            assertEquals(attendu, result);
	}
        
        /**
	 * Test of NBCommandeParPays method, of class CommandeDAO.
	 * @throws simplejdbc.SQLException
	 */
	@Test
	public void testNBCommandeParPays() throws SQLException{
            String dateDeb="1994-01-01";
            String dateFin="1995-01-01";
            Map<String, Integer> attendu = new HashMap<String, Integer>();
            
            attendu.put("Allemagne", 22);
            attendu.put("Autriche", 5);
            attendu.put("Belgique", 2);
            attendu.put("Brésil", 10);
            attendu.put("Canada", 2);
            attendu.put("Danemark", 2);
            attendu.put("Espagne", 6);
            attendu.put("Finlande", 4);
            attendu.put("France", 14);
            attendu.put("Irlande", 3);
            attendu.put("Italie", 3);
            attendu.put("Mexique", 9);
            attendu.put("Portugal", 3);
            attendu.put("Royaume-Uni", 7);
            attendu.put("Suisse", 2);
            attendu.put("Suède", 4);
            attendu.put("Venezuela",6);
            attendu.put("États-Unis",17);
            
            Map<String, Integer> result = myDAO.getNBCommandeParPays(dateDeb, dateFin);
            
            assertEquals(attendu, result);
	}
        
        
        /**
	 * Test of NBCommandeParClient method, of class CommandeDAO.
	 * @throws simplejdbc.SQLException
	 */
	@Test
	public void testNBCommandeParClient() throws SQLException{
            String dateDeb="1994-01-01";
            String dateFin="1995-01-01";
            Map<String, Integer> attendu = new HashMap<String, Integer>();
            
            attendu.put("Alejandra Camino", 3);
            attendu.put("Alexander Feuer", 1);
            attendu.put("Ana Trujillo", 1);
            attendu.put("Paula Wilson", 6);
            attendu.put("Yang Wang", 1);
            
            Map<String, Integer> result = myDAO.getNBCommandeParClient(dateDeb, dateFin);
            
            assertEquals(attendu.get("Alejandra Camino"), result.get("Alejandra Camino"));
            assertEquals(attendu.get("Alexander Feuer"), result.get("Alexander Feuer"));
            assertEquals(attendu.get("Ana Trujillo"), result.get("Ana Trujillo"));
            assertEquals(attendu.get("Paula Wilson"), result.get("Paula Wilson"));
            assertEquals(attendu.get("Yang Wang"), result.get("Yang Wang"));
	}
        
        
        /**
	 * Test of addCommande method, of class CommandeDAO.
	 * @throws simplejdbc.SQLException
	 */
//	@Test
//	public void testaddCommande() throws SQLException{
//            
//            int resultAv = myDAO.allCommande().size();
//            Commande com=new Commande(1, "VINET", "2019-11-12", "2019-11-13",66.6 , "test", "test", "test", "test", "test", "test", 0.0);
//            myDAO.addCommande(com);
//            
//            int resultAp = myDAO.allCommande().size();
//            
//            assertEquals(resultAv+1,resultAp);
//	}
        
        
        /**
	 * Test of NBCommandeParPays method, of class CommandeDAO.
	 * @throws simplejdbc.SQLException
	 */
	@Test
	public void testNBAllCommandeParPays() throws SQLException{
            Map<String, Integer> attendu = new HashMap<String, Integer>();
            
            attendu.put("ALFKI", 4);
            attendu.put("AROUT", 14);
            attendu.put("COMMI", 5);
            attendu.put("WARTH", 15);
            Map<String, Integer> result = myDAO.getNBAllCommandeParClient();
            
            assertEquals(attendu.get("ALFKI"), result.get("ALFKI"));
            assertEquals(attendu.get("AROUT"), result.get("AROUT"));
            assertEquals(attendu.get("COMMI"), result.get("COMMI"));
            assertEquals(attendu.get("WARTH"), result.get("WARTH"));
	}
        
}
