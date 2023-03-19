package com.example.pr_6;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

public class BlankFragment extends Fragment {

    private Context context;
    private final int duration = Toast.LENGTH_SHORT;
    private static final String TAG = "BlankFragment";
    public BlankFragment() {
        super(R.layout.fragment_blank);
    }

    ////

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button button = view.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Navigation.findNavController(view).navigate(R.id.action_blankFragment_to_blankFragment2);
            }
        });
        TextView text1 = view.findViewById(R.id.wc1);
        text1.setText("Добро пожаловать в GloLib!");
        TextView text2 = view.findViewById(R.id.wc2);
        text2.setText("Похоже, что у вас пока нету читательского билета!");
        TextView text3 = view.findViewById(R.id.wc3);
        text3.setText("Нажмите клавишу 'Начать', чтобы перейти на этап регистрации билета.");

        ImageView image = view.findViewById(R.id.bookImage1);
        image.setImageDrawable(getResources().getDrawable(R.drawable.book_svgrepo_com));

    }
}