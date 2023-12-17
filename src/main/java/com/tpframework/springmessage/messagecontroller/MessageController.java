/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tpframework.springmessage.messagecontroller;

import com.tpframework.springmessage.messageservice.MessageService;
import com.tpframework.springmessage.model.LpMessage;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author iheb_kh
 */
@RestController
public class MessageController {
    @Autowired
    private MessageService message_service;

    @GetMapping("/get-real-time-message/{to}")
    public List<LpMessage> MessageSender (@PathVariable("to") String to) throws InterruptedException {
        return message_service.Whatsup(to);
    }
    
    @PostMapping("/send-message")
    public ResponseEntity<String> send(@RequestBody LpMessage m){
        try {
            message_service.send(m.recipient, m.content);
            return ResponseEntity.ok("Message sent successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error sending message: " + e.getMessage());
        }
    }
}
