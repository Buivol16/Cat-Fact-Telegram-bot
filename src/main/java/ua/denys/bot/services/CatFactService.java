package ua.denys.bot.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import ua.denys.bot.models.CatFact;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.stream.Collectors;

@Service
@NoArgsConstructor
public class CatFactService {

    private final ObjectMapper mapper = new ObjectMapper();

    @SneakyThrows
    public CatFact getFact(){
        URL url = new URL("https://catfact.ninja/fact");
        var catFact = mapper.readValue(url, CatFact.class);
        return catFact;
    }
}
