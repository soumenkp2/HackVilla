package com.example.hackvilla.fragmentclass;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hackvilla.R;
import com.example.hackvilla.customadapters.task_customadapter;
import com.example.hackvilla.modelclass.model;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Home#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Home extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Home() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Home.
     */
    // TODO: Rename and change types and number of parameters
    public static Home newInstance(String param1, String param2) {
        Home fragment = new Home();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_home, container, false);

        RecyclerView task_recyclerview = (RecyclerView) v.findViewById(R.id.task_recycle);

        task_recyclerview = (RecyclerView) v.findViewById(R.id.task_recycle);
        task_recyclerview.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false));
        task_customadapter task_adapter = new task_customadapter(dataque_task(), getContext());
        task_recyclerview.setAdapter(task_adapter);



        return v;
    }

    public ArrayList<model> dataque_task()
    {
        ArrayList<model> holder = new ArrayList<>();
        holder.add(new model(R.drawable.virus, "Inaugration", "1.20 - 2.20 pm", "Enroll"));
        holder.add(new model(R.drawable.united, "Team Formation", "3 - 4 pm", "Enroll"));
        holder.add(new model(R.drawable.subjects, "Java event", "4 - 5 pm", "Enroll"));
        holder.add(new model(R.drawable.schoolbag, "Android event", "6 - 7 pm", "Enroll"));
        holder.add(new model(R.drawable.performance, "Round-1", "8 - 9 pm", "Enroll"));
        holder.add(new model(R.drawable.celebrating, "Finals", "10 - 12 pm", "Enroll"));
        return holder;
    }
}