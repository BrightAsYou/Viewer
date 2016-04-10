package prs.rfh.test.dom4j;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.junit.Test;

public class Dom4jExec {
	@SuppressWarnings(value = { "DEBUG" })
	@Test
	public void CreateXml(){
		
		Element root = DocumentHelper.createElement("UserList");
		Document document = DocumentHelper.createDocument(root); 
		root.setAttributeValue("name", "xiaoming");
//		document.add(new El);
		return ;
	}
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
