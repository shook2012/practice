package net.strive.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


public class Test {
	
	public static void main(String[] args) {
		 ConnectionUtil cu = new ConnectionUtil();
		 
		 Connection con=cu.openConnection();
		 try {
			PreparedStatement stmt=con.prepareStatement("select * from alz_product");
			ResultSet rs=stmt.executeQuery();
			/*while(rs.next())
			{
				String id=rs.getString("id");
				String title=rs.getString("title");
				System.out.println("row:"+rs.getRow()+"id:"+id+"title:"+title);
			}*/
			List list=resultSetToList(rs);
			System.out.println("list:" + list.toString());   
			
			Iterator it = list.iterator();   
			while(it.hasNext()) {   
			    Map hm = (Map)it.next();   
			    System.out.println(hm.get("title"));   
			} 
			
		
		 } catch (SQLException e) {
			 e.printStackTrace();
		 }
		  // 第三种方法
		  System.out.println("这是最常用的一种方法:" + cu.openConnection());
	}
	
	
	/**
	 * @function:ResultSet to List 
	 * @return
	 * @throws java.sql.SQLException
	 */
	public static List resultSetToList(ResultSet rs) throws java.sql.SQLException {   
        if (rs == null)   
            return Collections.EMPTY_LIST;   
        ResultSetMetaData md = rs.getMetaData(); //得到结果集(rs)的结构信息，比如字段数、字段名等   
        int columnCount = md.getColumnCount(); //返回此 ResultSet 对象中的列数   
        List list = new ArrayList();   
        Map rowData = new HashMap();   
        while (rs.next()) {   
         rowData = new HashMap(columnCount);   
         for (int i = 1; i <= columnCount; i++) {   
                 rowData.put(md.getColumnName(i), rs.getObject(i));   
         }   
         list.add(rowData);   
        }   
        return list;   
}  

}
