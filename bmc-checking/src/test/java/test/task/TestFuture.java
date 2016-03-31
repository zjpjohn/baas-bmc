package test.task;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by xin on 16-3-30.
 */
public class TestFuture {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        List<Future<Integer>> allResult = new ArrayList<Future<Integer>>();

        CountDownLatch countDownLatch = new CountDownLatch(10);
        for (int i = 0; i < 10; i++) {
            Future<Integer> future = executorService.submit(new TestTask(countDownLatch));
            allResult.add(future);
        }

        countDownLatch.await();
        int sum = 0;
        for (Future<Integer> integerFuture : allResult) {
            sum += integerFuture.get();
        }
        executorService.shutdown();
        System.out.println("==" + sum);
    }

    public static class TestTask implements Callable<Integer> {
        private CountDownLatch countDownLatch;

        public TestTask(CountDownLatch countDownLatch) {
            this.countDownLatch = countDownLatch;
        }

        @Override
        public Integer call() throws Exception {
            int result = ThreadLocalRandom.current().nextInt(1, 10);
            Thread.sleep(result * 100);
            System.out.println(result);
            countDownLatch.countDown();
            return result;
        }
    }
}
