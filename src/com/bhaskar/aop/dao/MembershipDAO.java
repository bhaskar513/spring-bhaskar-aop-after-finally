package com.bhaskar.aop.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

	public boolean addSilly()
	{
		System.out.println(getClass()+ " doing add membership account");
		return true;
	}
	
	public void goToSleep()
	{
		System.out.println(getClass()+ " i am going to sleep");
		return ;
	}
}
