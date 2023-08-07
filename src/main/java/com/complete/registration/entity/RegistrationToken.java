package com.complete.registration.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Calendar;
import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
@Entity
public class RegistrationToken {
    private static final int EXPIRATION_TIME = 10;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String token;
    private Date duration;
    @OneToOne
    @JoinColumn(name = "user_id")
    private AppUser user;

    public RegistrationToken(AppUser user, String token) {
        super();
        this.user = user;
        this.token = token;
        this.duration = this.getTokenDuration();
    }

    public RegistrationToken(String token) {
        super();
        this.token = token;
        this.duration = this.getTokenDuration();
    }

    public Date getTokenDuration() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(new Date().getTime());
        calendar.add(Calendar.MINUTE, EXPIRATION_TIME);

        return new Date(calendar.getTime().getTime());
    }
}
