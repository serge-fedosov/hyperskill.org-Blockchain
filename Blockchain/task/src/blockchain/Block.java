package blockchain;

public class Block {
    private int id;
    private long timestamp;
    private String hashPrev;
    private String hash;

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

    @Override
    public String toString() {
        return "Block:" +
                "\nId: " + id +
                "\nTimestamp: " + timestamp +
                "\nHash of the previous block:\n" + hashPrev +
                "\nHash of the block:\n" + hash +
                "\n";
    }
}
