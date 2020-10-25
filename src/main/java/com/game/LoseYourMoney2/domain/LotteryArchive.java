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
@Table(name="LOTTERY_ARCHIVE")
public class LotteryArchive {
    private int id;
    private int lotteryNumber;
    private int drawnNumber;
    private int winningTicketsQuantity;

    public LotteryArchive(int lotteryNumber, int drawnNumber) {
        this.lotteryNumber = lotteryNumber;
        this.drawnNumber = drawnNumber;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "ID", unique = true)
    public int getId() {
        return id;
    }

    @NotNull
    @Column(name = "LOTTERY_NUMBER")
    public int getLotteryNumber() {
        return lotteryNumber;
    }

    @NotNull
    @Column(name = "DRAWN_NUMBER")
    public int getDrawnNumber() {
        return drawnNumber;
    }

    @NotNull
    @Column(name = "WINNING_TICKETS_QUANTITY", columnDefinition = "integer default 0")
    public int getWinningTicketsQuantity() {
        return winningTicketsQuantity;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLotteryNumber(int lotteryNumber) {
        this.lotteryNumber = lotteryNumber;
    }

    public void setDrawnNumber(int drawnNumber) {
        this.drawnNumber = drawnNumber;
    }

    public void setWinningTicketsQuantity(int winningTicketsQuantity) {
        this.winningTicketsQuantity = winningTicketsQuantity;
    }
}
