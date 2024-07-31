package ua.denys.bot;


import com.pengrad.telegrambot.TelegramBot;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import ua.denys.bot.listeners.MyListener;

@Component
@Slf4j
@RequiredArgsConstructor
public class Bot {
    private final MyListener myListener;

    Logger logger = LoggerFactory.getLogger(Bot.class);

    private static TelegramBot telegramBot = null;

    @Value("${bot.token}")
    private String token;

    @Bean
    private void createBot(){
        telegramBot = new TelegramBot(token);
        telegramBot.setUpdatesListener(myListener);
        logger.warn("Runned at token: " + token);
        logger.info("                \n" +
                "                    \n" +
                "                //  \n" +
                "             ///    \n" +
                "           ///      \n" +
                "  //     ///        \n" +
                "  //// ///          \n" +
                "   //////           \n" +
                "    ///             \n" +
                "________________________\n" +
                "Telegram bot is successfully run" +
                "\n");
    }

    public static TelegramBot getTelegramBot() {
        return telegramBot;
    }
}
