# kafka-hello-world
used javainuse example
# Steps
- ## Started zookeeper => bin\windows\zookeeper-server.bat ..\\..\config\zookeeper.properties
- ## Started kafka server => bin\windows\kafka-server.bat ..\\..\config\server.properties
- ## code KafkaTemplate<String,String> template; template.send("topic-name", "message to send")
- ## Start Kafka consumer => bin\windows\kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic topic-name --from-beginning
- ## Program based creation of KafkaAdmin, KafkaProducer
  `
    @Configuration
    
    public class KafkaTopicConfig {
    
    @Value("${spring.kafka.bootstrapServers}")
   
   private String bootstrapserver;
    
    @Bean
    
    public KafkaAdmin kafkaAdmin() {
    
     Map<String,Object> configMap = new HashMap<>();
     
     configMap.put(AdminClientConfig.BOOTSTRAP_SERVER_CONFIG, bootstrapserver);
     
     return new KafkaAdmin(configMap);
     
    }
    
    @Bean
    
    public NewTopic newTopic() {
    
     return new NewTopic("PROG-TOPIC-NAME", 1, (short) 1);
    }
    
    }
  
  `
  `
      @Configuration
      
      public class KafkaProducerConfig {
      
       @Value("${spring.kafka.bootstrap-servers}")
       private String bootstrapServer;
       
       @Bean
       
       public ProducerFactory<String,String> producerFactory() {
       
       Map<String,Object> config = new HashMap<>();
       config.put(ProducerConfig.BOOTSTRAP_SERVER_CONFIG, bootstrapServer);
       config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
       config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
       return new DefaultKafkaProducerFactory<>(config);
       }
       
       @Bean
       
       public KafkaTemplate<String,String> kafkaTemplate() {
       
        return new KafkaTemplate<>(producerFactory());
       }
      
      }
  `
