package com.homeypark.web_service.payment.domain.model.entities;

import com.homeypark.web_service.payment.domain.model.commands.CreateCardCommand;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "vehicles")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long numCard;

    private Long cvv;

    private String date;

    public Card(Long numCard, Long cvv, String date) {
        this.numCard = numCard;
        this.cvv = cvv;
        this.date = date;
    }

    public Card(CreateCardCommand command) {
        this.numCard = command.numCard();
        this.cvv = command.cvv();
        this.date = command.date();
    }

}
