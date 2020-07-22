package hob.spring.config;

import com.mongodb.MongoClientSettings;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;

import static java.util.Collections.singletonList;

@Configuration
public class MongoConfiguration extends AbstractMongoClientConfiguration {

    @Value("${spring.data.mongodb.username}")     //application.properties에서 정의한 MongoDB에 계정 아이디
    private String userName;


    @Value("${spring.data.mongodb.password}")    //application.properties에서 정의한 MongoDB에 계정 비밀번호
    private String password;


    @Value("${spring.data.mongodb.database}") //application.properties에서 정의한 MongoDB에있는 데이터베이스
    private String database;

    @Override
    protected String getDatabaseName() {
        return database;
    }

    @Override
    protected void configureClientSettings(MongoClientSettings.Builder builder) { // Client Configure

        builder
                .credential(MongoCredential.createCredential(userName, database, password.toCharArray()))
                .applyToClusterSettings(settings  -> {
                    settings.hosts(singletonList(new ServerAddress("127.0.0.1", 27017)));
                });
    }

}
