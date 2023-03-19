package com.example.pr_6;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import java.util.Random;

public class BlankFragment2 extends Fragment {
    private Context context;
    private final int duration = Toast.LENGTH_SHORT;

    private static final String TAG = "BlankFragment2";
    public BlankFragment2() {
        super(R.layout.fragment_blank2);
    }


    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Random r = new Random();
        int randomNumber = (int)(Math.random()*100000);
        TextView ticket = view.findViewById(R.id.ticket);
        ticket.setText(String.valueOf(randomNumber));
        EditText text = view.findViewById(R.id.editTextTextPersonName);
        assert getArguments() != null;
        if(getArguments().getBoolean("checker")){
            String str = getArguments().getString("key2");
            Toast.makeText(getContext(), "Вы выбрали книгу " + str, Toast.LENGTH_SHORT).show();
        }



        Button button2 = view.findViewById(R.id.buttonToList2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString("key1", String.valueOf(text.getEditableText()));
                Navigation.findNavController(view).navigate(R.id.action_blankFragment2_to_blankFragment3, bundle);
            }
        });

    }
}