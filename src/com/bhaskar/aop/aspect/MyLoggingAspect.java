package com.bhaskar.aop.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.bhaskar.aop.Account;

@Aspect
@Component

@Order(2)
public class MyLoggingAspect {
	
	// add a new advice for @AfterReturning
	
	@AfterReturning(
			pointcut="execution(* com.bhaskar.aop.dao.AccountDAO.findAccounts(..))",
			returning="result")
	public void afterReturningFindAccountAdvice(
			JoinPoint theJoinPoint, List<Account> result) {
		
		String method=theJoinPoint.getSignature().toShortString();
		System.out.println("\n ========> Executing @AfterReturning on method: "+ method);
		System.out.println("\n ======= result is : " +result);
		
		// let post process the data lets modify
		convertAccountNamesToUpperCase(result);
		System.out.println("\n ======= result is : " +result);
	}
	
	/**
	 * @param result
	 */
	private void convertAccountNamesToUpperCase(List<Account> result) {
		for (Account tempAccount : result) {
			String theUpperName=tempAccount.getName().toUpperCase();
			tempAccount.setName(theUpperName);
		}
		
	}

	@Before("com.bhaskar.aop.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
		System.out.println("\n ===> executing MyLoggingAspect");
		
		// display the method signature
		MethodSignature methoSig=(MethodSignature) theJoinPoint.getSignature();
		System.out.println("Method: " + methoSig);
		
		// display method arguments
		
		// Objects[] args
		
		Object[] args=theJoinPoint.getArgs();
		
		for(Object tempArg: args) {
			System.out.println(tempArg);
			
			if(tempArg instanceof Account) {
				Account theAccount=(Account) tempArg;
				System.out.println("account name: " + theAccount.getName());
				System.out.println("account lavel: " + theAccount.getLavel());
			}
			
		}
	}
	
	
	
	
}
