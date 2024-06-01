package org.openapitools.dataLoader;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Component
public class DataLoaderImpl<T> implements DataLoader<T> {

    private List<T> data;

    @Override
    public void loadData(String filePath, Class<T> clazz) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        InputStream inputStream = getClass().getResourceAsStream(filePath);
        this.data = mapper.readValue(inputStream, mapper.getTypeFactory().constructCollectionType(List.class, clazz));
    }

    @Override
    public List<T> getData() {
        return data;
    }

}