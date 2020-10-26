/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.List;
import model.ChatifyHibernateUtil;
import model.Users;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author user
 */
public class usersController {
    public void register(Users users) {
        Transaction trans = null;
        Session session = ChatifyHibernateUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            session.save(users);
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public List<Users> validateLogin(String username, String password)
    {
        List<Users> users = new ArrayList();
       
         Transaction trans=null;
        Session session=ChatifyHibernateUtil.getSessionFactory().openSession();
        try 
        {
            trans=session.beginTransaction();
            Query query=session.createQuery("from Users where username= :username and password= :password");
            query.setString("username", username);
            query.setString("password", password);
            users=query.list();
            
            trans.commit();
        }
        catch(Exception e)
        {
            
        }
        return users;
    }
    
    public List<Users> readUsers(Integer id) {

        List users = new ArrayList();
        Transaction trans = null;
        Session session = ChatifyHibernateUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            Query query = session.createQuery("FROM Users where id = :id");
            query.setInteger("id", id);
            users = query.list();

            trans.commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }
    
    public void updateUsers(Users users) {
        Transaction trans = null;
        Session session = ChatifyHibernateUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            session.update(users);
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public List<Users> getbyemail(String email) {
        List<Users> users = new ArrayList();

        Transaction trans = null;
        Session session = ChatifyHibernateUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            Query query = session.createQuery("from Users where email= :email");
            query.setString("email", email);
            users = query.list();

            trans.commit();
        } catch (Exception e) {

        }
        return users;
    }
    
    public List<Users> getbyID(int id) {
        List<Users> users = new ArrayList();

        Transaction trans = null;
        Session session = ChatifyHibernateUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            Query query = session.createQuery("from Users where id= :id");
            query.setInteger("id", id);
            users = query.list();

            trans.commit();
        } catch (Exception e) {

        }
        return users;
    }
    
    public List<Users> getByUsername(String username) {
        List<Users> users = new ArrayList();

        Transaction trans = null;
        Session session = ChatifyHibernateUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            Query query = session.createQuery("from Users where username = :username");
            query.setString("username", username);
            users = query.list();

            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }
}
