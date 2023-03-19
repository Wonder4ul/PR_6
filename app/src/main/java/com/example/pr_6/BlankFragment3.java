package com.example.pr_6;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class BlankFragment3 extends Fragment {
    private Context context;
    private final int duration = Toast.LENGTH_SHORT;

    private static final String TAG = "BlankFragment3";
    public BlankFragment3() {
        super(R.layout.fragment_blank3);
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_blank3, container, false);
    }


    ArrayList<BookInfo> books = new ArrayList<BookInfo>();

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setInitialData();
        RecyclerView recyclerView = view.findViewById(R.id.list);

        String str = getArguments().getString("key1");
        Toast.makeText(getContext(), "Добро пожаловать, " + str, Toast.LENGTH_SHORT).show();
        BookRecycleAdapter.OnBookClickListener bookClickListener = new BookRecycleAdapter.OnBookClickListener() {
            @Override
            public void onBookClick(BookInfo state, int position) {
                Bundle bundle = new Bundle();
                bundle.putString("bookName", state.getName());
                bundle.putString("author", "Somebody");
                bundle.putAll(bundle);
                Navigation.findNavController(view).navigate(R.id.action_blankFragment3_to_blankFragment4, bundle);
            }
        };
        BookRecycleAdapter adapter = new BookRecycleAdapter(getContext(), books, bookClickListener);
        recyclerView.setAdapter(adapter);
    }


    private void setInitialData(){
        for(int i=1; i<=200;i++){
            books.add(new BookInfo (String.valueOf(i), R.drawable.book_svgrepo_com));
        }

    }




}
