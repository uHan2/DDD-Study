package com.example.dddexample;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class MemberId {
    @Column(name = "member_id")
    private String id;
}
