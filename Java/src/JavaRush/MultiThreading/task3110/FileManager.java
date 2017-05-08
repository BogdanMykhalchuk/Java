package JavaRush.MultiThreading.task3110;

import JavaRush.MultiThreading.task3110.exception.WrongZipFileException;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class FileManager {
    private Path rootPath;
    private List<Path> fileList;

    public FileManager(Path rootPath) throws IOException {
        this.rootPath = rootPath;
        this.fileList = new ArrayList<>();
        collectFileList(rootPath);
    }

    public List<Path> getFileList() {
        return fileList;
    }

    private void collectFileList(Path path) throws IOException {
        // Добавляем только файлы
        if (Files.isRegularFile(path)) {
            Path relativePath = rootPath.relativize(path);
            fileList.add(relativePath);
        }

        // Добавляем содержимое директории
        if (Files.isDirectory(path)) {
            // Рекурсивно проходимся по всему содержмому директории
            // Чтобы не писать код по вызову close для DirectoryStream, обернем вызов newDirectoryStream в try-with-resources
            try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(path)) {
                for (Path file : directoryStream) {
                    collectFileList(file);
                }
            }
        }
    }

    public List<FileProperties> getFilesList() throws Exception {
        if(!Files.isRegularFile(rootPath)) {
            throw new WrongZipFileException();
        }
        List<FileProperties> list = new ArrayList<>();
        try(ZipInputStream zipInputStream = new ZipInputStream(Files.newInputStream(rootPath))) {
            ZipEntry zipEntry = zipInputStream.getNextEntry();
            while(zipEntry != null) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                ZipFileManager zipFileManager = new ZipFileManager(rootPath);
                zipFileManager.copyData(zipInputStream, byteArrayOutputStream);

            }
        }
        return list;
    }
}
