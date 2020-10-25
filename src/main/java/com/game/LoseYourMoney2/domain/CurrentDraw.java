package com.game.LoseYourMoney2.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@Table(name="CURRENT_DRAW")
public class CurrentDraw {
    private int id;
    private int drawnNumber;
    private Set<GameAccount> gameAccount;
    private int pickedNumber;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "ID", unique = true)
    public int getId() {
        return id;
    }

    @NotNull
    @Column(name = "DRAWN_NUMBER")
    public int getDrawnNumber() {
        return drawnNumber;
    }

    @OneToMany
            (
            targetEntity = GameAccount.class,
            mappedBy = "currentDraw",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    public Set<GameAccount> getGameAccount() {
        return gameAccount;
    }

    public int getPickedNumber() {
        return pickedNumber;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDrawnNumber(int drawnNumber) {
        this.drawnNumber = drawnNumber;
    }

    public void setGameAccount(Set<GameAccount> gameAccount) {
        this.gameAccount = gameAccount;
    }

    public void setPickedNumber(int pickedNumber) {
        this.pickedNumber = pickedNumber;
    }
}
