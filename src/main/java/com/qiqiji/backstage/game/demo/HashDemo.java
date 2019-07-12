package com.qiqiji.backstage.game.demo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;

public class HashDemo {
    public static void main(String[] args) {
        Hashtable<Object, Object> ht = new Hashtable<>();
        ht.put("1","你好");
        ht.put("1","你好de");
        System.out.println(ht.get("1"));
        System.out.println(ht.size());
        System.out.println("----------------");
        HashMap<Object, Object> hm = new HashMap<>();
        hm.put("1","你好");
        hm.put("1","你好de");
        System.out.println(hm.get("1"));
        System.out.println(hm.size());
        System.out.println("----------------");
        HashSet<Object> hs = new HashSet<>();
        hs.add("你好");
        hs.add("你好de");
        System.out.println(hs.size());
        System.out.println(hs.toString());

        StringBuilder sb = new StringBuilder();
    }
}
