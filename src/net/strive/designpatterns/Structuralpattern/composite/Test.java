package net.strive.designpatterns.Structuralpattern.composite;

import java.util.List;

/**
 * 组合模式
 * 1.你想表示对象的部分-整体层次结构。
 * 2.你希望用户忽略组合对象与单个对象的不同，用户将统一地使用组合结构中的所有对象。
 *
 */
public class Test {

	public static void main(String[] args) {
		Employer pm=new ProjectManager("项目经理");
		Employer pa=new ProjectAssistant("项目经理助理");
		Employer pg1=new Programmer("程序员A");
		Employer pg2=new Programmer("程序员B");
		
		pm.add(pa);
		pm.add(pg2);
		List list=pm.getEmployers();
		/*
		for(Employer em:list)
		{
			System.out.println(em.getName());
		}*/
	}
}
