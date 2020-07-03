package com.dxc.fees;

import java.sql.Connection;
import java.sql.DriverManager;

public class databaseConnection 
{
		Connection mConnectionObject;
		public Connection getInstance() throws Exception 
		{
			if(mConnectionObject==null) {
			Class.forName("com.mysql.jdbc.Driver");
			mConnectionObject=DriverManager.getConnection("jdbc:mysql://localhost:3306/casestudy?characterEncoding=latin1\",\"nidhin\",\"Myfriends@123");
			return mConnectionObject;
		}
		else
			return mConnectionObject;
		}
}
