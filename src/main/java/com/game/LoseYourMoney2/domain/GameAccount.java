package com.game.LoseYourMoney2.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@Table(name="GAMEACCOUNT")
public class GameAccount {
    private int id;
    private int accountBalance;

    public GameAccount(int accountBalance) {
        this.accountBalance = accountBalance;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "ID", unique = true)
    public int getId() {
        return id;
    }

    @NotNull
    @Column(name = "ACCOUNT_BALANCE")
    public int getAccountBalance() {
        return accountBalance;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAccountBalance(int accountBalance) {
        this.accountBalance = accountBalance;
    }
}
