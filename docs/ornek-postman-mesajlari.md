
#### Account Servisi (Account Yaratma)
```
 http://localhost:8501/account

{
	"username" : "trius",
    "name" : "trius",
    "surname" : "trius",
    "email" : "burak.dagli@gmail.com",
    "birthDate" : "1999-01-01"
}
```

#### Ticket Servisi (Ticket Yaratma)

```
 http://localhost:8502/ticket

{
	"description" : "Test Ticket 1",
    "notes" : "Test Ticket 1 - Docker Compose Hatasi",
    "assignee" : "trius",
    "priorityType" : "URGENT",
    "ticketStatus" : "OPEN",
    "ticketDate" : "1999-01-01"
}
```