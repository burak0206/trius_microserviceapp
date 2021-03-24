package com.trius.messaging;


import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class TicketNotification {
    private String ticketId;
    private String accountId;
    private String ticketDescription;

}
