
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.Hazelcast;

import java.util.Map;

public class HazelcastMain {

    public static void main(String[] args) {
        HazelcastInstance hz = Hazelcast.newHazelcastInstance();
        Map<Integer, Person> map = hz.getMap("map");

        for(int i = 0; i <10000;i++)
            map.put(i, new Person("Alper-" + i));

        for (int i = 0; i < 10000; i++) {
            System.out.println(map.get(i).name);
        }

        Hazelcast.shutdownAll();
    }
}
