#Spring Cloud Data Flow example

Example project using SCDF server. 

TODO: Clean up readme :) 

## Register the application

    app register --name time-source --type source --uri maven://com.example.scdf:dataflow-source:jar:1.0-SNAPSHOT
    app register --name time-processor --type processor --uri maven://com.example.scdf:dataflow-processor:jar:1.0-SNAPSHOT
    app register --name logging-sink --type sink --uri maven://com.example.scdf:dataflow-sink:jar:1.0-SNAPSHOT
   
    app register --name streamTaskSink --type sink --uri maven://com.example.scdf:stream-task:jar:1.0-SNAPSHOT
 
    
    stream create --name time-to-log --definition 'time-source | time-processor | logging-sink'
    
    
Notes

Trying to get the pose estimation working 
No luck so far

https://content.pivotal.io/blog/making-data-science-accessible-to-developers-real-time-multi-person-human-pose-estimation-with-spring-cloud-data-flow-and-tensorflow


java -jar spring-cloud-dataflow-server-local-1.6.3.RELEASE.jar \
--spring_datasource_url=jdbc:mysql://localhost:3306/dataflow \
--spring_datasource_username=root \
--spring_datasource_password=rootpw \
--spring_datasource_driver-class-name=org.mariadb.jdbc.Driver

    
    http --server.port=9000 --spring.cloud.stream.bindings.output.contentType=application/json | cassandra --keyspace=clouddata --contact-points=cassandra0 --ingest-query='insert into book (id, isbn, title, author) values (uuid(), ?, ?, ?)'
    
    http post --contentType 'application/json' --data '{"isbn": "1599869772", "title": "The Art of War", "author": "Sun Tzu"}' --target http://localhost:9000
    
    
        http --port=9001 | tasklaunchrequest-transform --data-source-driver-class-name=com.mysql.jdbc.Driver --data-source-url=jdbc:mysql://mysql:3306/dataflow --data-source-user-name=root --uri=maven://com.example.scdf:simple-task:1.0-SNAPSHOT --data-source-password='rootpw' | task-launcher-local