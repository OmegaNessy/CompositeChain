package by.omeganessy.compositechain.util;

import by.omeganessy.compositechain.exception.CustomException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileReaderUtil {
    static Logger logger = LogManager.getLogger();

    public String read(String fileName) throws CustomException {
        if (fileName == null || fileName.isEmpty()) {
            throw new CustomException("Filename is Empty");
        }
        String data;
        Path path = Paths.get(fileName);
        logger.info(path);
        try (Stream<String> lineStream = Files.lines(path)) {
            data = lineStream.collect(Collectors.joining());
        } catch (IOException e) {
            logger.error("File not found: {}", fileName);
            throw new CustomException("File not found", e);
        }
        return data;
    }
}
