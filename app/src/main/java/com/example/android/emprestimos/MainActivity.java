package com.example.android.emprestimos;

import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.android.emprestimos.database.DB;
import com.example.android.emprestimos.database.DBCore;

import com.example.android.emprestimos.PeopleFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private FloatingActionButton addFab;
    private ViewPagerAdapter adapter;
    private DB db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(false);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        addFab = (FloatingActionButton) findViewById(R.id.addFab);

        try {
            db = new DB(this);
        } catch (SQLException ex) {
            //// TODO: 21/02/17 add catch
        }

        setListeners();
    }

    private void setupViewPager(ViewPager viewPager) {
        adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new AllFragment(), "TODOS");
        adapter.addFragment(new EmpresteiFragment(), "EMPRESTEI");
        adapter.addFragment(new EmprestadoFragment(), "EMPRESTADO");
        adapter.addFragment(new PeopleFragment(), "PESSOAS");
        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }

    public void setListeners() {

        addFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = tabLayout.getSelectedTabPosition();

                switch(position) {
                    case 0:
                        // first tab is selected
                        break;
                    case 1:
                        // second tab is selected
                        break;
                    case 2:
                        // third tab is selected
                        break;
                    case 3:
                        Intent intent = new Intent(getApplicationContext(),
                                CreatePersonActivity.class);
                        startActivityForResult(intent, 1);
                        break;
                }
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK) {
            Person p = (Person) data.getSerializableExtra("PERSON");
            db.insertPerson(p);
            PeopleFragment peopleFragment = (PeopleFragment) adapter.getItem(3);
            peopleFragment.addPersonToList(p);
        }
    }
}