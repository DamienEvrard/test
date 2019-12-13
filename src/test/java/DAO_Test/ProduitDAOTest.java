/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO_Test;

import DAO.ProduitDAO;
import DAO.DataSourceFactory;
import Entities.Produit;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Flo
 */
public class ProduitDAOTest {
        private ProduitDAO myDAO;
        private DataSource myDataSource;
        
        
        @Before
        public void setUp() throws SQLException {
            myDataSource = DataSourceFactory.getDataSource();
            myDAO = new ProduitDAO(myDataSource);
        }
        /**
         * Test of allProduit methid, of class ProduitDAO
         * On verifie si on a bien la totalité des produits
         * @throws SQLException 
         */
        @Test
        public void testNumberOfProduct() throws SQLException{
            List<Produit> result = myDAO.allProduit();
            assertEquals(77, result.size());
        }
        
        @Test
        public void testgetproduitByName() throws SQLException {
            //exist
            String nomProduit = "Chai";
            Produit result = myDAO.getProduitByName(nomProduit);
            assertEquals(nomProduit, result.getNom());
            //dont exist
            nomProduit="test";
            result = myDAO.getProduitByName(nomProduit);
            assertEquals(null,result);
                
        }
        
        @Test
        public void testGetProduit()throws SQLException {
            //exist.
            int reference = 1;
            Produit result = myDAO.getProduit(reference);
            assertEquals(reference, result.getReference());
            //don't exist
            reference=100;
            result = myDAO.getProduit(reference);
            assertEquals(null, result);
        }
        
//        @Test
//        public void testajoutProduit()throws SQLException{
//            try{
//                myDAO.ajoutProduit("test", 666, 0, 1, "test", 0, 0, 0, 0, 0);
//            }catch(Exception e){
//                fail("ajout impossible");
//            }
//        }
//        
//        @Test
//        public void testspprProduit()throws SQLException{
//            try{
//                List<Produit> nba = myDAO.getProduitByCategorie(1);
//                myDAO.supprProduit(78);
//                List<Produit> nbp = myDAO.getProduitByCategorie(1);
//                assertEquals(nbp.size(), nba.size()-1);
//            }catch(Exception e){
//                fail("suppression impossible");
//            }
//        }
        
//        @Test
//        public void testupdateProduit()throws SQLException{
//            try{
//                myDAO.ajoutProduit("test", 78, 0, 1, "test", 0, 0, 0, 0, 0);
//                myDAO.updateProduit("testeu", 78, 0, 1, "test", 0, 0, 0, 0, 0);
//            }catch(Exception e){
//                fail("update impossible");
//            }
//        }
        
        @Test
        public void testgetproduitByCategorie() throws SQLException {
            //exist
            int cate = 1;
            List<Produit> result = myDAO.getProduitByCategorie(cate);
            assertEquals(12, result.size());
            
        }
        
        
}
