package hob.spring.config

import com.mongodb.MongoClientSettings
import com.mongodb.MongoCredential
import com.mongodb.ServerAddress
import com.mongodb.connection.ClusterSettings
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration

@Configuration
class MongoConfiguration : AbstractMongoClientConfiguration() {
    @Value("\${spring.data.mongodb.username}") //application.properties에서 정의한 MongoDB에 계정 아이디
    private val userName: String? = null

    @Value("\${spring.data.mongodb.password}") //application.properties에서 정의한 MongoDB에 계정 비밀번호
    private val password: String? = null

    @Value("\${spring.data.mongodb.database}") //application.properties에서 정의한 MongoDB에있는 데이터베이스
    private val database: String? = null
    override fun getDatabaseName(): String {
        return database!!
    }

    override fun configureClientSettings(builder: MongoClientSettings.Builder) { // Client Configure
        builder
                .credential(MongoCredential.createCredential(userName!!, database!!, password!!.toCharArray()))
                .applyToClusterSettings { settings: ClusterSettings.Builder -> settings.hosts(listOf(ServerAddress("127.0.0.1", 27017))) }
    }
}