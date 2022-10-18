package blockchain;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String filename = "blockchain.data";

        Blockchain blockchain = null;
        if (new File(filename).isFile()) {
            blockchain = (Blockchain) SerializationUtils.deserialize(filename);
        }
        if (blockchain == null) {
            blockchain = new Blockchain();
        }


        blockchain.init();

        blockchain.create();
        SerializationUtils.serialize(blockchain, filename);

        blockchain.create();
        SerializationUtils.serialize(blockchain, filename);

        blockchain.create();
        SerializationUtils.serialize(blockchain, filename);

        blockchain.create();
        SerializationUtils.serialize(blockchain, filename);

        blockchain.create();
        SerializationUtils.serialize(blockchain, filename);

        blockchain.check();
    }
}
