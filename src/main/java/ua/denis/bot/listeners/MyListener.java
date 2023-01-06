package ua.denis.bot.listeners;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.denis.bot.Bot;
import ua.denis.bot.services.CatFactService;

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
            Message message = update.message();
            if (message != null && message.text().equals("/getfact")) bot.execute(new SendMessage(chatId, catFactService.getFact().toString()));
        });
        return UpdatesListener.CONFIRMED_UPDATES_ALL;
    }
}
