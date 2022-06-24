import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static java.lang.Math.toIntExact;

public class LuuhBot extends TelegramLongPollingBot {

    HashMap<Long, String> lang = new HashMap<Long, String>();
    HashMap<Long, Boolean> chat = new HashMap<Long, Boolean>();

    Long luuhid = 540927925L;

    public String getLang(Long id){
        if (lang.get(id) != null) {
            return lang.get(id);
        } else {
            return null;
        }
    }

    public Boolean getChat(Long id){
        if (chat.get(id) != null) {
            return chat.get(id);
        } else {
            return false;
        }
    }

    public void setLang(Long id, String value){

        if(value.equals("ita") || value.equals("eng")) {
            if (lang.get(id) != null) {
                lang.replace(id, value);
            } else {
                lang.put(id, value);
            }
        }
    }

    public void setChat(Long id, Boolean value){

        if(chat.get(id) != null){
            chat.replace(id, value);
        } else {
            chat.put(id, value);
        }
    }

    @Override
    public String getBotUsername() {
        return "ItsLuuh_bot";
    }

    @Override
    public String getBotToken() {
        return "token";
    }

    @Override
    public void onUpdateReceived(Update update) {

        if(update.hasMessage() && update.getMessage().hasText()) {
            Long id = update.getMessage().getFrom().getId();
            String message = update.getMessage().getText();
            if(update.getMessage().isReply() && update.getMessage().getChatId().equals(luuhid)){
                Message message1 = update.getMessage().getReplyToMessage();
                ReplyKeyboard replyKeyboard = message1.getReplyMarkup();
                String messagetext = message1.getText();
                Long messageid = Long.valueOf(messagetext.substring(messagetext.lastIndexOf("» ") + 1));
                SendMessage message2 = new SendMessage();
                String resptext = update.getMessage().getText();

                message2.setChatId(messageid);
                message2.setText(resptext);
                message2.setReplyMarkup(replyKeyboard);

                try {
                    execute(message2);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
            if(message.contains("/")) {
                if (message.contains("stopchat")) {
                    setChat(id, false);
                    long chat_id = update.getMessage().getChatId();
                    if (getLang(id).equals("ita")) {
                        String answer = "Ok! Seleziona quello che vuoi fare:";
                        SendMessage new_message = new SendMessage();
                        new_message.setChatId(chat_id);
                        new_message.setText(answer);
                        InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
                        List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();
                        List<InlineKeyboardButton> rowInline = new ArrayList<>();
                        List<InlineKeyboardButton> rowInline2 = new ArrayList<>();
                        List<InlineKeyboardButton> rowInline3 = new ArrayList<>();
                        InlineKeyboardButton chat = InlineKeyboardButton
                                .builder()
                                .text("\uD83D\uDCAD Chat \uD83D\uDCAD")
                                .callbackData("chat")
                                .build();
                        InlineKeyboardButton bio = InlineKeyboardButton
                                .builder()
                                .text("⭐️ Bio ⭐️")
                                .callbackData("bio")
                                .url("https://t.me/HolographicDisplays")
                                .build();
                        InlineKeyboardButton works = InlineKeyboardButton
                                .builder()
                                .text("\uD83E\uDDD1\uD83C\uDFFB\u200D\uD83D\uDCBB Lavori \uD83E\uDDD1\uD83C\uDFFB\u200D\uD83D\uDCBB")
                                .callbackData("works")
                                .url("https://t.me/LuuhWorks")
                                .build();
                        InlineKeyboardButton back = InlineKeyboardButton
                                .builder()
                                .text("◀️")
                                .callbackData("langback")
                                .build();
                        rowInline.add(chat);
                        rowInline.add(bio);
                        rowInline2.add(works);
                        rowInline3.add(back);
                        // Set the keyboard to the markup
                        rowsInline.add(rowInline);
                        rowsInline.add(rowInline2);
                        rowsInline.add(rowInline3);
                        // Add it to the message
                        markupInline.setKeyboard(rowsInline);
                        new_message.setReplyMarkup(markupInline);


                        try {
                            execute(new_message);
                        } catch (TelegramApiException e) {
                            e.printStackTrace();
                        }
                    } else {
                        String answer = "Ok! Select what you want to do:";
                        SendMessage new_message = new SendMessage();
                        new_message.setChatId(chat_id);
                        new_message.setText(answer);
                        InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
                        List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();
                        List<InlineKeyboardButton> rowInline = new ArrayList<>();
                        List<InlineKeyboardButton> rowInline2 = new ArrayList<>();
                        List<InlineKeyboardButton> rowInline3 = new ArrayList<>();
                        InlineKeyboardButton chat = InlineKeyboardButton
                                .builder()
                                .text("\uD83D\uDCAD Chat \uD83D\uDCAD")
                                .callbackData("chat")
                                .build();
                        InlineKeyboardButton bio = InlineKeyboardButton
                                .builder()
                                .text("⭐️ Bio ⭐️")
                                .callbackData("bio")
                                .url("https://t.me/HolographicDisplays")
                                .build();
                        InlineKeyboardButton works = InlineKeyboardButton
                                .builder()
                                .text("\uD83E\uDDD1\uD83C\uDFFB\u200D\uD83D\uDCBB Works \uD83E\uDDD1\uD83C\uDFFB\u200D\uD83D\uDCBB")
                                .callbackData("works")
                                .url("https://t.me/LuuhWorks")
                                .build();
                        InlineKeyboardButton back = InlineKeyboardButton
                                .builder()
                                .text("◀️")
                                .callbackData("langback")
                                .build();
                        rowInline.add(chat);
                        rowInline.add(bio);
                        rowInline2.add(works);
                        rowInline3.add(back);
                        // Set the keyboard to the markup
                        rowsInline.add(rowInline);
                        rowsInline.add(rowInline2);
                        rowsInline.add(rowInline3);
                        // Add it to the message
                        markupInline.setKeyboard(rowsInline);
                        new_message.setReplyMarkup(markupInline);

                        try {
                            execute(new_message);
                        } catch (TelegramApiException e) {
                            e.printStackTrace();
                        }
                    }
                } else if (message.contains("getid")) {
                    SendMessage messagebot = new SendMessage();
                    messagebot.setText(String.valueOf(id));
                    messagebot.setChatId(update.getMessage().getChatId());
                    try {
                        execute(messagebot);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                } else if (message.contains("getchatid")) {
                    SendMessage messagebot = new SendMessage();
                    Long chatid = update.getMessage().getChatId();
                    messagebot.setText(String.valueOf(chatid));
                    messagebot.setChatId(update.getMessage().getChatId());
                    try {
                        execute(messagebot);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                } else if(message.contains("start")){
                    SendMessage messagebot = new SendMessage();
                    String username = update.getMessage().getFrom().getUserName();
                    messagebot.setText("Hello @" + username + "! Select your language you want to talk with me:");
                    InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
                    List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();
                    List<InlineKeyboardButton> rowInline = new ArrayList<>();
                    InlineKeyboardButton eng = InlineKeyboardButton
                            .builder()
                            .text("\uD83C\uDDEC\uD83C\uDDE7")
                            .callbackData("eng")
                            .build();
                    InlineKeyboardButton ita = InlineKeyboardButton
                            .builder()
                            .text("\uD83C\uDDEE\uD83C\uDDF9")
                            .callbackData("ita")
                            .build();
                    rowInline.add(eng);
                    rowInline.add(ita);
                    // Set the keyboard to the markup
                    rowsInline.add(rowInline);
                    // Add it to the message
                    markupInline.setKeyboard(rowsInline);
                    messagebot.setReplyMarkup(markupInline);

                    messagebot.setChatId(update.getMessage().getChatId());
                    try {
                        execute(messagebot);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();

                    }
                }
            } else {
                if (getChat(id)) {
                    SendMessage messagebot = new SendMessage();
                    String userlang = getLang(id);
                    String userflag = null;
                    if(userlang.equals("eng"))userflag = "\uD83C\uDDEC\uD83C\uDDE7";
                    if(userlang.equals("ita"))userflag = "\uD83C\uDDEE\uD83C\uDDF9";
                    String username = update.getMessage().getFrom().getUserName();
                    messagebot.setText(userflag+ " » @"+username+" » "+message);
                    messagebot.setChatId(luuhid);
                    SendMessage messagebot2 = new SendMessage();
                    messagebot2.setText("@"+username+" » "+id);
                    messagebot2.setChatId(luuhid);
                    try {
                        execute(messagebot);
                        execute(messagebot2);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                }
            }
        } else if( update.hasCallbackQuery()){
            String call_data = update.getCallbackQuery().getData();
            long message_id = update.getCallbackQuery().getMessage().getMessageId();
            long chat_id = update.getCallbackQuery().getMessage().getChatId();

            if (call_data.equals("eng")) {
                Long id = update.getCallbackQuery().getFrom().getId();
                setLang(id, "eng");
                String answer = "Ok! Select what you want to do:";
                EditMessageText new_message = new EditMessageText();
                new_message.setChatId(chat_id);
                new_message.setMessageId(toIntExact(message_id));
                new_message.setText(answer);
                InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
                List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();
                List<InlineKeyboardButton> rowInline = new ArrayList<>();
                List<InlineKeyboardButton> rowInline2 = new ArrayList<>();
                List<InlineKeyboardButton> rowInline3 = new ArrayList<>();
                InlineKeyboardButton chat = InlineKeyboardButton
                        .builder()
                        .text("\uD83D\uDCAD Chat \uD83D\uDCAD")
                        .callbackData("chat")
                        .build();
                InlineKeyboardButton bio = InlineKeyboardButton
                        .builder()
                        .text("⭐️ Bio ⭐️")
                        .callbackData("bio")
                        .url("https://t.me/HolographicDisplays")
                        .build();
                InlineKeyboardButton works = InlineKeyboardButton
                        .builder()
                        .text("\uD83E\uDDD1\uD83C\uDFFB\u200D\uD83D\uDCBB Works \uD83E\uDDD1\uD83C\uDFFB\u200D\uD83D\uDCBB")
                        .callbackData("works")
                        .url("https://t.me/LuuhWorks")
                        .build();
                InlineKeyboardButton back = InlineKeyboardButton
                        .builder()
                        .text("◀️")
                        .callbackData("langback")
                        .build();
                rowInline.add(chat);
                rowInline.add(bio);
                rowInline2.add(works);
                rowInline3.add(back);
                // Set the keyboard to the markup
                rowsInline.add(rowInline);
                rowsInline.add(rowInline2);
                rowsInline.add(rowInline3);
                // Add it to the message
                markupInline.setKeyboard(rowsInline);
                new_message.setReplyMarkup(markupInline);

                try {
                    execute(new_message);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            } else if (call_data.equals("ita")) {
                Long id = update.getCallbackQuery().getFrom().getId();
                setLang(id, "ita");
                String answer = "Ok! Seleziona quello che vuoi fare:";
                EditMessageText new_message = new EditMessageText();
                new_message.setChatId(chat_id);
                new_message.setMessageId(toIntExact(message_id));
                new_message.setText(answer);
                InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
                List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();
                List<InlineKeyboardButton> rowInline = new ArrayList<>();
                List<InlineKeyboardButton> rowInline2 = new ArrayList<>();
                List<InlineKeyboardButton> rowInline3 = new ArrayList<>();
                InlineKeyboardButton chat = InlineKeyboardButton
                        .builder()
                        .text("\uD83D\uDCAD Chat \uD83D\uDCAD")
                        .callbackData("chat")
                        .build();
                InlineKeyboardButton bio = InlineKeyboardButton
                        .builder()
                        .text("⭐️ Bio ⭐️")
                        .callbackData("bio")
                        .url("https://t.me/HolographicDisplays")
                        .build();
                InlineKeyboardButton works = InlineKeyboardButton
                        .builder()
                        .text("\uD83E\uDDD1\uD83C\uDFFB\u200D\uD83D\uDCBB Lavori \uD83E\uDDD1\uD83C\uDFFB\u200D\uD83D\uDCBB")
                        .callbackData("works")
                        .url("https://t.me/LuuhWorks")
                        .build();
                InlineKeyboardButton back = InlineKeyboardButton
                        .builder()
                        .text("◀️")
                        .callbackData("langback")
                        .build();
                rowInline.add(chat);
                rowInline.add(bio);
                rowInline2.add(works);
                rowInline3.add(back);
                // Set the keyboard to the markup
                rowsInline.add(rowInline);
                rowsInline.add(rowInline2);
                rowsInline.add(rowInline3);
                // Add it to the message
                markupInline.setKeyboard(rowsInline);
                new_message.setReplyMarkup(markupInline);


                try {
                    execute(new_message);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            } else if(call_data.equals("langback")) {
                String username = update.getCallbackQuery().getFrom().getUserName();
                String answer = "Hello @" + username + "! Select your language you want to talk with me:";
                EditMessageText new_message = new EditMessageText();
                new_message.setChatId(chat_id);
                new_message.setMessageId(toIntExact(message_id));
                new_message.setText(answer);
                InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
                List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();
                List<InlineKeyboardButton> rowInline = new ArrayList<>();
                InlineKeyboardButton eng = InlineKeyboardButton
                        .builder()
                        .text("\uD83C\uDDEC\uD83C\uDDE7")
                        .callbackData("eng")
                        .build();
                InlineKeyboardButton ita = InlineKeyboardButton
                        .builder()
                        .text("\uD83C\uDDEE\uD83C\uDDF9")
                        .callbackData("ita")
                        .build();
                rowInline.add(eng);
                rowInline.add(ita);
                // Set the keyboard to the markup
                rowsInline.add(rowInline);
                // Add it to the message
                markupInline.setKeyboard(rowsInline);
                new_message.setReplyMarkup(markupInline);

                try {
                    execute(new_message);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            } else if(call_data.equals("hubback")){
                Long id = update.getCallbackQuery().getFrom().getId();
                setChat(id, false);
                if(getLang(id).equals("ita")){
                    String answer = "Ok! Seleziona quello che vuoi fare:";
                    EditMessageText new_message = new EditMessageText();
                    new_message.setChatId(chat_id);
                    new_message.setMessageId(toIntExact(message_id));
                    new_message.setText(answer);
                    InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
                    List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();
                    List<InlineKeyboardButton> rowInline = new ArrayList<>();
                    List<InlineKeyboardButton> rowInline2 = new ArrayList<>();
                    List<InlineKeyboardButton> rowInline3 = new ArrayList<>();
                    InlineKeyboardButton chat = InlineKeyboardButton
                            .builder()
                            .text("\uD83D\uDCAD Chat \uD83D\uDCAD")
                            .callbackData("chat")
                            .build();
                    InlineKeyboardButton bio = InlineKeyboardButton
                            .builder()
                            .text("⭐️ Bio ⭐️")
                            .callbackData("bio")
                            .url("https://t.me/HolographicDisplays")
                            .build();
                    InlineKeyboardButton works = InlineKeyboardButton
                            .builder()
                            .text("\uD83E\uDDD1\uD83C\uDFFB\u200D\uD83D\uDCBB Lavori \uD83E\uDDD1\uD83C\uDFFB\u200D\uD83D\uDCBB")
                            .callbackData("works")
                            .url("https://t.me/LuuhWorks")
                            .build();
                    InlineKeyboardButton back = InlineKeyboardButton
                            .builder()
                            .text("◀️")
                            .callbackData("langback")
                            .build();
                    rowInline.add(chat);
                    rowInline.add(bio);
                    rowInline2.add(works);
                    rowInline3.add(back);
                    // Set the keyboard to the markup
                    rowsInline.add(rowInline);
                    rowsInline.add(rowInline2);
                    rowsInline.add(rowInline3);
                    // Add it to the message
                    markupInline.setKeyboard(rowsInline);
                    new_message.setReplyMarkup(markupInline);


                    try {
                        execute(new_message);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                } else {
                    String answer = "Ok! Select what you want to do:";
                    EditMessageText new_message = new EditMessageText();
                    new_message.setChatId(chat_id);
                    new_message.setMessageId(toIntExact(message_id));
                    new_message.setText(answer);
                    InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
                    List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();
                    List<InlineKeyboardButton> rowInline = new ArrayList<>();
                    List<InlineKeyboardButton> rowInline2 = new ArrayList<>();
                    List<InlineKeyboardButton> rowInline3 = new ArrayList<>();
                    InlineKeyboardButton chat = InlineKeyboardButton
                            .builder()
                            .text("\uD83D\uDCAD Chat \uD83D\uDCAD")
                            .callbackData("chat")
                            .build();
                    InlineKeyboardButton bio = InlineKeyboardButton
                            .builder()
                            .text("⭐️ Bio ⭐️")
                            .callbackData("bio")
                            .url("https://t.me/HolographicDisplays")
                            .build();
                    InlineKeyboardButton works = InlineKeyboardButton
                            .builder()
                            .text("\uD83E\uDDD1\uD83C\uDFFB\u200D\uD83D\uDCBB Works \uD83E\uDDD1\uD83C\uDFFB\u200D\uD83D\uDCBB")
                            .callbackData("works")
                            .url("https://t.me/LuuhWorks")
                            .build();
                    InlineKeyboardButton back = InlineKeyboardButton
                            .builder()
                            .text("◀️")
                            .callbackData("langback")
                            .build();
                    rowInline.add(chat);
                    rowInline.add(bio);
                    rowInline2.add(works);
                    rowInline3.add(back);
                    // Set the keyboard to the markup
                    rowsInline.add(rowInline);
                    rowsInline.add(rowInline2);
                    rowsInline.add(rowInline3);
                    // Add it to the message
                    markupInline.setKeyboard(rowsInline);
                    new_message.setReplyMarkup(markupInline);

                    try {
                        execute(new_message);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                }
            } else if(call_data.equals("chat")){
                Long id = update.getCallbackQuery().getFrom().getId();
                setChat(id, true);
                String answer;
                if(getLang(id).equals("ita")) {
                    answer = "Ok! Scrivi quello che vorresti dirmi:";
                } else {
                    answer = "Ok! Write what you want to say to me:";
                }
                EditMessageText new_message = new EditMessageText();
                new_message.setChatId(chat_id);
                new_message.setMessageId(toIntExact(message_id));
                new_message.setText(answer);
                InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
                List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();
                List<InlineKeyboardButton> rowInline = new ArrayList<>();
                InlineKeyboardButton back = InlineKeyboardButton
                        .builder()
                        .text("◀️")
                        .callbackData("hubback")
                        .build();
                rowInline.add(back);
                // Set the keyboard to the markup
                rowsInline.add(rowInline);
                // Add it to the message
                markupInline.setKeyboard(rowsInline);
                new_message.setReplyMarkup(markupInline);
                try {
                    execute(new_message);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
