package DesignPattern.DynamicProxy;

import java.lang.reflect.*;
import DesignPattern.DynamicProxy.*;

public class Main{
  public static void main(String[] args){
    IAnimal dog = new Dog();
    ClassLoader dogLoader = IAnimal.class.getClassLoader();
    Dog proxyDog = (Dog) Proxy.newProxyInstance(
      dogLoader, new Class[] {Dog.class}, new LoggedHandler(dog)
    );
    proxyDog.eat();
    proxyDog.move();

    IShape rec = new Rectangle();
    ClassLoader recLoader = IShape.class.getClassLoader();
    IShape proxyRec = (IShape) Proxy.newProxyInstance(
      recLoader, new Class[] {IShape.class}, new LoggedHandler(rec)
    );
    proxyRec.draw();
    proxyRec.print();
    proxyRec.move();
    proxyRec.resize();
  }
}
