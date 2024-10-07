package com.example.thongtinnvc;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class StudentGradesFragment extends  Fragment{
    public StudentGradesFragment() {
        // Required empty public constructor
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_student_grades, container, false);

        // Danh sách điểm số mẫu
        ArrayList<Grade> grades = new ArrayList<>();
        grades.add(new Grade("Toán", "8.5"));
        grades.add(new Grade("Lý", "7.0"));
        grades.add(new Grade("Hóa", "9.0"));
        grades.add(new Grade("Anh", "6.5"));
        grades.add(new Grade("Sinh", "8.0"));

        // Tìm ListView và thiết lập Adapter
        ListView gradesListView = view.findViewById(R.id.grades_list);

        // Sử dụng getActivity() thay vì getContext()
        ArrayAdapter<Grade> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, grades);
        gradesListView.setAdapter(adapter);

        return view;
    }
    private static class Grade {
        String subject;
        String grade;

        Grade(String subject, String grade) {
            this.subject = subject;
            this.grade = grade;
        }

        @Override
        public String toString() {
            return subject + ": " + grade; // Để hiển thị đúng trên ListView
        }
    }
}

