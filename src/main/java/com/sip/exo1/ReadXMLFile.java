package com.sip.exo1;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

public class ReadXMLFile {
	public static void main(String[] args) {
	        final String fileName = "jdom_users.xml";
	        try {
	            // we can create JDOM Document from DOM, SAX and STAX Parser Builder classes
	            SAXBuilder builder = new SAXBuilder();
	            File xmlFile = new File(fileName);
	            Document jdomDoc = (Document) builder.build(xmlFile);
	            Element root = jdomDoc.getRootElement();
	            List < Element > listOfUsers = root.getChildren("User");
	            List <User> userList = new ArrayList<User>();
	            for(Element userElement: listOfUsers) {
	                User user = new User();
	                user.setId(Integer.parseInt(userElement.getAttributeValue("id")));
	                user.setAge(Integer.parseInt(userElement.getChildText("age")));
	                user.setFirstName(userElement.getChildText("firstName"));
	                user.setLastName(userElement.getChildText("lastName"));
	                user.setGender(userElement.getChildText("gender"));
	                userList.add(user);
	            }
	            // lets print Users list information
	           // userList.forEach( user ->{ System.out.println(user.toString()) ;});
	            System.out.println(userList);

	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	    }

}
