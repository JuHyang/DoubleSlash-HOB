package hob.spring.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

/*
 * Document 란 해당 클래스가 몽고DB 에서 문서로서 매핑됨을 의미
 * Collection 은 데이터베이스에서 테이블 역활
 */
@Document(collection = "hob")
public class Hob {

    @Id
    private String id;
    private String link;
    private String desc;
    private String descDetail;
    private ArrayList<HobType> hobTypeList;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDescDetail() {
        return descDetail;
    }

    public void setDescDetail(String descDetail) {
        this.descDetail = descDetail;
    }

    public ArrayList<HobType> getHobTypeList() {
        return hobTypeList;
    }

    public void setHobTypeList(ArrayList<HobType> hobTypeList) {
        this.hobTypeList = hobTypeList;
    }

}
