package com.nicoe.library.service;


import org.springframework.stereotype.Service;

@Service
public interface ReminderService {
    void sendReminderMails();
}
