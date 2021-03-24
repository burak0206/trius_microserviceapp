package com.trius.service.impl;

import com.trius.messaging.TicketNotification;
import com.trius.model.Ticket;
import com.trius.service.TicketNotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.stereotype.Service;


@Service
@EnableBinding(Source.class)
@RequiredArgsConstructor
public class TicketNotificationServiceImpl implements TicketNotificationService {

    private final Source source;

    @Override
    public void sendToQueue(Ticket ticket) {
        TicketNotification ticketNotification = TicketNotification
                .builder()
                .accountId(ticket.getAssignee())
                .ticketId(ticket.getId())
                .ticketDescription(ticket.getDescription())
                .build();
        source.output().send(MessageBuilder.withPayload(ticketNotification).build());
    }
}
