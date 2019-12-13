package servlet;

import DAO.CategorieDAO;
import DAO.ClientDAO;
import Entities.Client;
import DAO.DataSourceFactory;
import DAO.ProduitDAO;
import Entities.Categorie;
import Entities.Produit;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

/**
 *
 * @author Quentin
 */
public class AccueilServlet extends HttpServlet {
    
    private static DataSource dataSource = DataSourceFactory.getDataSource();
    public List<Produit> list_produit;
    public List<Categorie> list_categorie;
    ProduitDAO  daoproduit = new ProduitDAO(dataSource);
    CategorieDAO  daocategorie = new CategorieDAO(dataSource);
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{
        
        
//        if(!request.getParameter("name").isEmpty() && !request.getParameter("email").isEmpty()){
//            HttpSession session = request.getSession();
//            session.setAttribute("name", request.getParameter("name"));
//            session.setAttribute("email", request.getParameter("email"));
//        }
        try{
        list_produit = daoproduit.allProduit() ;//liste des produits
        list_categorie= daocategorie.allCategorie(); //liste des categories
        }catch(SQLException e){
            
        }

        request.setAttribute("list_produit", list_produit);
        request.setAttribute("list_categorie", list_categorie);
        
        this.getServletContext().getRequestDispatcher("/PageAccueil.jsp").forward(request, response);
    }
    
    protected void processPostRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{
        
        
//        if(!request.getParameter("name").isEmpty() && !request.getParameter("email").isEmpty()){
//            HttpSession session = request.getSession();
//            session.setAttribute("name", request.getParameter("name"));
//            session.setAttribute("email", request.getParameter("email"));
//        }

        String cate = request.getParameter("categ");
        System.out.println("____________________________________________________________________________________________________________________________________________________ "+ cate);
        
        if(cate=="0"){
            try{
                list_produit = daoproduit.allProduit(); //liste des produits
                list_categorie= daocategorie.allCategorie(); //liste des categories
            }catch(SQLException e){

            }
        }else{
            try{
                list_produit = daoproduit.getProduitByCategorie(Integer.parseInt(cate)) ;//liste des produits de la categorie
                list_categorie= daocategorie.allCategorie(); //liste des categories
            }catch(SQLException e){

            }
        }
        
        

        request.setAttribute("list_produit", list_produit);
        request.setAttribute("list_categorie", list_categorie);
        
        this.getServletContext().getRequestDispatcher("/PageAccueil.jsp").forward(request, response);
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processPostRequest(request, response);

    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
