package ie.atu.week5_concurrency;

import org.apache.commons.io.input.TaggedInputStream;
import org.springframework.stereotype.Service;

@Service
public class FeignService {

    private final TodoClient todoClient;

    public FeignService(TodoClient todoClient) {
        this.todoClient = todoClient;
    }

    public TodoResponse fetchData() {
        TodoResponse td = todoClient.fetchData();
        System.out.println(td);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return td;
    }

}
