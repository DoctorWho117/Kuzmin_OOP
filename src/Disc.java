import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

public class Disc {

    private Path path = Path.of("Collection.txt");
    private String name;
    private String type;
    private String category;
    public String description;
    private List<String> CollectionNames;
    int idDisc;

    public Disc(String name, String type, String category, String description) {
        this.name = name;
        this.type = type;
        this.category = category;
        this.description = description;
    }

    public List<String> getName(){
        try {
            if (!Files.exists(path)) {
                Files.createFile(path);
            }
            CollectionNames = Files.readAllLines(path);
            idDisc = CollectionNames.size();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return CollectionNames;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void deleteDisc (int id) throws IOException {
        Files.delete(Path.of("Disc\\" + CollectionNames.get(id - 1) + ".txt"));
        CollectionNames.remove(id - 1);
        Files.write(path, CollectionNames);
    }

    public void saveCD() throws IOException {
        CollectionNames.add(this.name);
        Files.write(path, CollectionNames);
        Path cd = Path.of("Disc\\" + this.name + ".txt");
        Files.createFile(cd);
        Files.write(cd, Arrays.asList(this.name, this.type, this.category, this.description));
    }

    public List<String> showDiscInfo(int id) throws IOException {
        List<String> cdInfo = Files.readAllLines(Path.of("Disc\\" + CollectionNames.get(id-1) + ".txt"));
        return cdInfo;
    }
}
