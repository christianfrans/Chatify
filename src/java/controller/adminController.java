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
import model.News;
import model.Users;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author user
 */
public class adminController {
    public List<Admin> validateLogin(String username, String password)
    {
        List<Admin> admin = new ArrayList();
       
        Transaction trans=null;
        Session session=ChatifyHibernateUtil.getSessionFactory().openSession();
        try 
        {
            trans=session.beginTransaction();
            Query query=session.createQuery("from Admin where username= :username and password= :password");
            query.setString("username", username);
            query.setString("password", password);
            admin=query.list();
            
            trans.commit();
        }
        catch(Exception e)
        {
            
        }
        return admin;
    }
    
    public void inputNews(News news) {
        Transaction trans = null;
        Session session = ChatifyHibernateUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            session.save(news);
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public List<Admin> retrieveAdmin()
    {
       
        List admin=new ArrayList();
        Transaction trans=null;
        Session session=ChatifyHibernateUtil.getSessionFactory().openSession();
        try
        {
            trans=session.beginTransaction();
            Query query=session.createQuery("from Admin");
            admin=query.list();
         
            trans.commit();
            
        }
        catch(Exception e)
        {

        }
        return admin;
    }
    
    public void deleteUsers(int id) {
        Transaction trans = null;
        Session session = ChatifyHibernateUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            Users users = (Users) session.load(Users.class, new Integer(id));
            session.delete(users);
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
