//package io.example.library.config.database.mongo;
//
//import com.mongodb.client.MongoClient;
//import com.mongodb.client.MongoClients;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.mongodb.MongoDatabaseFactory;
//import org.springframework.data.mongodb.core.MongoTemplate;
//import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;
//import org.springframework.data.mongodb.core.convert.DefaultDbRefResolver;
//import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
//import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
//import org.springframework.data.mongodb.core.mapping.MongoMappingContext;
//
//@Configuration
//@Slf4j
//public class MongoConfiguration{
//
//    @Value("${spring.mongo.uri}")
//    private String uri;
//
////    @Value("${spring.mongo.host}")
////    private String host;
////
////    @Value("${spring.mongo.port}")
////    private String port;
////
//    @Value("${spring.mongo.database}")
//    private String database;
////
////    @Value("${spring.mongo.username}")
////    private String username;
////
////    @Value("${spring.mongo.password}")
////    private String password;
//
//    @Bean(name = "mongoTemplate")
//    public MongoTemplate createMongoTemplate()  {
////        String ttt = "mongodb" + "://" + ;
//
//        MongoClient mongoClient = MongoClients.create(uri);
//        MongoDatabaseFactory mongoDatabaseFactory = new SimpleMongoClientDatabaseFactory(mongoClient, database);
//        MappingMongoConverter mappingMongoConverter = new MappingMongoConverter(new DefaultDbRefResolver(mongoDatabaseFactory), new MongoMappingContext());
//        mappingMongoConverter.setTypeMapper(new DefaultMongoTypeMapper(null));
//
//        return new MongoTemplate(mongoDatabaseFactory, mappingMongoConverter);
//    }
//}
