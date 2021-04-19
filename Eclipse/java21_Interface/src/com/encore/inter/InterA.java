package com.encore.inter;
//인터페이스 == 완전한 추상
//1. 이 자체로는 객체를 절대로 만들 수 없다
//2. 객체를 만들려면 상속을 받아서 모든 추상메소드를 구현해라

public interface InterA {
     int NUM = 10;
     void printNum();//인터페이스는 선언만 해야함 (상수와 추상메소드로만 구성 가능)
}
