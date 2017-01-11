package com.szh.po;

/**
 * Created by zhihaosong on 17-1-11.
 */
public enum Sex {
    MALE(1, "男"),
    FEMALE(2, "女");

    private int id;
    private String name;

    Sex(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static Sex getSex(int id) {
        switch (id) {
            case 1:
                return MALE;
            case 2:
                return FEMALE;
        }
        return null;
    }

    @Override
    public String toString() {
        return "Sex{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public static void main(String[] args) {
        System.out.println(Sex.getSex(3));
    }
}
