/**
 * 
 */
package com.bhaskar.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;


/**
 * @author Bhaskar
 *
 * 
 */

@Aspect

public class AopExpressions {

	@Pointcut("execution( * com.bhaskar.aop.dao.*.*(..))")
	public void forDaoPackage() {}
	
	//create put cut to getter methos
	@Pointcut("execution( * com.bhaskar.aop.dao.*.get*(..))")
	public void getter() {}
	
	//create put cut to setter methos
	@Pointcut("execution( * com.bhaskar.aop.dao.*.get*(..))")
	public void setter() {}
	
	// include package --- exclude getter/setter
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	public void forDaoPackageNoGetterSetter() {}
	
	
}
