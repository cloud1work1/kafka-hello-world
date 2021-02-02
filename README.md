# kafka-hello-world
used javainuse example
# Steps
- ## Started zookeeper => bin\windows\zookeeper-server.bat ..\\..\config\zookeeper.properties
- ## Started kafka server => bin\windows\kafka-server.bat ..\\..\config\server.properties
- ## code KafkaTemplate<String,String> template; template.send("topic-name", "message to send")
- ## Start Kafka consumer => bin\windows\kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic topic-name --from-beginning
