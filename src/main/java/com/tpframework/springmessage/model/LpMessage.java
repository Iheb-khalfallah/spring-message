/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tpframework.springmessage.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

/**
 *
 * @author iheb_kh
 */


@Entity
public class LpMessage {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    public String content;
    public String recipient;
    public LocalDateTime dto = LocalDateTime.now();

    public void setContent(String content){ this.content=content; }

    public String getContent(){
        return this.content;
    } 
    
    public void setTo(String recipient){
        this.recipient=recipient;
    } 
    
    public void setDto(LocalDateTime dto){
        this.dto=dto;
    } 
    
    public LocalDateTime getDto(){
        return this.dto;
    } 
}
