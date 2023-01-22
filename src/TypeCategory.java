import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

public class TypeCategory {
    private Path path = Path.of("Category.txt");
    private List<String> typeCategory;
    protected int idCategory;
    public List<String> getCategory() throws IOException {
        try {
            if (!Files.exists(path)) {
                Files.createFile(path);
                Files.write(path, Arrays.asList("Фильм", "Музыка", "ПО", "Игра", "Сериал"));
            }
            typeCategory = Files.readAllLines(path);
            idCategory = typeCategory.size();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return this.typeCategory;
    }

    public void deleteCategory (int id) throws IOException {
        typeCategory.remove(id - 1);
        Files.write(path, typeCategory);
    }

    public void addCategory(String name) throws IOException {
        typeCategory.add(name);
        Files.write(path, typeCategory);
    }

    public void updateCategory(int id, String name) throws IOException {
        typeCategory.set(id-1,name);
        Files.write(path, typeCategory);
    }
}
