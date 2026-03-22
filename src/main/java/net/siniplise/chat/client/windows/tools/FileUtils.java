package net.siniplise.chat.client.windows.tools;

import org.tinylog.Logger;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.List;

public class FileUtils {

    /**
     * 检测文件是否存在且可读
     */
    public static boolean isValidFile(String filePath) {
        Path path = Paths.get(filePath);
        Logger.info("Validating file: " + path);
        return Files.exists(path) && Files.isRegularFile(path) && Files.isReadable(path);
    }

    /**
     * 读取文件全部内容到字符串
     */
    public static String readFileContent(String filePath) throws IOException {
        Path path = Paths.get(filePath);
        if (!Files.exists(path)) {
            Logger.error("File not found: " + path);
            throw new NoSuchFileException("No Such File as:" + filePath);
        }
        Logger.info("Reading file: " + path);
        return Files.readString(path, StandardCharsets.UTF_8);
    }

    /**
     * 写入内容 (覆盖模式)，自动创建父目录
     */
    public static void writeFile(String filePath, String content) throws IOException {
        Path path = Paths.get(filePath);
        Files.createDirectories(path.getParent()); // 确保目录存在
        Files.writeString(path, content, StandardCharsets.UTF_8,
                StandardOpenOption.CREATE,
                StandardOpenOption.TRUNCATE_EXISTING);
        Logger.info("Writing file: " + filePath);
    }

    /**
     * 追加内容到文件
     */
    public static void appendToFile(String filePath, String content) throws IOException {
        Path path = Paths.get(filePath);
        Files.createDirectories(path.getParent());
        Files.writeString(path, content + System.lineSeparator(),
                StandardOpenOption.CREATE,
                StandardOpenOption.APPEND);
        Logger.info("Appending file: " + filePath);
    }

    /**
     * 安全删除文件
     */
    public static boolean deleteFile(String filePath) {
        try {
            Logger.info("Try Deleting file: " + filePath);
            return Files.deleteIfExists(Paths.get(filePath));
        } catch (IOException e) {
            Logger.error("Fail to delete:" + e.getMessage());
            return false;
        }
    }
}