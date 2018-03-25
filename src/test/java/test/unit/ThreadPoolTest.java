package test.unit;

import com.github.wotchin.ThreadPool;
import org.junit.jupiter.api.Test;

class ThreadPoolTest {

    @Test
    void getInstance(){
        for(int i =0;i<100;i++){
            new Thread(
                    ()->{
                        ThreadPool pool = ThreadPool.getInstance();
                        System.out.println(pool.hashCode());
                    }
            ).start();
        }
    }
}
