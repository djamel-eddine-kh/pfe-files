package com.mi19.JPATemplate.util;

import org.springframework.stereotype.Component;

import java.time.LocalDate;


@Component
public class Tester {
    static boolean accept(Object old,Object _new){
        if (_new ==null)return false;
        return!_new.equals(old);
    }
    static boolean accept(Boolean old, Boolean _new){
        if (_new ==null)return false;
        return!_new.equals(old);
    }
    static boolean accept(Number old, Number _new){
        if (_new ==null)return false;
        return!_new.equals(old);
    }
    static boolean accept(String old,String _new){
        if (_new ==null)return false;
        return (!_new.isEmpty()&&!_new.isBlank()&&!_new.equals(old));
    }
    static boolean accept(LocalDate old, LocalDate _new){
        if (_new ==null)return false;
        return (!_new.equals(old));
    }
    public Applyer<Boolean> ifValid(Boolean old, Boolean _new){
        return new Applyer<>(_new,accept(old,_new));
    }
    public Applyer<Short> ifValid(Short old, Short _new){
        return new Applyer<>(_new,accept(old,_new));
    }
    public Applyer<Integer> ifValid(Integer old,Integer _new){
        return new Applyer<>(_new,accept(old,_new));
    }
    public Applyer<Long> ifValid(Long old,Long _new){
        return new Applyer<>(_new,accept(old,_new));
    }
    public Applyer<Float> ifValid(Float old, Float _new){
        return new Applyer<>(_new,accept(old,_new));
    }
    public Applyer<Double> ifValid(Double old, Double _new){
        return new Applyer<>(_new,accept(old,_new));
    }
    public Applyer<String> ifValid(String old, String _new){
        return new Applyer<>(_new,accept(old,_new));
    }
    public Applyer<LocalDate> ifValid(LocalDate old,LocalDate _new){
        return new Applyer<>(_new,accept(old,_new));
    }

}
