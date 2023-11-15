package com.mail.icaro.modules.history.entity;


import com.mail.icaro.shared.entity.DateBase;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Setter

@Entity
@Table(name = "shipping_history")
public class ShippingHistory extends DateBase {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", columnDefinition = "uuid")
    private UUID id;

    @Column(name = "content")
    private String content;

    @Column(name = "title")
    private String title;

    @Column(name = "userMail")
    private String userMail;

    @Column(name = "sync")
    private Boolean sync;

}
