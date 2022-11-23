package com.example.dddexample;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class EmailSet {
    private Set<Email> emailSet = new HashSet<>();

    public EmailSet(Set<Email> emailSet) {
        this.emailSet.addAll(emailSet);
    }

    public Set<Emails> getEmails() {
        return Collections.unmodifiableSet(emailSet);
    }
}

