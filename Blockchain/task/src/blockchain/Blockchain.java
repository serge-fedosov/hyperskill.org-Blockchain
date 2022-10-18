package blockchain;

import java.io.Serializable;
import java.util.*;

public class Blockchain implements Serializable {

    private int n = 0;
    private final List<Block> bc = new ArrayList<>();
    private final List<String> message = new ArrayList<>();

    public String getMessage() {
        String result = "";
        for (var str: message) {
            result += "\n" + str;
        }
        return result;
    }

    public void addMessage(String str) {
        message.add(str);
    }

    public void clearMessage() {
        message.clear();
    }

    public void check() {
        for (int i = bc.size() - 5; i < bc.size(); i++) {
            System.out.println(bc.get(i));
        }
    }

    synchronized public void add(Block block) {
        int size = bc.size();
        if (size != 0) {
            Block prevBlock = bc.get(size - 1);
            if (!block.getHashPrev().equals(prevBlock.getHash())) {
                return;
            }
        }

        String start = "";
        for (int i = 0; i < n; i++) {
            start += "0";
        }
        if (!block.getHash().startsWith(start)) {
            return;
        }

        int t = block.getTime();
        if (t < 10) {
            n++;
            block.setN("N was increased to " + n);
        } else if (t > 60) {
            n--;
            block.setN("N was decreased by 1");
        } else {
            block.setN("N stays the same");
        }

        bc.add(block);
    }

    public int getSize() {
        return bc.size();
    }

    public Block getBlock(int n) {
        return bc.get(n);
    }

    public int getN() {
        return n;
    }
}
