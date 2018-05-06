package group7.tcss450.uw.edu.chatapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import group7.tcss450.uw.edu.chatapp.Fragment.ChatRoomViewAdapter;
import group7.tcss450.uw.edu.chatapp.Models.ChatRoom;

public class ChatListActivity extends AppCompatActivity {
    private List<ChatRoom> chatRoomList = new ArrayList<>();
    private RecyclerView recyclerView;
    private ChatRoomViewAdapter mAdapter;
    private int mNextChatRoomId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_list);
        recyclerView = (RecyclerView) findViewById(R.id.chat_recycle_view);

        mAdapter = new ChatRoomViewAdapter(chatRoomList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        FloatingActionButton fab = findViewById(R.id.chat_list_add_button);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        prepareChatRoom();
    }

    private void prepareChatRoom() {
        ChatRoom one = new ChatRoom(1, "one", "hello", "me");
        chatRoomList.add(one);
        ChatRoom two = new ChatRoom(2, "two", "world", "me again");
        chatRoomList.add(two);
        ChatRoom three = new ChatRoom(3, "three", "this", "is");
        chatRoomList.add(three);
        ChatRoom four = new ChatRoom(4, "four", "me", "testing");
        chatRoomList.add(four);
        mAdapter.notifyDataSetChanged();
    }
}
