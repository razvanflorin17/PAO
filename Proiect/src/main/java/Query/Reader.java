package Query;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Reader {
    private static Reader reader = null;

    private Reader() {

    }

    public static Reader getReader() {
        if(reader == null)
            reader = new Reader();
        return reader;
    }

    public ArrayList<ArrayList<String>> Read(String path) throws FileNotFoundException {
        ArrayList<ArrayList<String>> data = new ArrayList<>();
        File file = new File(path);
        Scanner reader = new Scanner(file);
        while(reader.hasNextLine()) {
            String info = reader.nextLine();
            data.add(new ArrayList<>(Arrays.asList(info.split(","))));
        }

        return (ArrayList<ArrayList<String>>) new ArrayList<>(data);
    }
}
