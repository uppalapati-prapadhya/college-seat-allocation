package com.example.collegeseatallocation;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
public class CollegeSeatAllocationController {

    static final int MAX_BRANCHES = 5;
    static final int MAX_STUDENTS = 60;

    static class Student {
        int rank;
        String name;
        int[] pref = new int[MAX_BRANCHES];
    }

    @PostMapping("/allocate")
    public List<String> allocateSeats(@RequestBody List<Student> students) {
        int n = students.size();
        int[][] collegeAllotment = new int[n][MAX_BRANCHES];
        if (students == null || students.isEmpty()) {
            throw new IllegalArgumentException("Students list cannot be null or empty");
        }
        System.out.println("Received students: " + students);

        // Allocate seats logic
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < MAX_BRANCHES; j++) {
                int college = students.get(i).pref[j] / 10 - 1;
                int branch = students.get(i).pref[j] % 10 - 1;
                if (collegeAllotment[college][branch] < 60) {
                    collegeAllotment[college][branch]++;
                    break;
                }
            }
        }

        List<String> results = new ArrayList<>();
        // Output allocated seats
        for (int i = 0; i < n; i++) {
            StringBuilder result = new StringBuilder(students.get(i).rank + " " + students.get(i).name + " ");
            for (int j = 0; j < MAX_BRANCHES; j++) {
                int college = students.get(i).pref[j] / 10 - 1;
                int branch = students.get(i).pref[j] % 10 - 1;
                if (collegeAllotment[college][branch] > 0) {
                    collegeAllotment[college][branch]--;
                    result.append((college + 1)).append("-").append((branch + 1)).append(" ");
                    break;
                }
            }
            results.add(result.toString());
        }

        return results;
    }
}
