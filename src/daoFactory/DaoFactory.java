package daoFactory;

import java.sql.Connection;

import dao.interfaces.UserDao;

public abstract class DaoFactory {


  public abstract Connection openConnection();	
  public abstract UserDao getUserDao();
  
  public static DaoFactory getDatabase() {
      return new Oracle();
  }
}
