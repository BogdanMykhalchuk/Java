package JavaRush.Collection.task3111;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class SearchFileVisitor extends SimpleFileVisitor<Path> {

    private String partOfName;
    private String partOfContent;
    private int minSize;
    private int maxSize;
    private List<Path> foundFiles = new ArrayList<>();

    public String getPartOfName() {
        return partOfName;
    }

    public void setPartOfName(String partOfName) {
        this.partOfName = partOfName;
    }

    public String getPartOfContent() {
        return partOfContent;
    }

    public void setPartOfContent(String partOfContent) {
        this.partOfContent = partOfContent;
    }

    public int getMinSize() {
        return minSize;
    }

    public void setMinSize(int minSize) {
        this.minSize = minSize;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public List<Path> getFoundFiles() {
        return foundFiles;
    }

    public void setFoundFiles(List<Path> foundFiles) {
        this.foundFiles = foundFiles;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {

        if(partOfName != null) {
            if(file.toFile().getName().contains(partOfName)) {
                foundFiles.add(file);
            }
        }
        if(partOfContent != null) {
            try (BufferedReader br = new BufferedReader(new FileReader(file.toFile()))) {
                String content = br.readLine();
                while (content != null) {
                    if (content.contains(partOfContent) && !foundFiles.contains(file)) {
                        foundFiles.add(file);
                    }
                    content = br.readLine();
                }
            }
        }
        if(minSize > 0) {
            if(file.toFile().length() > minSize && !foundFiles.contains(file)) {
                foundFiles.add(file);
            }
        }
        if(maxSize > 0) {
            if(file.toFile().length() < maxSize && !foundFiles.contains(file)) {
                foundFiles.add(file);
            }
        }
        return super.visitFile(file, attrs);
    }
}
