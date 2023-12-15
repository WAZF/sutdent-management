package com.example.myapplication;

import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextView countTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner subjectSpinner = findViewById(R.id.subjectSpinner);
        ListView studentListView = findViewById(R.id.studentListView);
        TextView classNameTextView = findViewById(R.id.classNameTextView);
        countTextView = findViewById(R.id.countTextView);

        // Sample subjects for the spinner
        ArrayList<String> subjects = new ArrayList<>();
        subjects.add("Math");
        subjects.add("Science");
        subjects.add("English");
        subjects.add("Social Science");

        // Adapter for the subject spinner
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(
                this, android.R.layout.simple_spinner_item, subjects);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        subjectSpinner.setAdapter(spinnerAdapter);

        // Sample list of students
        ArrayList<String> students = new ArrayList<>();
        students.add("Student 1");
        students.add("Student 2");
        students.add("Student 3");
        students.add("Student 4");
        students.add("Student 5");
        students.add("Student 6");
        students.add("Student 7");
        // Add more students as needed

        // Adapter for the student list with checkboxes
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_multiple_choice, students);
        studentListView.setAdapter(adapter);
        studentListView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        studentListView.setOnItemClickListener((parent, view, position, id) -> updateCheckedCount(studentListView));

        // Set the class name text
        classNameTextView.setText("Class: Physics"); // Change this to your class name
    }

    private void updateCheckedCount(ListView listView) {
        int checkedCount = 0;
        SparseBooleanArray checked = listView.getCheckedItemPositions();
        for (int i = 0; i < checked.size(); i++) {
            if (checked.valueAt(i)) {
                checkedCount++;
            }
        }
        countTextView.setText("Attendance " + checkedCount);
    }
}
