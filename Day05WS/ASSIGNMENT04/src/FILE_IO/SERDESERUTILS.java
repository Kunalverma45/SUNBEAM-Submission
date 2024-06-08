package FILE_IO;

import java.io.*;
import java.util.List;

public interface SERDESERUTILS {
    static void serializeStudents(List<STUDENT> students, String fileName) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(students);
        }
    }

    @SuppressWarnings("unchecked")
    static List<STUDENT> deserializeStudents(String fileName) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            return (List<STUDENT>) ois.readObject();
        }
    }
}
