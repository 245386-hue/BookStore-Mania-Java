package bookstore;

import java.util.LinkedHashMap;
import java.util.Map;

public class BookData {
    private Map<String, String> bookImages = new LinkedHashMap<>();
    
    public BookData() {
        initializeBookImages();
    }
    
    private void initializeBookImages() {
        // All the book image mappings from original code
    }
    
    public Map<String, String> getBookImages() {
        return bookImages;
    }
}