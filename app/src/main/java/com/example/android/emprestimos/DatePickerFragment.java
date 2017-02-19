package com.example.android.emprestimos;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

/**
 * Created by matheusmanoel on 18/02/17.
 */

public class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {

    private int CallerId;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the current date as the default date in the picker
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        // Create a new instance of DatePickerDialog and return it
        return new DatePickerDialog(getActivity(), this, year, month, day);
    }

    public void onDateSet(DatePicker view, int year, int month, int day) {

        if (this.CallerId == R.id.devolutionDateEditText) {
            EditText devolutionDate = (EditText) getActivity().findViewById(R.id.devolutionDateEditText);
            devolutionDate.setText(view.getDayOfMonth() + "/" +
                    view.getMonth() + "/" +
                    view.getYear());
        } else {
            EditText loanDate = (EditText) getActivity().findViewById(R.id.loanDateEditText);
            loanDate.setText(view.getDayOfMonth() + "/" +
                             view.getMonth() + "/" +
                             view.getYear());
        }

    }

    public void setCallerId(int callerId) {
        this.CallerId = callerId;
    }

}
