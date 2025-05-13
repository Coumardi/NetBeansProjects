/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author 13202
 */
import javax.swing.*;
import java.awt.*;
import java.io.IOException;


public class NewMain extends JFrame {
    private Inverter index = new Inverter();
    private JTextArea outputArea;
    private JTextField searchField;

    public NewMain() {
        setTitle("Inverted Index GUI");
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Top Panel: Search Field and Button
        JPanel topPanel = new JPanel();
        searchField = new JTextField(20);
        JButton searchButton = new JButton("Search");
        topPanel.add(new JLabel("Enter word:"));
        topPanel.add(searchField);
        topPanel.add(searchButton);

        // Output 
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);

        // Index Button
        JPanel bottomPanel = new JPanel();
        JButton indexButton = new JButton("Show Inverted Index");
        bottomPanel.add(indexButton);

        add(topPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        // Read files ussing exception handler
        try {
            String[] files = {"file1.txt", "file2.txt"};
            FileReader fileReader = new FileReader();
            fileReader.readFiles(files, index);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error reading files.");
        }

        // Listeners
        searchButton.addActionListener(e -> {
            String search = searchField.getText().toLowerCase().trim();
            java.util.List<Integer> Id = index.search(search);
            if (Id.isEmpty()) {
                outputArea.setText("the word " + search + " NOT found in the document" );
            } else {
                outputArea.setText("the word " + search + " FOUND in the document: " + Id);
            }
        });

        indexButton.addActionListener(e -> {
            outputArea.setText(index.getIndexString());
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new NewMain().setVisible(true);
        });
    }
}
