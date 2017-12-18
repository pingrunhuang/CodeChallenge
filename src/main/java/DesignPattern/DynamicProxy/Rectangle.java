package DesignPattern.DynamicProxy;

import DesignPattern.DynamicProxy.IShape;

public class Rectangle implements IShape{
  public Rectangle(){
    System.out.println("Rectangle initialized!");
  }

  public void draw(){
    System.out.println("Rectangle drawing!");
  }
  public void print(){
    System.out.println("Rectangle printing!");
  }
  public void move(){
    System.out.println("Rectangle moving!");
  }
  public void resize(){
    System.out.println("Rectangle resizing!");
  }
}
