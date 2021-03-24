package com.trius.service;

import com.trius.model.Ticket;

public interface TicketNotificationService {

    void sendToQueue(Ticket ticket);
}
