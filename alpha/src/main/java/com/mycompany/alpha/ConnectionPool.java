package spe.mch;
import java.util.Stack;
import java.sql.*;

/**
 *
 * @author dea40349
 */
public class ConnectionPool {
    private static final int MAX_CONNECTIONS = 5;
    private final Stack<Connection> myDBStack = new Stack<>();
    private static ConnectionPool pool = null;
    
    //Singleton-Entwurfsmuster ==> privaten Konstruktor
    private ConnectionPool(){}
    
    public synchronized static ConnectionPool createConnectionPool(){
        if(pool==null){
            pool = new ConnectionPool();
        }
        
        return pool;
    }
    
    private synchronized Connection createConnection(Connection conn){
        String user = "trainer";
        String password = "12345678";
        String url = "jdbc:derby://localhost:1527/gaestebuchdb";
        
        try{
          conn = DriverManager.getConnection(url, user, password);  
        }
        catch(SQLException e){System.out.println(e.getMessage());}
        return conn;
    }
    
    public synchronized Connection getConnection(){
        Connection conn = null;
        
        if(myDBStack.empty()){
            conn = createConnection(conn);
        }
        else{
            conn = myDBStack.pop();
        }
        return conn;
    }
    
    public synchronized void releaseConnection(Connection conn){
        if(conn!=null && myDBStack.size() >= MAX_CONNECTIONS){
            try{
            conn.close();
            conn = null;
            } catch(SQLException e){}
        }
        else if(conn != null){
            try{
                conn.commit();
                myDBStack.push(conn);
            } catch(SQLException e){}
            
        }
    }
    
}
