
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class SimpleEchoBot extends TelegramLongPollingBot {
    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            Message message = update.getMessage();
            try {
                execute(SendMessage.builder()
                        .chatId(message.getChatId().toString())
                        .text("Hello, I've received your text: " + message.getText())
                        .build());
            } catch (TelegramApiException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public String getBotUsername() {
        return "@test_heroku_deploy_bot";
    }

    @Override
    public String getBotToken() {
        return "5455772694:AAF4zFZZHRWI6QLFMqMg_OHsvVjlN8czIpY";
    }
}
