package org.openapitools.dataLoader;

import java.io.IOException;
import java.util.List;

public interface DataLoader<T> {
    void loadData(String filePath, Class<T> clazz) throws IOException;

    List<T> getData();
}
