package DesignPattern.DynamicProxy;

public class Dog implements IAnimal{

  public Dog(){
    System.out.println("Dog initialized!");
  }

  public void eat(){
    System.out.println("Dog needs to eat");
  }

  public void move(){
    System.out.println("Dog can move!");
  }
}
