package entity;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/*
//Author name : Jacquelin Ooi Jia Qi
//Student ID : 23WMR07647
//Programme : RSD2S1G1
*/
public class Volunteer implements Comparable<Volunteer> {
    private String name;
    private int age;
    private String gender;

    public Volunteer(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender.toUpperCase(); // Ensure gender is always uppercase
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender.toUpperCase(); // Ensure gender is always uppercase
    }

    @Override
    public String toString() {
        return String.format("%-30s %-4d %-6s", name, age, gender);
    }

    @Override
    public int compareTo(Volunteer other) {
        if (this.name == null || other.name == null) {
            throw new IllegalArgumentException("Name cannot be null");
        }
        return this.name.compareTo(other.name);
    }
}
