/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tpframework.springmessage.messagerepository;

import com.tpframework.springmessage.model.LpMessage;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 *
 * @author iheb_kh
 */
public interface MessageRepository extends JpaRepository<LpMessage, Long> {
    List<LpMessage> findByToOrderByDto(String to);
}

