package com.mlb.mlb_api.repositories.entities;

import com.mlb.mlb_api.controllers.dto.DraftDTO;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Draft {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Integer id;
    private Integer playerId;
    private Integer teamId;
    @CreationTimestamp
    private Date draftedOn;

    public Draft(DraftDTO draftDTO) {
        this.playerId = draftDTO.getPlayerId();
        this.teamId = draftDTO.getTeamId();
    }

    public Draft() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Integer playerId) {
        this.playerId = playerId;
    }

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }
}
