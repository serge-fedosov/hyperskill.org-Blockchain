package blockchain;

import java.io.Serializable;
import java.util.*;

public class Blockchain implements Serializable {

    public int n;
    public final List<Block> bc = new ArrayList<>();

    public void check() {
        for (int i = bc.size() - 5; i < bc.size(); i++) {
            System.out.println(bc.get(i));
        }
    }

    public void create() {
        Block block = new Block();

        long time1 = new Date().getTime();
        block.setTimestamp(time1);
        if (bc.size() == 0) {
            block.setId(0);
            block.setHashPrev("0");
        } else {
            Block prevBlock = bc.get(bc.size() - 1);

            block.setId(prevBlock.getId() + 1);
            block.setHashPrev(prevBlock.getHash());
        }

        String start = "";
        for (int i = 0; i < n; i++) {
            start += "0";
        }

        final Random random = new Random();

        boolean stop = false;
        do {

            block.setNumber(random.nextInt(Integer.MAX_VALUE));

            long time2 = new Date().getTime();
            block.setTime((int) ((time2 - time1) / 1000));
            block.setHash(StringUtil.applySha256(block.getId() + block.getTimestamp() + block.getHashPrev() +
                    block.getNumber() + block.getTime()));

            if (block.getHash().startsWith(start)) {
                stop = true;
            }
        } while (!stop);

        bc.add(block);
    }

    public void init() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter how many zeros the hash must start with: ");
        n = Integer.parseInt(scanner.nextLine());
        System.out.println();
    }
}
