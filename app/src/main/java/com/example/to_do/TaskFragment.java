package com.example.to_do;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

import java.util.UUID;

public class TaskFragment extends Fragment
{
    private static final String ARG_TASK_ID = "com.example.to_do.arg_task_id";
    private Task task;
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        UUID taskId = (UUID) getArguments().getSerializable(ARG_TASK_ID);
        task=TaskStorage.getInstance().getTask(taskId);


    }
    public static TaskFragment newInstance(UUID taskId)
    {
        Bundle bundle = new Bundle();
        bundle.putSerializable(ARG_TASK_ID,taskId);
        TaskFragment taskFragment = new TaskFragment();
        taskFragment.setArguments(bundle);
        return taskFragment;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container)
    {
        if (container != null) {
            EditText nameField = container.findViewById(R.id.task_name);
            if (nameField != null) {

                nameField.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                        task.setName(s.toString());
                    }

                    @Override
                    public void afterTextChanged(Editable s) {

                    }
                });
            }
            Button dateButton = container.findViewById(R.id.task_date);
            if (dateButton != null) {
                dateButton.setText(task.getDate().toString());
                dateButton.setEnabled(false);
            }
            CheckBox doneCheckbox = container.findViewById(R.id.task_done);
            if (doneCheckbox != null) {
                doneCheckbox.setChecked(task.isDone());
                doneCheckbox.setOnCheckedChangeListener((buttonView, isChecked) -> {
                    task.setDone(isChecked);
                });
            }
        }
        //32 pkt moze zrobic?
        return inflater.inflate(R.layout.fragment_task,container,false);
    }

}
