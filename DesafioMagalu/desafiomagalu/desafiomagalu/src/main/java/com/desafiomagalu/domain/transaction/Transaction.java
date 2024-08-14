package com.desafiomagalu.domain.transaction;



import com.desafiomagalu.domain.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity(name="transactions")
@Table(name="transactions")
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode(of="id")
@NoArgsConstructor
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime date;

    @ManyToOne
    @JoinColumn(name="sender_id")
    private User sender;
    @ManyToOne
    @JoinColumn(name="receiver_id")
    private User receiver;
    private String message;

    @Enumerated(EnumType.STRING)
    private ChannelType type;
}
