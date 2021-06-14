package servecontent;

import model.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@SpringBootApplication
@RestController
public class MessagesRestController {

    Map<String, String> allUsers = new HashMap<String, String>() {{
        put("vasya", "vasya");
        put("tanya", "tanya");
        put("oleg", "oleg");
        put("katya", "katya");
        put("misha", "misha");
        put("lesha", "lesha");
        put("vasya1", "vasya1");
        put("tanya1", "tanya1");
        put("oleg1", "oleg1");
        put("katya1", "katya1");
        put("misha1", "misha1");
        put("lesha1", "lesha1");
    }};
    Map<Integer, MessageModel> allMessages = new HashMap<Integer, MessageModel>() {{
        put(0, new MessageModel(0, "vasya", "my vasya message"));
        put(1, new MessageModel(1, "tanya", "my tanya message"));
        put(2, new MessageModel(2, "oleg", "my oleg message"));
        put(3, new MessageModel(3, "katya", "my katya message"));
        put(4, new MessageModel(4, "misha", "my misha message"));
        put(5, new MessageModel(5, "lesha", "my lesha message"));
        put(6, new MessageModel(6, "vasya", "my vasya1 message"));
        put(7, new MessageModel(7, "tanya", "my tanya1 message"));
        put(8, new MessageModel(8, "oleg", "my oleg1 message", 2));
        put(9, new MessageModel(9, "katya", "my katya1 message", 3));
        put(10, new MessageModel(10, "misha", "my misha1 message", 4));
        put(11, new MessageModel(11, "lesha", "my lesha1 message", 5));
    }};
    Set<String> loggedInUsers = new HashSet<String>();
    int currentMessageIndex = 12;

    // endpoint to get messages
    @RequestMapping(value = "/messages/{username}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<MessageModel>> messages(@PathVariable String username) {
        List<MessageModel> filteredMessages = allMessages
                .values()
                .stream()
                .filter(x -> x.getUser().equals(username))
                .collect(Collectors.toList());
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(filteredMessages);
    }

    //    	/stats/top
    @RequestMapping(value = "/stats/top", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Top10Messages>> stats() {

        // выбрать 10 пользователей с большим количеством сообщений
        Map<String, Long> countedMessages = allMessages.values().stream()
                .collect(Collectors.groupingBy(o -> o.getUser(), Collectors.counting()));

        ValueComparator bvc = new ValueComparator(countedMessages);
        TreeMap<String, Long> sortedMessages = new TreeMap<String, Long>(bvc);
        sortedMessages.putAll(countedMessages);

        List<Top10Messages> top10Messages = new ArrayList<Top10Messages>();
        int i = 0;
        for (Map.Entry<String, Long> entry : sortedMessages.entrySet()) {
            i += 1;
            if (i > 10)
                break;
            top10Messages.add(new Top10Messages(entry.getKey(), entry.getValue()));
        }

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(top10Messages);
    }

    // /all-messages
    @RequestMapping(value = "/all-messages", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<MessageModel>> allMessages() {
        List<MessageModel> orderedMessages = allMessages.values().stream().sorted().collect(Collectors.toList());
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(orderedMessages);
    }

    @PostMapping(
            value = "/register",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<RequestMessage> register(@RequestBody Registration registration) {
        if (allUsers.containsKey(registration.username)) {
            RequestMessage requestMessage = new RequestMessage("user with same name already exists");
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(requestMessage);
        } else {
            allUsers.put(registration.username, registration.password);
            RequestMessage requestMessage = new RequestMessage("user has been registered");
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(requestMessage);
        }
    }


    // endpoint to login
    @PostMapping(
            value = "/login",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<RequestMessage> login(@RequestBody Registration registration) {
        if (allUsers.containsKey(registration.username) && allUsers.get(registration.username).equals(registration.password)) {
            loggedInUsers.add(registration.username);
            RequestMessage requestMessage = new RequestMessage("you are logged in now");
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(requestMessage);
        } else {
            RequestMessage requestMessage = new RequestMessage("user is not registered or password is incorrect");
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(requestMessage);
        }

    }

    // endpoint to send message
    @PostMapping(
            value = "/sendMessage",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<RequestMessage> sendMessage(@RequestBody IncomingMessageModel incomingMessage) {
        MessageModel message = new MessageModel(
                incomingMessage.getUser(),
                incomingMessage.getText(),
                Integer.parseInt(incomingMessage.getReplyTo()));
        if (loggedInUsers.contains(message.getUser())) {
            message.setMsgNumber(currentMessageIndex);
            currentMessageIndex += 1;
            allMessages.put(message.getMsgNumber(), message);
            RequestMessage requestMessage = new RequestMessage("your message is saved");
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(requestMessage);
        } else {
            RequestMessage requestMessage = new RequestMessage("you should log in");
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(requestMessage);
        }

    }

}
