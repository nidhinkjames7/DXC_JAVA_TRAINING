package jsonExamples;

import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

class dxcEmployee
{
	String empId,empName;

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}
	
}
public class jsonDBExample 
{
	public static void main(String[] args) throws Exception
	{
		File mfile= new File("F:\\DXC TECHNOLOGY\\JAVA-FSD- TRAINING\\JSON\\dxc_employee.json");
		FileReader mReader=new FileReader(mfile);
		JSONParser mJsonparser=new JSONParser();
		JSONObject mJsonObject= (JSONObject) mJsonparser.parse(mReader);
		
		List<dxcEmployee> mList=new ArrayList<dxcEmployee>();
		JSONArray employeeArray=(JSONArray) mJsonObject.get("DXC_Employee");
		for(int i=0;i<employeeArray.size();i++)
		{
			dxcEmployee mObject=new dxcEmployee();
			JSONObject mJsonInnerObject=(JSONObject) employeeArray.get(i);
			mObject.setEmpId((String) mJsonInnerObject.get("id"));
			mObject.setEmpName((String) mJsonInnerObject.get("name"));
			mList.add(mObject);
		}
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/contactdb?characterEncoding=latin1","nidhin","Myfriends@123");
		
		for(int i=0;i<mList.size();i++)
		{
			dxcEmployee mObject=mList.get(i);
			String insertQuery= "INSERT INTO dxc_employee VALUES(?,?)";
			PreparedStatement pstmt=(PreparedStatement) con.prepareStatement(insertQuery);
			pstmt.setString(1, mObject.getEmpId());
			pstmt.setString(2, mObject.getEmpName());
			pstmt.execute();
		}
		System.out.println("Sucessfully Done");

	}
}
