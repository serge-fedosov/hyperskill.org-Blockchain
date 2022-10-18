package blockchain;

import java.io.Serializable;

public class Block implements Serializable {
    private int id;
    private long timestamp;
    private String hashPrev;
    private String hash;
    private int number;
    private int time;

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

    @Override
    public String toString() {
        return "Block:" +
                "\nId: " + id +
                "\nTimestamp: " + timestamp +
                "\nMagic number: " + number +
                "\nHash of the previous block:\n" + hashPrev +
                "\nHash of the block:\n" + hash +
                "\nBlock was generating for " + time + " seconds\n";
    }
}
