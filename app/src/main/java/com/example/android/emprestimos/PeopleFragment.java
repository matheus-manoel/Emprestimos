package com.example.android.emprestimos;


import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

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
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(pAdapter);

        preparePeopleData();

        setListeners();

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

    public static interface ClickListener{
        public void onClick(View view, int position);
        public void onLongClick(View view, int position);
    }

    class RecyclerTouchListener implements RecyclerView.OnItemTouchListener{

        private ClickListener clicklistener;
        private GestureDetector gestureDetector;

        public RecyclerTouchListener(Context context, final RecyclerView recycleView, final ClickListener clicklistener){

            this.clicklistener=clicklistener;
            gestureDetector=new GestureDetector(context,new GestureDetector.SimpleOnGestureListener(){
                @Override
                public boolean onSingleTapUp(MotionEvent e) {
                    return true;
                }

                @Override
                public void onLongPress(MotionEvent e) {
                    View child=recycleView.findChildViewUnder(e.getX(),e.getY());
                    if(child!=null && clicklistener!=null){
                        clicklistener.onLongClick(child,recycleView.getChildAdapterPosition(child));
                    }
                }
            });
        }

        @Override
        public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
            View child=rv.findChildViewUnder(e.getX(),e.getY());
            if(child!=null && clicklistener!=null && gestureDetector.onTouchEvent(e)){
                clicklistener.onClick(child,rv.getChildAdapterPosition(child));
            }

            return false;
        }

        @Override
        public void onTouchEvent(RecyclerView rv, MotionEvent e) {

        }

        @Override
        public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

        }
    }

    public void setListeners() {
        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getActivity(),
                recyclerView, new ClickListener() {
            @Override
            public void onClick(View view, final int position) {
                //Values are passing to activity & to fragment as well
                Toast.makeText(getActivity(), "Single Click on position        :"+position,
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClick(View view, int position) {
                Toast.makeText(getActivity(), "Long press on position :"+position,
                        Toast.LENGTH_LONG).show();
            }
        }));
    }
}
