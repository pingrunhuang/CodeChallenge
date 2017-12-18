package DesignPattern.DynamicProxy;

import java.lang.reflect.*;

/*
this handler class is so generic that it can handle all kinds of interface
*/
public class LoggedHandler implements InvocationHandler{
  private Object interfaceToBeLogged;
  public LoggedHandler(Object o){
    this.interfaceToBeLogged = o;
  }

  public Object invoke(Object proxy, Method m, Object[] args) throws Throwable{
    System.out.println("Generic logger entry: " + m.getName());
    return m.invoke(this.interfaceToBeLogged, args);
  }

}
