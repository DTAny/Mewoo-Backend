package com.github.dtanything.mewoobackend.utils;

import java.util.HashMap;
import java.util.Map;

public class Hjq {
    private Map<String, Object> res;

    public Hjq(){
        res = new HashMap<>();
    }

    public Hjq(Map<String, Object> res){
        this.res = res;
    }

    public Hjq add(String K, Object V){
        res.put(K, V);
        return this;
    }
    public Hjq remove(String K){
        res.remove(K);
        return this;
    }
    public Map<String, Object> getRes(){
        return res;
    }
}
