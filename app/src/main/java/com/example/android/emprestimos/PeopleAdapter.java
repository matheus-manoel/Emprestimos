package com.example.android.emprestimos;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by matheusmanoel on 21/02/17.
 */

public class PeopleAdapter extends RecyclerView.Adapter<PeopleAdapter.MyViewHolder> {
    private List<Person> peopleList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name, howMuch, email;

        public MyViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.nameTextView);
            email = (TextView) view.findViewById(R.id.emailTextView);
            howMuch = (TextView) view.findViewById(R.id.howMuchTextView);
        }
    }


    public PeopleAdapter(List<Person> peopleList) {
        this.peopleList = peopleList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.person_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Person person = peopleList.get(position);
        holder.name.setText(person.getName());
        holder.email.setText(person.getEmail());
        holder.howMuch.setText("R$0,00");
    }

    @Override
    public int getItemCount() {
        return peopleList.size();
    }
}
