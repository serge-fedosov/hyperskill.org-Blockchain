package blockchain;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        final String filename = "blockchain.data";
        final Blockchain blockchain = SerializationUtils.deserialize(filename);;

        ExecutorService executor = Executors.newFixedThreadPool(15);
        int num = blockchain.getSize() + 15;

        for (int i = 0; i < 15; i++) {
            int miner = i;
            executor.submit(() -> {
                while (blockchain.getSize() < num) {
                    Block block = new Block();
                    block.generate(miner, blockchain, num);
                    block.setData("Message " + miner);
//                    blockchain.addMessage("Message " + miner);
//                    block.setData(blockchain.getMessage());
//                    blockchain.clearMessage();
                    blockchain.add(block);
                    try {
                        SerializationUtils.serialize(blockchain, filename);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
        }

        executor.awaitTermination(14, TimeUnit.SECONDS);

        blockchain.check();
        executor.shutdownNow();
    }
}
