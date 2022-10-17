package blockchain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Blockchain {

    public final List<Block> bc = new ArrayList<>();

    public void check() {
        for (var element: bc) {
            System.out.println(element);
        }
    }

    public void create() {
        Block block = new Block();

        block.setTimestamp(new Date().getTime());
        if (bc.size() == 0) {
            block.setId(0);
            block.setHashPrev("0");
        } else {
            Block prevBlock = bc.get(bc.size() - 1);

            block.setId(prevBlock.getId() + 1);
            block.setHashPrev(prevBlock.getHash());
        }

        block.setHash(StringUtil.applySha256(block.getId() + block.getTimestamp() + block.getHashPrev()));
        bc.add(block);
    }
}
