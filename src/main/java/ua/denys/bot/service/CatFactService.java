package ua.denys.bot.service;

import static ua.denys.bot.consts.UrlConst.CAT_FACT_API_URL;

import java.net.URL;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import ua.denys.bot.mapper.CatFactMapper;
import ua.denys.bot.models.CatFact;

@Service
@RequiredArgsConstructor
public class CatFactService {

  private final CatFactMapper catFactMapper;

  @SneakyThrows
  public CatFact getFact() {
    var url = new URL(CAT_FACT_API_URL);
    var fact = catFactMapper.urlToFact(url);
    return fact;
  }
}
