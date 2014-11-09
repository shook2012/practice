package net.strive.designpatterns.Structuralpattern.proxy;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
/**
 * 动态代理类
 */
public class ProxyHandler implements InvocationHandler
{   
  private java.lang.Object proxied;   
     
  public ProxyHandler( java.lang.Object proxied )   
  {   
    this.proxied = proxied;   
  }   
     
  public java.lang.Object invoke( java.lang.Object proxy, Method method, java.lang.Object[] args ) throws Throwable   
  {   
    //在转调具体目标对象之前，可以执行一些功能处理

    //转调具体目标对象的方法
    return method.invoke( proxied, args);  
    
    //在转调具体目标对象之后，可以执行一些功能处理
  }    
} 