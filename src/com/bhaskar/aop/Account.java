/**
 * 
 */
package com.bhaskar.aop;

/**
 * @author Bhaskar
 *
 * 
 */
public class Account {
	private String name;
	private String lavel;
	
	public Account() {
		
	}
	
	public Account(String name, String lavel) {
		this.name = name;
		this.lavel = lavel;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLavel() {
		return lavel;
	}
	public void setLavel(String lavel) {
		this.lavel = lavel;
	}

	@Override
	public String toString() {
		return "Account [name=" + name + ", lavel=" + lavel + "]";
	}
	
	

}
