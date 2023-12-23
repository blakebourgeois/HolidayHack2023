import java.io.*;

public class SerializationExample {

    public static void main(String[] args) {
        // Create an instance of SatelliteQueryFileFolderUtility
        SatelliteQueryFileFolderUtility utility = new SatelliteQueryFileFolderUtility("UPDATE pointing_mode SET numerical_mode = 1 WHERE id = 1;", true, true);

        // Serialize the object to a file
        serializeToFile(utility, "serializedObjectUpdate.ser");

        // Deserialize the object from the file
        SatelliteQueryFileFolderUtility deserializedUtility = deserializeFromFile("serializedObjectUpdate.ser");

        // Use the deserialized object
        System.out.println("Deserialized pathOrStatement: " + deserializedUtility.getpathOrStatement());
    }

    private static void serializeToFile(Object object, String fileName) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
            outputStream.writeObject(object);
            System.out.println("Serialization successful. Object saved to " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static SatelliteQueryFileFolderUtility deserializeFromFile(String fileName) {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName))) {
            Object object = inputStream.readObject();
            if (object instanceof SatelliteQueryFileFolderUtility) {
                return (SatelliteQueryFileFolderUtility) object;
            } else {
                throw new RuntimeException("Invalid object type found during deserialization.");
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
