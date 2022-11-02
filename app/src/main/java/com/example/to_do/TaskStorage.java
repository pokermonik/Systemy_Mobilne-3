package com.example.to_do;

import java.util.ArrayList;
import java.util.UUID;

public class TaskStorage
{
    private ArrayList<Task> lista;
    private static TaskStorage taskStorage= new TaskStorage();


    private TaskStorage() {
        lista = new ArrayList();
        for (int i = 0; i < 120; i++) {
            Task task = new Task();
            task.setName("zad nr" + i);
            lista.add(task);
        }

    }
    public static TaskStorage getInstance()
    {
        return taskStorage;
    }
    public ArrayList getLista() {
        return lista;
    }
    public Task getTask(UUID indeks)
    {

        for(int i=1;i<120;i++)
        {
            if(lista.get(i).getId()==indeks)
            {
                return(lista.get(i));
            }
        }
        return null;
    };

}
