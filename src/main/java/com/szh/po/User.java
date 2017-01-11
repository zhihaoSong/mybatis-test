package com.szh.po;

import org.apache.ibatis.type.Alias;

import java.util.Date;

@Alias("user")
public class User {
    private Integer id;

    private String userName;

    private Date birthday;

    private Sex sex;

    private String email;

    private String mobile;

    private String note;

    private Date create_date;

    private Date update_date;

    public User(Integer id, String userName, Date birthday, Sex sex, String email, String mobile, String note, Date create_date, Date update_date) {
        this.id = id;
        this.userName = userName;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex ;
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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", birthday=" + birthday +
                ", sex='" + sex + '\'' +
                ", email='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
                ", note='" + note + '\'' +
                ", create_date=" + create_date +
                ", update_date=" + update_date +
                '}';
    }
}