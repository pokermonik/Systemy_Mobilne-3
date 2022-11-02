package com.example.to_do;

import java.util.Date;
import java.util.UUID;

public class Task
{
    private UUID id;
    private String name;
    private Date date;
    private boolean done;

    public Task()
    {
        id=UUID.randomUUID();
        date= new Date();
    }

    public boolean isDone()
    {
        return done;
    }

    public void setDone(boolean wartosc)
    {
        done=wartosc;
    }

    public void setDate(Date date)
    {
        this.date=date;
    }

    public Date getDate()
    {
        return date;
    }

    public void setName(String toString)
    {
        name=toString;
    }

    public String getName()
    {
        return name;
    }
    public UUID getId()
    {
        return id;
    }
}
