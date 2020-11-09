package com.nicoe.library.service;


import com.nicoe.library.proxies.LibraryProxy;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

@Service("ReminderService")
public class ReminderServiceImpl implements ReminderService {
    private final LibraryProxy libraryProxy;
    private final JavaMailSender javaMailSender;

    @Autowired
    public ReminderServiceImpl(LibraryProxy libraryApiProxy, JavaMailSender javaMailSender) {
        this.libraryProxy = libraryApiProxy;
        this.javaMailSender = javaMailSender;
    }

    @Override
    public void sendReminderMails() {
        List emailList = new ArrayList();
        emailList = libraryProxy.listMail();
        Enumeration enumeration = Collections.enumeration(emailList);
        while (enumeration.hasMoreElements()){
            sendMailToUser((String) enumeration.nextElement());
        }
    }

    private void sendMailToUser(String email){
        System.out.println(email);
        SimpleMailMessage simpleMailMessage = createEmail(email);
        javaMailSender.send(simpleMailMessage);
    }

    private SimpleMailMessage createEmail(String mailAddress) {
        StringBuilder body = new StringBuilder("Cher Membre,\r\nLa date de retour d'emprunt(s) a été dépassée(s).\r\n");
        body.append("\r\nMerci de le(s) rapporter dès que possible.\r\nD'avance merci.\r\nLibraryOC");
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("admin@libraryoc.fr");
        simpleMailMessage.setTo(mailAddress);
        simpleMailMessage.setSubject("[LibraryOC] - Retard de retour d'emprunt");
        simpleMailMessage.setText(body.toString());

        return simpleMailMessage;
    }
}
