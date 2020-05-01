package com.bhaskar.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.bhaskar.aop.dao.AccountDAO;
import com.bhaskar.aop.dao.AopConfig;
import com.bhaskar.aop.dao.MembershipDAO;

public class MainApp {

	public static void main(String[] args) {
		
		//read spring config java class 
		AnnotationConfigApplicationContext context=
				new AnnotationConfigApplicationContext(AopConfig.class);
		
		//get the bean from container
		AccountDAO theAccoutDAO=context.getBean("accountDAO", AccountDAO.class);
		
		MembershipDAO theMembershipDAO=context.getBean("membershipDAO", MembershipDAO.class);
		
		Account myAccount=new Account();
		myAccount.setName("bhaskar");
		myAccount.setLavel("platinum");
		//call the bussiness method
       theAccoutDAO.addAccount(myAccount, true);
       theAccoutDAO.doWork();
       
       //call accountdao setter getter methods
       theAccoutDAO.setName("bhaskar");
       	theAccoutDAO.setServiceCode("silver");
       	
       	String name=theAccoutDAO.getName();
       	String code=theAccoutDAO.getServiceCode();
       
       theMembershipDAO.addSilly();
       theMembershipDAO.goToSleep();
       
     
       //close the context
       context.close();
	}

}
