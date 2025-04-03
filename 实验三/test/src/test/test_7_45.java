package test;

import test.impl.*;
import test.UserDao;

import java.util.Scanner;

public class Test7_45 {
    public static void main(String[] args){
        UserDao userDao = new UserDaoForArray();
        User t1 = new User("liu,song","liu123","Teacher".toUpperCase());
        User t2 = new User("niu,hong","niu123","Teacher".toUpperCase());
        User t3 = new User("mao,long","mao123","Teacher".toUpperCase());
        userDao.addUser(t1);
        userDao.addUser(t2);
        userDao.addUser(t3);
        Course c1 = new Course("Java","C0001","2");
        Course c2 = new Course("JavaScript","C0002","1");
        Course c3 = new Course("html","C0003","1");
        Course c4 = new Course("cplusplus","C0004","3");
        userDao.addCourse(t1,c1);
        userDao.addCourse(t2,c2);
        userDao.addCourse(t3,c3);
        userDao.addCourse(t3,c4);
        userDao.addUser(new User("zhang,hua","zhang123","Student".toUpperCase()));
        userDao.addUser(new User("huang,fang","huang123","Student".toUpperCase()));
        userDao.addUser(new User("chen,xing","chen123","Student".toUpperCase()));
        userDao.addUser(new User("wei,xi","wei123","Student".toUpperCase()));
        Application application = new Application(userDao);
        Scanner sc = new Scanner(System.in);
        System.out.println(userDao.getName());
        while(true) {
            System.out.println("Login/Register(Y/N):");
            String lr = sc.nextLine();
            if(lr.toUpperCase().equals("Y")){
                application.login();
            }
            else{
                application.register();
            }
        }
    }
}
