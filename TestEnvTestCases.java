import com.netenrich.*;
import java.sql.*;
import static org.junit.Assert.*;
import org.junit.Test;
public class TestEnvTestCases {
 DatabaseDetails main = new DatabaseDetails();
 public String database_url = main.Databaseurl();
 public String database_username = main.Databaseusername();
 public String database_password = main.Databasepassword();
 @Test
 public void databaseConnectionTest(){
  Databaseconnection db_connection = new Databaseconnection(database_username,database_password,database_url);
  java.sql.Connection connection = db_connection.Access_Database();
  assertNotNull(connection);
 }

 @Test
 public void bothUsernameAndPasswordGivenCorrect(){
  Login n=new Login("1","1");
  assertEquals("You are logged in.",n.validate());
 }
 @Test
 public void bothUsernameAndPasswordGivenWrong(){
  Login n=new Login("username","password");
  assertEquals("Login Failed.",n.validate());
 }
 @Test
 public void bothUsernameAndPasswordAreOmitted(){
  Login n=new Login("","");
  assertEquals("Login Failed.",n.validate());
  
 }
 @Test
 public void usernameOmitted(){
  Login n=new Login("","password");
  assertEquals("Login Failed.",n.validate());
 }
 @Test
 public void passwordOmitted(){
  Login n=new Login("username","");
  assertEquals("Login Failed.",n.validate());
 }
 @Test
 public void wrongUsername(){
  Login n=new Login("wrongusername","1");
  assertEquals("Login Failed",n.validate());
 }
 @Test
 public void wrongPassword(){
  Login n=new Login("1","password1");
  assertEquals("Login Failed",n.validate());
 }
 @Test
 public void bothGivenButLoginFails(){
  Login n=new Login("","");
  assertEquals("Login Failed",n.validate());
  }
  @Test
 public void bothGivenButLoginFailsAgain(){
  Login n=new Login("dummy","");
  assertEquals("Login Failed",n.validate());
  
 }
 
 
}
