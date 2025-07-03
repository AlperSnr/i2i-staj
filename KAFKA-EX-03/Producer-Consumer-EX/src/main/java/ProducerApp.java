import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import java.util.Properties;
import com.fasterxml.jackson.databind.ObjectMapper;


public class ProducerApp {
    public static final String TOPIC = "topic-1";

    public static void main(String[] args) {

        System.out.println("*** Starting Basic Producer ***");

        Properties props = new Properties();
        props.put(ProducerConfig.CLIENT_ID_CONFIG,"basic-producer");
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());


        try (KafkaProducer<String, String> producer = new KafkaProducer<>(props)) {
            Student student = new Student(101, "Alper Cemal Sener");

            ObjectMapper mapper = new ObjectMapper();

            try {
                String studentJson = mapper.writeValueAsString(student);
                ProducerRecord<String, String> record = new ProducerRecord<>(TOPIC, studentJson);
                producer.send(record);
                //System.out.println("Sent Student: " + student);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }

        }
    }
}
