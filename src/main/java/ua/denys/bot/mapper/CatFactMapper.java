package ua.denys.bot.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import ua.denys.bot.models.CatFact;

import java.io.IOException;
import java.net.URL;

@Service
public class CatFactMapper {

    private final ObjectMapper mapper = new ObjectMapper();

    public CatFact urlToFact(URL url) throws IOException {
        var catFact = mapper.readValue(url, CatFact.class);
        return catFact;
    }
}
