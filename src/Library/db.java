package Library;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class db<T> {
    private String name;
    private ArrayList<T> list = new ArrayList<T>();
    
    public db(String name){
        this.name = name;
        
    }
    
    public void add(T toAdd){
        list.add(toAdd);
    }

    public void Save() {
        try (FileOutputStream fos = new FileOutputStream("src/"+ this.name + ".bin");
                ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(this.list);
            System.out.println("Save Success!");
        } catch (IOException e) {
            //            e.printStackTrace();
            System.out.println("Save Error!");
        }
    }
    
   @SuppressWarnings("unchecked")
    public void Load() {
        ArrayList<T> list = new ArrayList<>();
        try (FileInputStream fis = new FileInputStream("src/"+ this.name + ".bin");
                ObjectInputStream ois = new ObjectInputStream(fis)) {
                    list = (ArrayList<T>) ois.readObject();
                    System.out.println("Load Success!");
                } catch (IOException | ClassNotFoundException e) {
                    //            e.printStackTrace();
                    System.out.println("Load Error!");
        }
        this.list = list;
    }
    public ArrayList<T> getList(){
        return this.list;
    }
}