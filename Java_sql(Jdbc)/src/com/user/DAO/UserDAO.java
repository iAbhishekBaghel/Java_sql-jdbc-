package com.user.DAO;
import java.sql.PreparedStatement;

import java.sql.ResultSet;

import java.sql.SQLException;

import java.sql.Statement;

import java.util.ArrayList;

import java.util.List;

import com.user.Util.DBUtil;

import com.user.bean.User;

public class UserDAO {

 PreparedStatement preparedStatement;

 String qry="";

 public int insertUser(User user)throws SQLException

 {

 qry="insert into users (ID,NAME,AGE,CITY) values(?,?,?,?)";

 preparedStatement= DBUtil.getConnection().prepareStatement(qry);

 preparedStatement.setInt(1, user.getId());

 preparedStatement.setString(2, user.getName());

 preparedStatement.setInt(3, user.getAge());

 preparedStatement.setString(4, user.getCity());

 return preparedStatement.executeUpdate();

 }

 public int updateUser(User user)throws SQLException

 {

 qry="update users set NAME=?,AGE=?,CITY=? where ID=?";

 preparedStatement= DBUtil.getConnection().prepareStatement(qry);

 preparedStatement.setString(1, user.getName());

 preparedStatement.setInt(2, user.getAge());

 preparedStatement.setString(3, user.getCity());

 preparedStatement.setInt(4, user.getId());

 return preparedStatement.executeUpdate();

 }

 public int deleteUser(int id)throws SQLException

 {

 qry="delete from users where ID=?";

 preparedStatement= DBUtil.getConnection().prepareStatement(qry);

 preparedStatement.setInt(1, id);

 return	preparedStatement.executeUpdate();

 }

 public List<User> getAllRecords()throws SQLException

 {

 Statement stmt =DBUtil.getConnection().createStatement();

 qry="SELECT ID,NAME,AGE,CITY from users";

 ResultSet rs=stmt.executeQuery(qry);

 List<User> arrayList=new ArrayList<>();

 while(rs.next())

 {

  User user=new User();

  user.setId(rs.getInt("ID"));

  user.setName(rs.getString("NAME"));

  user.setAge(rs.getInt("AGE"));

  user.setCity(rs.getString("CITY"));

  arrayList.add(user);

 }

 return arrayList;

 }

 public List<User> getAllRecordsByCity(String city)throws SQLException

 {

 qry="SELECT ID,NAME,AGE,CITY from users where city=?";

 preparedStatement =DBUtil.getConnection().prepareStatement(qry);

 preparedStatement.setString(1, city);

 ResultSet rs=preparedStatement.executeQuery();

 List<User> arrayList=new ArrayList<>();

 while(rs.next())

 {

  User user=new User();

  user.setId(rs.getInt("ID"));

  user.setName(rs.getString("NAME"));

  user.setAge(rs.getInt("AGE"));

  user.setCity(rs.getString("CITY"));

  arrayList.add(user);

 }

 return arrayList;

 }

 public List<User> getAllNamesSortedOrder()throws SQLException

 {

 Statement stmt =DBUtil.getConnection().createStatement();

 qry="SELECT ID,NAME,AGE,CITY from users order by name";

 ResultSet rs=stmt.executeQuery(qry);

 List<User> arrayList=new ArrayList<>();

 while(rs.next())

 {

  User user=new User();

  user.setId(rs.getInt("ID"));

  user.setName(rs.getString("NAME"));

  user.setAge(rs.getInt("AGE"));

  user.setCity(rs.getString("CITY"));

  arrayList.add(user);

 }

 return arrayList;

 }

}