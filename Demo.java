import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Demo extends JFrame {
    ArrayList<Student> students = new ArrayList<>();

    JTextField rollField = new JTextField(10);
    JTextField nameField = new JTextField(10);
    JTextField ageField = new JTextField(10);
    JTextArea displayArea = new JTextArea(10, 30);
    JTextField searchField = new JTextField(10);

    public Demo() {
        setTitle("Student Management System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        add(new JLabel("Roll No:"));
        add(rollField);
        add(new JLabel("Name:"));
        add(nameField);
        add(new JLabel("Age:"));
        add(ageField);

        JButton addBtn = new JButton("Add Student");
        add(addBtn);

        add(new JLabel("Search Roll No:"));
        add(searchField);
        JButton searchBtn = new JButton("Search");
        add(searchBtn);

        JButton viewBtn = new JButton("View All");
        add(viewBtn);

        displayArea.setEditable(false);
        add(new JScrollPane(displayArea));

        // Add Student
        addBtn.addActionListener(e -> {
            int roll = Integer.parseInt(rollField.getText());
            String name = nameField.getText();
            int age = Integer.parseInt(ageField.getText());
            students.add(new Student(roll, name, age));
            displayArea.setText("Student Added!\n");
            rollField.setText("");
            nameField.setText("");
            ageField.setText("");
        });

        // View All
        viewBtn.addActionListener(e -> {
            displayArea.setText("");
            for (Student s : students) {
                displayArea.append(s.toString() + "\n");
            }
        });

        // Search
        searchBtn.addActionListener(e -> {
            int roll = Integer.parseInt(searchField.getText());
            boolean found = false;
            displayArea.setText("");
            for (Student s : students) {
                if (s.rollNumber == roll) {
                    displayArea.setText("Found:\n" + s.toString());
                    found = true;
                    break;
                }
            }
            if (!found) {
                displayArea.setText("Student not found.");
            }
        });

        setSize(400, 400);
        setVisible(true);
    }

    public static void main(String[] args) {
        new  Demo();
    }
}