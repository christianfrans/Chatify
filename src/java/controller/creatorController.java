/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.List;
import model.Admin;
import model.ChatifyHibernateUtil;
import model.Creators;
import model.News;
import model.Stickers;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author user
 */
public class creatorController {
    public List<Creators> validateLogin(String username, String password)
    {
        List<Creators> creators = new ArrayList();
       
        Transaction trans=null;
        Session session=ChatifyHibernateUtil.getSessionFactory().openSession();
        try 
        {
            trans=session.beginTransaction();
            Query query=session.createQuery("from Creators where username= :username and password= :password");
            query.setString("username", username);
            query.setString("password", password);
            creators=query.list();
            
            trans.commit();
        }
        catch(Exception e)
        {
            
        }
        return creators;
    }
    
    public void inputStickers(Stickers stickers) {
        Transaction trans = null;
        Session session = ChatifyHibernateUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            session.save(stickers);
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public List<Creators> retrieveCreators()
    {
       
        List creators=new ArrayList();
        Transaction trans=null;
        Session session=ChatifyHibernateUtil.getSessionFactory().openSession();
        try
        {
            trans=session.beginTransaction();
            Query query=session.createQuery("from Creators");
            creators=query.list();
         
            trans.commit();
            
        }
        catch(Exception e)
        {

        }
        return creators;
    }
}
