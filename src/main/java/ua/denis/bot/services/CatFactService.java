package ua.denis.bot.services;

import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import ua.denis.bot.models.CatFact;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
@NoArgsConstructor
public class CatFactService {

    @SneakyThrows
    public CatFact getFact(){
        var catFact = new CatFact();

        String str = "";
        String regex = "\"fact\":\"(.+)\",\"length\":(\\d+)";

        URL url = new URL("https://catfact.ninja/fact");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openConnection().getInputStream()));
        str = bufferedReader.lines().collect(Collectors.joining());
        Matcher matcher = Pattern.compile(regex).matcher(str);
        if (matcher.find()){
            catFact.setFact(matcher.group(1));
            catFact.setLength(Integer.parseInt(matcher.group(2)));
        }
        return catFact;
    }
}
