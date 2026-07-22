package com.example.exercise2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;

public class FileServiceTest {

    @Test
    public void testServiceWithMockFileIO() {

        // Create mock objects
        FileReader mockFileReader = mock(FileReader.class);
        FileWriter mockFileWriter = mock(FileWriter.class);

        // Stub the read() method
        when(mockFileReader.read()).thenReturn("Mock File Content");

        // Create service
        FileService fileService = new FileService(mockFileReader, mockFileWriter);

        // Call method
        String result = fileService.processFile();

        // Verify result
        assertEquals("Processed Mock File Content", result);

        // Verify write() was called
        verify(mockFileWriter).write("Mock File Content");
    }
}