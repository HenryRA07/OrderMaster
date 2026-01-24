package edu.unl.cc.ordermaster.domain;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class GmailTest {

    @Test
    void enviarEmail() {
        Gmail gmail = new Gmail();
        gmail.enviarEmail("franz.ludena0907@gmail.com", LocalDate.now(),"franz Ludeña");
    }
}