import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializableApp implements Serializable {
    private static final long serialVersionUID = 1L;

    private int pointing_mode;

    public SerializableApp(int pointing_mode) {
        this.pointing_mode = pointing_mode;
    }

    public static void main(String[] args) {
        // Create an object with PointingMode set to "Sun Point Mode"
        SerializableApp app = new SerializableApp(1);

        // Serialize the object
        serializeObject(app);

        System.out.println("Object has been serialized.");
    }

    private static void serializeObject(SerializableApp object) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("serializedObject.ser"))) {
            oos.writeObject(object);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
