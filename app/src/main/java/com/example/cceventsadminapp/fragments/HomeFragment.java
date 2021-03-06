package com.example.cceventsadminapp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.cceventsadminapp.adapters.UpcomingEventAdapter;
import com.example.cceventsadminapp.addDialog;
import com.example.cceventsadminapp.data.Utils;
import com.example.cceventsadminapp.data.models.Event;
import com.example.cceventsadminapp.R;
import com.example.cceventsadminapp.adapters.PastEventAdapter;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment implements addDialog.OnInputSelected{
    List<Event> eventList;
    ViewPager viewPager;
    RecyclerView pastRecyclerView;
    ImageView addButton;
    public HomeFragment() {
        // Required empty public constructor
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        eventList = new ArrayList<>();
        eventList.add(new Event("Orientation Session", "", "1665018184", R.drawable.laptop));
        eventList.add(new Event("Coding", "", "1665018184", R.drawable.laptop));
        eventList.add(new Event("Coding", "", "1665018184", R.drawable.laptop));
        eventList.add(new Event("Coding", "", "1665018184", R.drawable.laptop));
        eventList.add(new Event("STL Series #3", "", "1625811304", R.drawable.laptop));
        eventList.add(new Event("STL Series #2", "", "1625811304", R.drawable.laptop));
        eventList.add(new Event("STL Series #1", "", "1625811304", R.drawable.laptop));
        eventList.add(new Event("Introduction to CP", "", "1625811304", R.drawable.laptop));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        addButton= getView().findViewById(R.id.addbutton);
        addButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                openAddDialog();

            }

        });
        initUpcomingEvents();
        initPastEvents();
    }

    private void initUpcomingEvents() {
        List<Event> upcomingEventList = new ArrayList<>();
        for (Event event : eventList) {
            if (!Utils.isPastEvent(event)) upcomingEventList.add(event);
        }
        viewPager = getView().findViewById(R.id.viewPager);
        viewPager.setAdapter(new UpcomingEventAdapter(upcomingEventList, getContext()));
//        viewPager.setPadding(130, 10, 130, 0);
    }

    private void initPastEvents() {
        List<Event> pastEventList = new ArrayList<>();
        for(Event event:eventList){
            if (Utils.isPastEvent(event)) pastEventList.add(event);
        }
        pastRecyclerView = getView().findViewById(R.id.pastRecyclerView);
        pastRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        pastRecyclerView.setAdapter(new PastEventAdapter(pastEventList));
    }
    public void openAddDialog(){
        addDialog AddDialog=new addDialog();
        AddDialog.setTargetFragment(HomeFragment.this,132);
        AddDialog.show( getChildFragmentManager(), "dialog");
    }

    @Override
    public void sendInput(String Input) {
        eventList.add(new Event(Input, "", "1665018184", R.drawable.laptop));
    }
}