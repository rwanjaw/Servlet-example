import java.util.*;
import java.sql.*;

public class EmpDao {
//this is the connection to the database
	public static Connection getConnection(){
            Connection connection=null;
   String url="jdbc:mysql://localhost:3306/";
   String driver="com.mysql.jdbc.Driver";
   String dbName="units";
   String userName="root";
   String password="";
   Statement stmt;
   ResultSet rs;
		
		try{Class.forName(driver);
          connection=DriverManager.getConnection(url+dbName,userName,password);
           System.out.println("Connected");
          stmt=connection.createStatement();
		}catch (SQLException | ClassNotFoundException e) {
           System.out.println(e.getMessage());}
		return connection;
	}
        //serves the sql queries of the save servlet
	public static int save(Emp e){
		int status=0;
		try{
			Connection con=EmpDao.getConnection();
			PreparedStatement ps=con.prepareStatement("insert into rooms(room,capacity,equipment,position) values (?,?,?,?)");
			ps.setString(1,e.getRoom());
			ps.setString(2,e.getCapacity());
			ps.setString(3,e.getEquipment());
			ps.setString(4,e.getPosition());
			
			
			status=ps.executeUpdate();
			
			con.close();
		}catch(Exception ex){ex.printStackTrace();}
		
		return status;
	}
        //serves the editservlet2 with updating the database
	public static int update(Emp e){
		int status=0;
		try{
			Connection con=EmpDao.getConnection();
			PreparedStatement ps=con.prepareStatement("update rooms set room=?,capacity=?,equipment=?,position=? where id=?");
			ps.setString(1,e.getRoom());
			ps.setString(2,e.getCapacity());
			ps.setString(3,e.getEquipment());
			ps.setString(4,e.getPosition());
			ps.setInt(5,e.getId());
			
			status=ps.executeUpdate();
			
			con.close();
		}catch(Exception ex){ex.printStackTrace();}
		
		return status;
	}
        //serves the purpose of deleting fromthe database using deleteservlet
	public static int delete(int id){
		int status=0;
		try{
			Connection con=EmpDao.getConnection();
			PreparedStatement ps=con.prepareStatement("delete from rooms where id=?");
			ps.setInt(1,id);
			status=ps.executeUpdate();
			
			con.close();
		}catch(Exception e){e.printStackTrace();}
		
		return status;
	}
        //gets all the roooms for editing in editservlet
	public static Emp getRoomById(int id){
		Emp e=new Emp();
		
		try{
			Connection con=EmpDao.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from rooms where id=?");
			ps.setInt(1,id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				e.setId(rs.getInt(1));
				e.setRoom(rs.getString(2));
				e.setCapacity(rs.getString(3));
				e.setEquipment(rs.getString(4));
				e.setPosition(rs.getString(5));
			}
			con.close();
		}catch(Exception ex){ex.printStackTrace();}
		
		return e;
	}
        //gets all the sql for showing all rooms
	public static List<Emp> getAllRoom(){
		List<Emp> list=new ArrayList<Emp>();
		
		try{
			Connection con=EmpDao.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from rooms");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Emp e=new Emp();
				e.setId(rs.getInt(1));
				e.setRoom(rs.getString(2));
				e.setCapacity(rs.getString(3));
				e.setEquipment(rs.getString(4));
				e.setPosition(rs.getString(5));
				list.add(e);
			}
			con.close();
		}catch(Exception e){e.printStackTrace();}
		
		return list;
	}
        //deals with sql statement for the user login
        public static int User(String uname,String pword){
		Emp e=new Emp();
		int status=1;
		try{
			Connection con=EmpDao.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from registrations where user=? and pword=?");
			ps.setString(1,uname);
                        ps.setString(2,pword);
			ResultSet rs=ps.executeQuery();
			rs.next();
                    
		}catch(Exception ex){ex.printStackTrace();
                }
		
		    return status;
	}
}
