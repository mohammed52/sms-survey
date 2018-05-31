package com.example.user.myapplication;

import java.math.BigInteger;

class MuminSample {
    private int its;
    private int hofIts;
    private int age;
    private char gender;
    private BigInteger mobileNo;
    private String fullName;
    private int countFamilyMembers;

    @Override
    public String toString() {
        return "MuminSample{" +
                "its=" + its +
                ", hofIts=" + hofIts +
                ", age=" + age +
                ", gender=" + gender +
                ", mobileNo=" + mobileNo +
                ", fullName='" + fullName + '\'' +
                ", countFamilyMembers=" + countFamilyMembers +
                '}';
    }

    public int getIts() {
        return its;
    }

    public void setIts(int its) {
        this.its = its;
    }

    public int getHofIts() {
        return hofIts;
    }

    public void setHofIts(int hofIts) {
        this.hofIts = hofIts;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public BigInteger getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(BigInteger mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getCountFamilyMembers() {
        return countFamilyMembers;
    }

    public void setCountFamilyMembers(int countFamilyMembers) {
        this.countFamilyMembers = countFamilyMembers;
    }
}
