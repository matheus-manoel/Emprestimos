package com.example.android.emprestimos;


import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.SQLException;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.android.emprestimos.database.DB;

import java.util.ArrayList;
import java.util.List;

import static android.app.Activity.RESULT_OK;


/**
 * A simple {@link Fragment} subclass.
 */
public class PeopleFragment extends Fragment {

    private List<Person> peopleList = new ArrayList<>();
    private RecyclerView recyclerView;
    private PeopleAdapter pAdapter;
    private DB db;
    private int indexOfDeleted;

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


        try {
            db = new DB(getContext());
        } catch (SQLException ex) {
            //// TODO: 21/02/17 add catch
        }

        peopleList.addAll(db.queryPeople(null, null));
        pAdapter.notifyDataSetChanged();

        setListeners();

        return view;
    }

    public void addPersonToList(Person p) {
        peopleList.add(p);
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
            public void onLongClick(View view, final int position) {

                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setItems(new CharSequence[]
                                {"Editar", "Deletar"},
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Person p = peopleList.get(position);
                                indexOfDeleted = position;

                                // The 'which' argument contains the index position
                                // of the selected item
                                switch (which) {
                                    case 0:
                                        Intent intent = new Intent(getContext(),
                                                CreatePersonActivity.class);
                                        intent.putExtra
                                                ("callingActivity", "PEOPLE_FRAGMENT");
                                        intent.putExtra
                                                ("EDIT_PERSON", p);
                                        startActivityForResult(intent, 1);
                                        break;
                                    case 1:
                                        db.deletePerson(p);
                                        peopleList.remove(p);

                                        pAdapter.notifyDataSetChanged();

                                        Toast.makeText(getContext(), "Deletado",
                                                Toast.LENGTH_SHORT).show();
                                        break;
                                }
                            }
                        });
                builder.create().show();

            }
        }));
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK) {
            Person p = (Person) data.getSerializableExtra("PERSON");
            db.updatePerson(p);
            peopleList.set(this.indexOfDeleted, p);
            pAdapter.notifyDataSetChanged();
            //Toast.makeText(getContext(), "Pessoa editada com sucesso.", Toast.LENGTH_SHORT);
        }
    }

}
