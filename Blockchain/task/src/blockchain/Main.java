package blockchain;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        final String filename = "blockchain.data";
        final Blockchain blockchain = SerializationUtils.deserialize(filename);;

        ExecutorService executor = Executors.newFixedThreadPool(5);
        int num = blockchain.getSize() + 5;

        for (int i = 0; i < 5; i++) {
            int miner = i;
            executor.submit(() -> {
                while (blockchain.getSize() < num) {
                    Block block = new Block();
                    block.generate(miner, blockchain, num);
                    blockchain.add(block);
                    try {
                        SerializationUtils.serialize(blockchain, filename);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
        }

//        while (blockchain.getSize() < num) {
//            Thread.sleep(100);
//        }
        executor.awaitTermination(10, TimeUnit.SECONDS);

        blockchain.check();
        executor.shutdownNow();
    }
}
