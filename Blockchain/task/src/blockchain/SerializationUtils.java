package blockchain;

import java.io.*;

public class SerializationUtils {
    /**
     * Serialize the given object to the file
     */
    public static void serialize(Object obj, String fileName) throws IOException {
        try {
            FileOutputStream fos = new FileOutputStream(fileName);
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(obj);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Deserialize to an object from the file
     */
    public static Blockchain deserialize(String fileName) throws IOException, ClassNotFoundException {
        try {
            if (new File(fileName).isFile()) {
                FileInputStream fis = new FileInputStream(fileName);
                BufferedInputStream bis = new BufferedInputStream(fis);
                ObjectInputStream ois = new ObjectInputStream(bis);
                Blockchain obj = (Blockchain) ois.readObject();
                ois.close();
                return obj;
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return new Blockchain();
    }
}