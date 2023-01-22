import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

public class TypeDisc {
    private Path path = Path.of("Types.txt");
    private List<String> typeDisc;
    protected int idType;
    public List<String> getType() throws IOException {
        try {
            if (!Files.exists(path)) {
                Files.createFile(path);
                Files.write(path, Arrays.asList("DVD", "CD-R", "mini-disc"));
            }
            typeDisc = Files.readAllLines(path);
            idType = typeDisc.size();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return this.typeDisc;
    }

    public void deleteType (int id) throws IOException {
        typeDisc.remove(id - 1);
        Files.write(path, typeDisc);
    }

    public void addType(String name) throws IOException {
        typeDisc.add(name);
        Files.write(path, typeDisc);
    }

    public void updateType(int id, String name) throws IOException {
        typeDisc.set(id-1,name);
        Files.write(path, typeDisc);
    }
}
