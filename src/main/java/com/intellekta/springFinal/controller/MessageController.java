package com.intellekta.springFinal.controller;


import com.intellekta.springFinal.jpa.entity.MessageEntity;
import com.intellekta.springFinal.jpa.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class MessageController {

    private final MessageRepository messageRepository;

    private String name = "User";
    private String filter;


    @Autowired
    public MessageController(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String sendLogin(@RequestParam String name) {
        this.name = name;
        return "redirect:/messages";
    }

    @GetMapping("/messages")
    public String getMessages(Map<String, Object> model) {
        model.put("name", name);
        model.put("messages", messageRepository.findAll());
        return "messages";
    }

    @PostMapping("/messages")
    public String add(@RequestParam("text") String text, @RequestParam("tag") String tag, Map<String, Object> model) {
        MessageEntity message = new MessageEntity(text, tag);
        messageRepository.save(message);
        Iterable<MessageEntity> messages = messageRepository.findAll();
        model.put("messages", messages);
        return "redirect:/messages";
    }

    @PostMapping("/filter")
    public String filter(@RequestParam String filter, Map<String, Object> model) {
        Iterable<MessageEntity> messages;
        this.filter = filter;

        if (messageRepository.findByTag(filter).isEmpty()) {
            model.put("message", "No such tag exists");
            model.put("cond", true);
            return "messages";
        }
        else if (filter != null && !filter.isEmpty()) {
            messages = messageRepository.findByTag(filter);
        }
        else {
            messages = messageRepository.findAll();
        }
        model.put("messages", messages);
        return "filter";
    }

    @GetMapping("/filter")
    public String getFilteredMessages(Map<String, Object> model) {
        System.out.println(filter);
        model.put("messages", messageRepository.findByTag(filter));
        filter = "";
        return "filter";
    }


}
