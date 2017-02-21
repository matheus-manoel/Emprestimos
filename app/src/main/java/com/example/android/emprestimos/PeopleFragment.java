package com.example.android.emprestimos;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class PeopleFragment extends Fragment {
    private List<Person> peopleList = new ArrayList<>();
    private RecyclerView recyclerView;
    private PeopleAdapter pAdapter;

    public PeopleFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_people, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);

        pAdapter = new PeopleAdapter(peopleList);
        RecyclerView.LayoutManager mLayoutManager =
                new LinearLayoutManager(getActivity().getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(pAdapter);

        preparePeopleData();

        return view;
    }

    private void preparePeopleData() {
        Person p1 = new Person("Matheus C. Manoel", "matheuscmanoel@gmail.com", "912939401");
        peopleList.add(p1);

        Person p2 = new Person("Fernanda Neves", "fer@gmail.com", "738494857");
        peopleList.add(p2);

        Person p3 = new Person("Carlos Pereira", "carlos@uol.com", "32132112");
        peopleList.add(p3);

        Person p4 = new Person("Pedro", "pedro2321@yahoo.com.br", "912939401");
        peopleList.add(p4);

        Person p5 = new Person("Josué", "josué@gmail.com", "912939401");
        peopleList.add(p5);

        Person p6 = new Person("Zeca Caetano", "zekinha@gmail.com", "321312312");
        peopleList.add(p6);

        Person p7 = new Person("Lenin Figueira", "lenin@gmail.com", "912939401");
        peopleList.add(p7);

        Person p8 = new Person("Carlos", "lenin@gmail.com", "912939401");
        peopleList.add(p8);

        Person p9 = new Person("João Pedro", "lenin@gmail.com", "912939401");
        peopleList.add(p9);

        Person p10 = new Person("Masquerano", "lenin@gmail.com", "912939401");
        peopleList.add(p10);

        pAdapter.notifyDataSetChanged();
    }
}
