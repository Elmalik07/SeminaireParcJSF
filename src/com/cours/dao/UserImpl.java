package com.cours.dao;

import com.cours.entities.User;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserImpl implements IUser{
    private DB db = new DB();
        private int ok;
    @Override
    public User connection(String email, String password){
        String sql = "SELECT * FROM user WHERE email = ? AND password = ?";
        User user = null;
        try {
            db.initPrepar(sql);
            db.getPstm().setString(1,email);
            db.getPstm().setString(2, password);
            ResultSet rs = db.executeSelect();
            if (rs.next()){
                user = new User();
                user.setid(rs.getInt(1));
                user.setNom(rs.getString(2));
                user.setPrenom(rs.getString(3));
                user.setEmail(rs.getString(4));
                user.setPassword(rs.getString(5));
                user.setEtat(rs.getBoolean(6));
            }
            rs.close();
            db.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return user;
    }

    @Override
    public int add(User user) {
        String sql = "INSERT INTO user VALUES(NULL, ?, ?, ?, ?, ?) ";
        try {
            //initialisation des requetes
            db.initPrepar(sql);
            //passage des valeurs a la requete
            db.getPstm().setString(1, user.getNom());
            db.getPstm().setString(2, user.getPrenom());
            db.getPstm().setString(3, user.getEmail());
            db.getPstm().setString(4,user.getPassword());
            db.getPstm().setBoolean(5, user.getEtat());
            //execution
            ok = db.executeMaj();
            db.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return ok;
    }

    @Override
    public int delete(int id) {
        String sql = "DELETE FROM user WHERE id = ?";
        try {
            db.initPrepar(sql);
            db.getPstm().setInt(1, id);
            ok = db.executeMaj();
            db.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }

        return ok;

    }

    @Override
    public int update(User user) {
        String sql = "UPDATE user SET nom = ?, prenom = ?, email = ?, password = ?, etat = ? WHERE id = ? ";
        try {
            //initialisation des requetes
            db.initPrepar(sql);
            //passage de valeurs à la resquete
            db.getPstm().setString(1, user.getNom());
            db.getPstm().setString(2, user.getPrenom());
            db.getPstm().setString(3, user.getEmail());
            db.getPstm().setString(4, user.getPassword());
            db.getPstm().setBoolean(5, user.getEtat());
            //execution
            ok = db.executeMaj();
            db.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return ok;
    }

    @Override
    public User get(int id) {

        String sql = "SELECT * FROM user WHERE id = ?";
        User user = null;
        try {
            db.initPrepar(sql);
            db.getPstm().setInt(1, id);
            ResultSet rs = db.executeSelect();
            if (rs.next()){
                user = new User();
                user.setid(rs.getInt(1));
                user.setNom(rs.getString(2));
                user.setPrenom(rs.getString(3));
                user.setEmail(rs.getString(4));
                user.setPassword(rs.getString(5));
                user.setEtat(rs.getBoolean(6));
            }
            db.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return user;
    }

    @Override
    public List<User> list() {
        String sql = "SELECT * FROM user";
        User user = null;
        List<User> users = new ArrayList<User>();
        try {
            db.initPrepar(sql);
            ResultSet rs = db.executeSelect();
            while (rs.next()){
                user = new User();
                user.setid(rs.getInt(1));
                user.setNom(rs.getString(2));
                user.setPrenom(rs.getString(3));
                user.setEmail(rs.getString(4));
                user.setPassword(rs.getString(5));
                user.setEtat(rs.getBoolean(6));
                users.add(user);
            }
            db.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return users;
    }
}
