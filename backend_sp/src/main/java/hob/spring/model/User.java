package hob.spring.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

/*
 * Document 란 해당 클래스가 몽고DB 에서 문서로서 매핑됨을 의미
 * Collection 은 데이터베이스에서 테이블 역활
 */
@Document(collection = "user")
public class User {

    @Id
    private String id;
    private String name;
    private String sex;
    private String age;
    private String mail;
    private ArrayList<Hob> hobList;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public ArrayList<Hob> getHobList() {
        return hobList;
    }

    public void setHobList(ArrayList<Hob> hobList) {
        this.hobList = hobList;
    }
}
