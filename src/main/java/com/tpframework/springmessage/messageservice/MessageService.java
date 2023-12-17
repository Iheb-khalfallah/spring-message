/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tpframework.springmessage.messageservice;

import com.tpframework.springmessage.messagerepository.MessageRepository;
import com.tpframework.springmessage.model.LpMessage;
import jakarta.persistence.EntityManager;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author iheb_kh
 */
@Service
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;
    
    @Autowired
    public EntityManager em;

    public List<LpMessage> Whatsup(String to) throws InterruptedException{
        while(true){
            List<LpMessage> li= (List<LpMessage>) em.createQuery("SELECT x FROM LpMessage WHERE x.to=:v ORDER BY x.dto",LpMessage.class)
                    .setParameter("v", to)
                    .getResultList();
            if (li.isEmpty()){
                Thread.sleep(1000);
            }else{
                LpMessage m = li.get(0);
                em.remove(m);
                return li;
            }
        }
    }
    
    public void send(String to, String content) {
        LpMessage message = new LpMessage();
        message.setTo(to);
        message.setContent(content);
        messageRepository.save(message);
    }
}
