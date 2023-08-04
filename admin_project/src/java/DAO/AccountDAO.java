/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DBUntils.DBUtils;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Account;

/**
 *
 * @author DELL
 */
public class AccountDAO {

   /* public static Account getAccount(String username, String password) throws Exception{
        Account a=null; 
       Connection cn=DBUtils.makeConnection();
       String sql="select id, username, password\n" +
             "from account\n" +
             "where username=? AND password=?";
       PreparedStatement st=cn.prepareStatement(sql); 
       st.setString(1,username);
       st.setString(2,password); 
       try{ 
           ResultSet r=st.executeQuery(); 
           while(r.next()){
               String user_C=r.getString("username");
               String pass_C=r.getString("password");
               if(user_C.equals(username)&&pass_C.equals(password)) {
                   a=new Account(r.getInt("id"),user_C,pass_C);
               }
           }
           
       } catch(Exception e){ 
           out.println("Error: "+e);
       }finally{ 
            cn.close();
       }
       return a;
    }*/ 
    public static List<Account> getListUser() throws SQLException, Exception{ 
          List<Account> a= new ArrayList(); 
       Connection cn=DBUtils.makeConnection();
       String sql="select *\n" +
"             from accounts \n" +
"             where role='US'";
       PreparedStatement st=cn.prepareStatement(sql);
       ResultSet r=st.executeQuery(); 
       while(r.next()){
          a.add(new Account(r.getInt("id"),r.getString("name"),r.getString("password"), r.getString("email"),r.getString("phone"),r.getString("role"),r.getString("name"), r.getString("address")));
           }
       return a;
    }
    public static List<Account> accountSearch(String search) throws SQLException, Exception{ 
          List<Account> a= new ArrayList(); 
       Connection cn=DBUtils.makeConnection();
       String sql="select *\n" +
"from accounts\n" +
"where (username like '%"+search+"%' or name like '%"+search+"%' or phone like '%"+search+"%' ) and role='US' ";
       PreparedStatement st=cn.prepareStatement(sql);
       ResultSet r=st.executeQuery(); 
       while(r.next()){
          a.add(new Account(r.getInt("id"),r.getString("name"),r.getString("password"), r.getString("email"),r.getString("phone"),r.getString("role"),r.getString("name"), r.getString("address")));
           }
       return a;
    }
    public static boolean deletedAccount(String id) throws Exception{
        int idx= Integer.parseInt(id);
        Connection cn=DBUtils.makeConnection();
       String sql="UPDATE accounts SET deleted=0 where id=?";
       PreparedStatement st=cn.prepareStatement(sql);
       st.setInt(1, idx);
       
       return st.executeUpdate()==1;
    }
    public static void main(String[] args) throws Exception {
        AccountDAO.deletedAccount("14");
    }
}
