package Query;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Writer {
    public static Writer writer = null;

    private Writer() {

    }

    public static Writer getWriter() {
        if (writer == null)
            writer = new Writer();
        return writer;
    }

    public void Clear(String path) throws IOException {
        FileWriter file = new FileWriter(path);
        BufferedWriter write = new BufferedWriter(file);
        write.close();
    }

    public void Write(String path, String message) throws IOException {
        FileWriter file = new FileWriter(path, true);
        BufferedWriter write = new BufferedWriter(file);
        write.write(message);
        write.close();
    }
}
