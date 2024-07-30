package com.user.Main;
import java.util.List;

import java.util.Scanner;

import com.user.DAO.UserDAO;

import com.user.bean.User;

public class MySQLDemoPro {

 //city.....

 public static void main(String[] args) throws Exception {

 int id,age,choice;

 String name,city;

 List<User> list;

 Scanner in = new Scanner(System.in);

 Scanner str = new Scanner(System.in);

 while(true)

 {

  System.out.println("MYSQL Java CRUD Operation");

  System.out.println("1. Insert");

  System.out.println("2. Update");

  System.out.println("3. Delete");

  System.out.println("4. Select");

  System.out.println("5. Exit");

  System.out.println("6. SortByName");

  System.out.println("7. DisplayDataByCity");

  System.out.print("Enter a choice: ");

  choice = in.nextInt();

  User user=new User();

  UserDAO userDAO=new UserDAO();

  int res=0;

  System.out.println("-----------------------------------------");

  switch(choice){

  case 1:

  System.out.println("1. Insert New Data");

  System.out.println("Enter ID");

         id=in.nextInt();

  System.out.println("Enter Name : ");

  name=str.nextLine();

  System.out.println("Enter Age : ");

  age=in.nextInt();

  System.out.println("Enter City : ");

  city=str.nextLine();

  int error=0;

  String regularExpression = "^[A-Za-z]{2,29}$";

    if (name.matches(regularExpression)) {

      //System.out.println("Valid");

    } else {

    error++;

      //System.out.println("Invalid Name");

    }

    String ageExpression="^[0-9]{1,3}$";

    if (String.valueOf(age).matches(ageExpression)) {

      System.out.println("Valid");

    } else {

     error++;

     System.out.println("Invalid Age");

    }

    if (city.matches(regularExpression)) {

      System.out.println("Valid");

    } else {

     error++;

      System.out.println("Invalid City");

    }

  if(error>0)

  {

   System.out.println("Please enter proper data");

  }

  else {

   user.setId(id);

   user.setName(name);

   user.setAge(age);

   user.setCity(city);

  res=userDAO.insertUser(user);

  }

  if(res==1) {

  System.out.println("Data Insert Success");

  }

  break;

  case 2:

  System.out.println("2. Updating a Data");

  System.out.println("Enter ID : ");

  id=in.nextInt();

  System.out.println("Enter Name : ");

  name=str.nextLine();

  System.out.println("Enter Age : ");

  age=in.nextInt();

  System.out.println("Enter City : ");

  city=str.nextLine();

  user.setId(id);

  user.setName(name);

  user.setAge(age);

  user.setCity(city);

   res=userDAO.updateUser(user);

   if(res>=1) {

  System.out.println("Data Update Success");

   }

  break;

  case 3:

  System.out.println("3. Deleting a Data");

  System.out.println("Enter ID : ");

  id=in.nextInt();

  res=userDAO.deleteUser(id);

  if(res==1) {

  System.out.println("Data Deleted Success");

  }

  break;

  case 4:

  System.out.println("4. Print all Records");

   list= userDAO.getAllRecords();

  //list.forEach(us->System.out.println(us.getId()+" "+us.getName()+" "+us.getCity()));

   for(User us:list)

  {

   System.out.println(us.getId()+" "+us.getName()+" "+us.getAge()+" "+us.getCity());

  }

  break;

  case 5:

  System.out.println("Thank You");

  System.exit(0);

  break;

  case 6:

  System.out.println("6. Print all Records By Name");

  list= userDAO.getAllNamesSortedOrder();

  for(User us:list)

  {

   System.out.println(us.getId()+" "+us.getName()+" "+us.getAge()+" "+us.getCity());

  }

  break;

  case 7:

  System.out.println("Enter City : ");

  city=str.nextLine();

  System.out.println("6. Print all Records By Name");

  list= userDAO.getAllRecordsByCity(city);

  for(User us:list)

  {

   System.out.println(us.getId()+" "+us.getName()+" "+us.getAge()+" "+us.getCity());

  }

  break;

  default:

  System.out.println("Invalid Selection");

  break;

  }

  System.out.println("-----------------------------------------");

 }

 }

} 

