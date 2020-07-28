package hob.spring.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

/*
 * Document 란 해당 클래스가 몽고DB 에서 문서로서 매핑됨을 의미
 * Collection 은 데이터베이스에서 테이블 역활
 */

@Document(collection = "hobtype")
class HobType (
    @Id
    var id: Int,
    var title: String,
    var desc: String
)