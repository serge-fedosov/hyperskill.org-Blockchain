package blockchain;

import java.io.Serializable;
import java.util.Date;
import java.util.Random;

public class Block implements Serializable {
    private int id;
    private long timestamp;
    private String hashPrev;
    private String hash;
    private int number;
    private int time;
    private int miner;
    private String n;

    public Block() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getHashPrev() {
        return hashPrev;
    }

    public void setHashPrev(String hashPrev) {
        this.hashPrev = hashPrev;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getMiner() {
        return miner;
    }

    public void setMiner(int miner) {
        this.miner = miner;
    }

    public String getN() {
        return n;
    }

    public void setN(String n) {
        this.n = n;
    }

    @Override
    public String toString() {
        return "Block:" +
                "\nCreated by miner # " + miner +
                "\nId: " + id +
                "\nTimestamp: " + timestamp +
                "\nMagic number: " + number +
                "\nHash of the previous block:\n" + hashPrev +
                "\nHash of the block:\n" + hash +
                "\nBlock was generating for " + time + " seconds" +
                "\n" + n + "\n";
    }

    public void generate(int miner, Blockchain bc, int num) {
        long time1 = new Date().getTime();
        setTimestamp(time1);
        if (bc.getSize() == 0) {
            setId(0);
            setHashPrev("0");
        } else {
            Block prevBlock = bc.getBlock(bc.getSize() - 1);

            setId(prevBlock.getId() + 1);
            setHashPrev(prevBlock.getHash());
        }

        setMiner(miner);

        String start = "";
        for (int i = 0; i < bc.getN(); i++) {
            start += "0";
        }

        final Random random = new Random();

        boolean stop = false;
        do {

            setNumber(random.nextInt(Integer.MAX_VALUE));

            long time2 = new Date().getTime();
            setTime((int) ((time2 - time1) / 1000));
            setHash(StringUtil.applySha256(getId() + getTimestamp() + getHashPrev() + getNumber() + getTime()));

            if (getHash().startsWith(start)) {
                stop = true;
            }
            if (bc.getSize() >= num) {
                stop = true;
            }

//            System.out.println("miner " + miner);
        } while (!stop);

    }
}
