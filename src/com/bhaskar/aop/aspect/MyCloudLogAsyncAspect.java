/**
 * 
 */
package com.bhaskar.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author Bhaskar
 *
 * 
 */
@Aspect
@Component
@Order(1)
public class MyCloudLogAsyncAspect {

	@Before("com.bhaskar.aop.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
	public void logToCloudsAsync() {
		System.out.println("\n ====> logging To Clouds in Async !!!!!!!");
	}
}
