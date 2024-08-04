package com.example.subscriber;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "SUBSCRIBER")
class Subscriber {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "subs_seq")
    @SequenceGenerator(name = "subs_seq", sequenceName = "SUBS_SEQ", allocationSize = 1)
    private Long id;
    private String subsc_name;
    private String subsc_surname;
    private String msisdn;
    private int tariff_id;
    private Date start_date;

    public String getName() {
        return subsc_name;
    }

    public String getSurname() {
        return subsc_surname;
    }

    public String getMsisdn() {
        return msisdn;
    }

    public int getTarifId() {
        return tariff_id;
    }

    public Date getStartDate() {
        return start_date;
    }

    public void setName(String subsc_name) {
        this.subsc_name = subsc_name;
    }

    public void setSurname(String subsc_surname) {
        this.subsc_surname = subsc_surname;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    public void setTarifId(int tariff_id) {
        this.tariff_id = tariff_id;
    }

    public void setStartDate(Date start_date) {
        this.start_date = start_date;
    }

}
