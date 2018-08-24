package com.example.root.myapplication;

/**
 * Created by root on 7/30/18.
 */

public class ItemBean {
    private String name;
    private int num;

    public ItemBean(String name, int num) {
        this.name = name;
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
