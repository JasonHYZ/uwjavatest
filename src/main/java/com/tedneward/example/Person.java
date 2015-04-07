package com.tedneward.example;

import java.beans.*;
import java.util.*;

public class Person implements Comparable<Person>{
    private int age;
    private String name;
    private double salary;
    private String ssn;
    private boolean propertyChangeFired = false;
    private static int i;
    private static int countNumber;
    
    
    
    
    public Person() {
        this("", 0, 0.0d);
    }
    
    public Person(String n, int a, double s) {
        name = n;
        age = a;
        salary = s;
        ssn = "";
        countNumber = ++i;
    }
    
    public int getAge() {
        return age;
    }
    
    public void setAge(int age){
        if(age <= 0)
            throw new IllegalArgumentException("invaliad age input");
        else
            this.age = age;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name){
        if (name == null)
            throw new IllegalArgumentException("invalid name input");
        else this.name = name;
    }
    public double getSalary() {
        return salary;
    }
    
    public void setSalary(double money){
        this.salary = money;
    }
    public String getSSN() {
        return ssn;
    }
    public void setSSN(String value) {
        String old = ssn;
        ssn = value;
        
        this.pcs.firePropertyChange("ssn", old, value);
        propertyChangeFired = true;
    }
    public boolean getPropertyChangeFired() {
        return propertyChangeFired;
    }
    
    public double calculateBonus() {
        return salary * 1.10;
    }
    
    public String becomeJudge() {
        return "The Honorable " + name;
    }
    
    public int timeWarp() {
        return age + 10;
    }
    
    public boolean equals(Object other){
        if (other instanceof Person){
            Person p = (Person)other;
            if(this.age == p.age && this.name == p.name)
                return true;
            else
                return false;
        }else
            return false;
    }
    
    public String toString() {
        return "[Person" + " name:" + this.name + " age:" + this.age + " salary:" + this.salary + "]";
    }
    
    // PropertyChangeListener support; you shouldn't need to change any of
    // these two methods or the field
    //
    private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        this.pcs.addPropertyChangeListener(listener);
    }
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        this.pcs.removePropertyChangeListener(listener);
    }
    
    public PropertyChangeSupport getPcs(){
        return pcs;
    }
    
    public int count(){
        return countNumber;
    }
    
    public static class AgeComparator implements Comparator<Person>{
        
        public int compare(Person p1, Person p2){
            return p1.age - p2.age;
            
        }
    }
    
    
    
    public int compareTo(Person other){
        return (other.salary < this.salary ? -1 : (other.salary == this.salary ? 0 : 1));
    }
    
    
    public static ArrayList<Person> getNewardFamily(){
        
        ArrayList<Person> familyMember = new ArrayList<Person>();
        
        Person ted = new Person("Ted",41,250000);
        Person charlotte = new Person("Charlotte",43,150000);
        Person michael = new Person("Michael",22,10000);
        Person matthew = new Person("Matthew",15,0);
        
        familyMember.add(ted);
        familyMember.add(charlotte);
        familyMember.add(michael);
        familyMember.add(matthew);
        
        return familyMember;
    }
    
}
