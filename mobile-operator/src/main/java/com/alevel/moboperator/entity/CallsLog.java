package com.alevel.moboperator.entity;

import javax.persistence.*;
import java.time.ZonedDateTime;

public class CallsLog {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "source_number", nullable = false)
    private Account source;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "target_number", nullable = false)
    private Account target;

    @Column(name = "begin_time", nullable = false)
    private ZonedDateTime begin = ZonedDateTime.now();

    @Column(name = "end_time", nullable = false)
    private ZonedDateTime end = ZonedDateTime.now();

    public CallsLog() {
    }

    public CallsLog(Account source, Account target, ZonedDateTime begin, ZonedDateTime end) {
        this.source = source;
        this.target = target;
        this.begin = begin;
        this.end = end;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Account getSource() {
        return source;
    }

    public void setSource(Account source) {
        this.source = source;
    }

    public Account getTarget() {
        return target;
    }

    public void setTarget(Account target) {
        this.target = target;
    }

    public ZonedDateTime getBegin() {
        return begin;
    }

    public void setBegin(ZonedDateTime begin) {
        this.begin = begin;
    }

    public ZonedDateTime getEnd() {
        return end;
    }

    public void setEnd(ZonedDateTime end) {
        this.end = end;
    }
}
