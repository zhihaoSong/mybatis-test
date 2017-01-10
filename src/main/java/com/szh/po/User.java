package com.szh.po;

import java.util.Date;

public class User {
    private Integer id;

    private String user_name;

    private Date birthday;

    private String sex;

    private String email;

    private String mobile;

    private String note;

    private Date create_date;

    private Date update_date;

    public User(Integer id, String user_name, Date birthday, String sex, String email, String mobile, String note, Date create_date, Date update_date) {
        this.id = id;
        this.user_name = user_name;
        this.birthday = birthday;
        this.sex = sex;
        this.email = email;
        this.mobile = mobile;
        this.note = note;
        this.create_date = create_date;
        this.update_date = update_date;
    }

    public User() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name == null ? null : user_name.trim();
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    public Date getUpdate_date() {
        return update_date;
    }

    public void setUpdate_date(Date update_date) {
        this.update_date = update_date;
    }
}