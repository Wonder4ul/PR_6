package com.example.pr_6;

import static androidx.core.content.ContextCompat.getSystemService;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.Fragment;

public class BlankFragment4 extends Fragment {
    private Context context;
    private NotificationManager notificationManager;
    private static final int NOTIFY_ID = 1;

    private static String CHANNEL_ID = "CHANNEL_ID";

    private static final String TAG = "BlankFragment4";

    public BlankFragment4() {
        super(R.layout.fragment_blank4);
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_blank4, container, false);
    }


    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView text1 = view.findViewById(R.id.BookName);
        String bookName = getArguments().getString("bookName");
        text1.setText("Название: " + bookName);
        TextView text2 = view.findViewById(R.id.NookAuthor);
        text2.setText("Автор: " + getArguments().getString("author"));

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel channel = new NotificationChannel("My Notification", "My Notification", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager = getContext().getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }

        Button addButton = view.findViewById(R.id.addButton);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NotificationCompat.Builder builder = new NotificationCompat.Builder(getContext(), "My Notification");
                        builder.setSmallIcon(R.drawable.book_svgrepo_com);
                        builder.setContentTitle("My Title");
                        builder.setContentText("Hello");
                        builder.setAutoCancel(true);
                        //.setPriority(NotificationCompat.PRIORITY_DEFAULT);
                NotificationManagerCompat managerCompat = NotificationManagerCompat.from(getContext());
                managerCompat.notify(1, builder.build());
            }
        });
    }

}
