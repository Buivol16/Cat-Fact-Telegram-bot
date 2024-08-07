package ua.denys.bot.listeners;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.denys.bot.Bot;
import ua.denys.bot.service.CatFactService;

import java.util.List;

@Component
@NoArgsConstructor
public class MyListener implements UpdatesListener {

    @Autowired
    CatFactService catFactService;

    private TelegramBot bot = null;

    @Override
    public int process(List<Update> list) {
        bot = Bot.getTelegramBot();
        list.forEach(update ->{
            long chatId = update.message().chat().id();
            var message = update.message();
            var isGetFactCommand = message.text().equals("/getfact");
            if (message != null && isGetFactCommand) {
                var fact = catFactService.getFact().toString();
                var sendMessageRequest = new SendMessage(chatId, fact);
                bot.execute(sendMessageRequest);
            }
        });
        return UpdatesListener.CONFIRMED_UPDATES_ALL;
    }
}
