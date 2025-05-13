/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 13202
 */
// BooksApp.java
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.sql.*;
import java.util.Vector;

public class App extends JFrame {
    // UI Components
    private JTabbedPane tabbedPane;
    private JPanel authorsPanel, titlesPanel, relationsPanel;
    
    // Authors tab components
    private JTable authorsTable;
    private DefaultTableModel authorsModel;
    private JTextField firstNameField, lastNameField;
    private JButton addAuthorBtn, updateAuthorBtn, clearAuthorBtn;
    
    // Titles tab components
    private JTable titlesTable;
    private DefaultTableModel titlesModel;
    private JTextField isbnField, titleField, editionField, copyrightField;
    private JButton addTitleBtn, clearTitleBtn;
    
    // Relations tab components
    private JComboBox<String> authorCombo, isbnCombo;
    private JTable relationsTable;
    private DefaultTableModel relationsModel;
    private JButton addRelationBtn;
    
    public App() {
        // Set up the frame
        setTitle("Books Database Management");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Create tabbed pane
        tabbedPane = new JTabbedPane();
        
        // Set up tabs
        setupAuthorsTab();
        setupTitlesTab();
        setupRelationsTab();
        
        // Add tabs to the tabbed pane
        tabbedPane.addTab("Authors", authorsPanel);
        tabbedPane.addTab("Titles", titlesPanel);
        tabbedPane.addTab("Author-ISBN Relations", relationsPanel);
        
        // Add tabbed pane to the frame
        add(tabbedPane);
        
        // Load initial data
        loadAllData();
        
        // Display the frame
        setVisible(true);
    }
    
    private void setupAuthorsTab() {
        authorsPanel = new JPanel(new BorderLayout(10, 10));
        authorsPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        // Create table model for authors
        String[] authorColumns = {"Author ID", "First Name", "Last Name"};
        authorsModel = new DefaultTableModel(authorColumns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Make table non-editable
            }
        };
        
        // Create table
        authorsTable = new JTable(authorsModel);
        authorsTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        // Add selection listener to populate fields when a row is selected
        authorsTable.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int selectedRow = authorsTable.getSelectedRow();
                if (selectedRow >= 0) {
                    firstNameField.setText(authorsTable.getValueAt(selectedRow, 1).toString());
                    lastNameField.setText(authorsTable.getValueAt(selectedRow, 2).toString());
                    updateAuthorBtn.setEnabled(true);
                }
            }
        });
        
        // Create scroll pane for the table
        JScrollPane scrollPane = new JScrollPane(authorsTable);
        authorsPanel.add(scrollPane, BorderLayout.CENTER);
        
        // Create panel for input fields
        JPanel inputPanel = new JPanel(new BorderLayout());
        
        // Create form panel
        JPanel formPanel = new JPanel(new GridLayout(2, 2, 5, 5));
        formPanel.setBorder(BorderFactory.createTitledBorder("Author Details"));
        
        formPanel.add(new JLabel("First Name:"));
        firstNameField = new JTextField(20);
        formPanel.add(firstNameField);
        
        formPanel.add(new JLabel("Last Name:"));
        lastNameField = new JTextField(20);
        formPanel.add(lastNameField);
        
        // Create button panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        
        addAuthorBtn = new JButton("Add Author");
        addAuthorBtn.addActionListener(e -> addAuthor());
        
        updateAuthorBtn = new JButton("Edit Author");
        updateAuthorBtn.addActionListener(e -> updateAuthor());
        updateAuthorBtn.setEnabled(false);
        
        clearAuthorBtn = new JButton("Clear");
        clearAuthorBtn.addActionListener(e -> {
            clearAuthorFields();
            authorsTable.clearSelection();
        });
        
        buttonPanel.add(addAuthorBtn);
        buttonPanel.add(updateAuthorBtn);
        buttonPanel.add(clearAuthorBtn);
        
        // Add components to input panel
        inputPanel.add(formPanel, BorderLayout.CENTER);
        inputPanel.add(buttonPanel, BorderLayout.SOUTH);
        
        // Add input panel to authors panel
        authorsPanel.add(inputPanel, BorderLayout.SOUTH);
    }
    
    private void setupTitlesTab() {
        titlesPanel = new JPanel(new BorderLayout(10, 10));
        titlesPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        // Create table model for titles
        String[] titleColumns = {"ISBN", "Title", "Edition", "Copyright"};
        titlesModel = new DefaultTableModel(titleColumns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Make table non-editable
            }
        };
        
        // Create table
        titlesTable = new JTable(titlesModel);
        titlesTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        // Add selection listener to populate fields when a row is selected
        titlesTable.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int selectedRow = titlesTable.getSelectedRow();
                if (selectedRow >= 0) {
                    isbnField.setText(titlesTable.getValueAt(selectedRow, 0).toString());
                    titleField.setText(titlesTable.getValueAt(selectedRow, 1).toString());
                    editionField.setText(titlesTable.getValueAt(selectedRow, 2).toString());
                    copyrightField.setText(titlesTable.getValueAt(selectedRow, 3).toString());
                    isbnField.setEditable(false); // Disable ISBN field when editing
                }
            }
        });
        
        // Create scroll pane for the table
        JScrollPane scrollPane = new JScrollPane(titlesTable);
        titlesPanel.add(scrollPane, BorderLayout.CENTER);
        
        // Create panel for input fields
        JPanel inputPanel = new JPanel(new BorderLayout());
        
        // Create form panel
        JPanel formPanel = new JPanel(new GridLayout(4, 2, 5, 5));
        formPanel.setBorder(BorderFactory.createTitledBorder("Title Details"));
        
        formPanel.add(new JLabel("ISBN:"));
        isbnField = new JTextField(20);
        formPanel.add(isbnField);
        
        formPanel.add(new JLabel("Title:"));
        titleField = new JTextField(20);
        formPanel.add(titleField);
        
        formPanel.add(new JLabel("Edition:"));
        editionField = new JTextField(20);
        formPanel.add(editionField);
        
        formPanel.add(new JLabel("Copyright:"));
        copyrightField = new JTextField(20);
        formPanel.add(copyrightField);
        
        // Create button panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        
        addTitleBtn = new JButton("Add Title");
        addTitleBtn.addActionListener(e -> addTitle());
        
        clearTitleBtn = new JButton("Clear");
        clearTitleBtn.addActionListener(e -> {
            clearTitleFields();
            titlesTable.clearSelection();
        });
        
        buttonPanel.add(addTitleBtn);
        buttonPanel.add(clearTitleBtn);
        
        // Add components to input panel
        inputPanel.add(formPanel, BorderLayout.CENTER);
        inputPanel.add(buttonPanel, BorderLayout.SOUTH);
        
        // Add input panel to titles panel
        titlesPanel.add(inputPanel, BorderLayout.SOUTH);
    }
    
    private void setupRelationsTab() {
        relationsPanel = new JPanel(new BorderLayout(10, 10));
        relationsPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        // Create panel for adding relations
        JPanel addPanel = new JPanel(new GridLayout(3, 2, 5, 5));
        addPanel.setBorder(BorderFactory.createTitledBorder("Add Author-ISBN Relation"));
        
        addPanel.add(new JLabel("Author:"));
        authorCombo = new JComboBox<>();
        addPanel.add(authorCombo);
        
        addPanel.add(new JLabel("ISBN:"));
        isbnCombo = new JComboBox<>();
        addPanel.add(isbnCombo);
        
        addRelationBtn = new JButton("Add Relation");
        addRelationBtn.addActionListener(e -> addRelation());
        
        addPanel.add(new JLabel("")); // Empty cell
        addPanel.add(addRelationBtn);
        
        // Create table model for relations
        String[] relationColumns = {"Author ID", "Author Name", "ISBN", "Title"};
        relationsModel = new DefaultTableModel(relationColumns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Make table non-editable
            }
        };
        
        // Create table
        relationsTable = new JTable(relationsModel);
        
        // Create scroll pane for the table
        JScrollPane scrollPane = new JScrollPane(relationsTable);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Existing Relations"));
        
        // Add components to relations panel
        relationsPanel.add(addPanel, BorderLayout.NORTH);
        relationsPanel.add(scrollPane, BorderLayout.CENTER);
    }
    
    private void loadAllData() {
        loadAuthors();
        loadTitles();
        loadRelations();
        loadComboBoxes();
    }
    
    private void loadAuthors() {
        authorsModel.setRowCount(0); // Clear table
        
        try (Connection conn = MySQLConnection.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT AuthorID, FirstName, LastName FROM Authors ORDER BY LastName, FirstName")) {
            
            while (rs.next()) {
                Vector<Object> row = new Vector<>();
                row.add(rs.getInt("AuthorID"));
                row.add(rs.getString("FirstName"));
                row.add(rs.getString("LastName"));
                authorsModel.addRow(row);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error loading authors: " + e.getMessage(), 
                    "Database Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
    
    private void loadTitles() {
        titlesModel.setRowCount(0); // Clear table
        
        try (Connection conn = MySQLConnection.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT ISBN, Title, EditionNumber, Copyright FROM Titles ORDER BY Title")) {
            
            while (rs.next()) {
                Vector<Object> row = new Vector<>();
                row.add(rs.getString("ISBN"));
                row.add(rs.getString("Title"));
                row.add(rs.getInt("EditionNumber"));
                row.add(rs.getString("Copyright"));
                titlesModel.addRow(row);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error loading titles: " + e.getMessage(), 
                    "Database Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
    
    private void loadRelations() {
        relationsModel.setRowCount(0); // Clear table
        
        try (Connection conn = MySQLConnection.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(
                 "SELECT a.AuthorID, a.FirstName, a.LastName, t.ISBN, t.Title " +
                 "FROM Authors a " +
                 "JOIN AuthorISBN ai ON a.AuthorID = ai.AuthorID " +
                 "JOIN Titles t ON ai.ISBN = t.ISBN " +
                 "ORDER BY a.LastName, a.FirstName, t.Title")) {
            
            while (rs.next()) {
                Vector<Object> row = new Vector<>();
                row.add(rs.getInt("AuthorID"));
                row.add(rs.getString("LastName") + ", " + rs.getString("FirstName"));
                row.add(rs.getString("ISBN"));
                row.add(rs.getString("Title"));
                relationsModel.addRow(row);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error loading relations: " + e.getMessage(), 
                    "Database Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
    
    private void loadComboBoxes() {
        authorCombo.removeAllItems();
        isbnCombo.removeAllItems();
        
        try (Connection conn = MySQLConnection.connect()) {
            // Load authors for combo box
            Statement authorStmt = conn.createStatement();
            ResultSet authorRs = authorStmt.executeQuery("SELECT AuthorID, FirstName, LastName FROM Authors ORDER BY LastName, FirstName");
            
            while (authorRs.next()) {
                int id = authorRs.getInt("AuthorID");
                String firstName = authorRs.getString("FirstName");
                String lastName = authorRs.getString("LastName");
                authorCombo.addItem(id + ": " + lastName + ", " + firstName);
            }
            
            authorRs.close();
            authorStmt.close();
            
            // Load ISBNs for combo box
            Statement isbnStmt = conn.createStatement();
            ResultSet isbnRs = isbnStmt.executeQuery("SELECT ISBN, Title FROM Titles ORDER BY Title");
            
            while (isbnRs.next()) {
                String isbn = isbnRs.getString("ISBN");
                String title = isbnRs.getString("Title");
                isbnCombo.addItem(isbn + ": " + title);
            }
            
            isbnRs.close();
            isbnStmt.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error loading combo boxes: " + e.getMessage(), 
                    "Database Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
    
    private void addAuthor() {
        String firstName = firstNameField.getText().trim();
        String lastName = lastNameField.getText().trim();
        
        if (firstName.isEmpty() || lastName.isEmpty()) {
            JOptionPane.showMessageDialog(this, "First name and last name are required.", 
                    "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        try (Connection conn = MySQLConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(
                 "INSERT INTO Authors (FirstName, LastName) VALUES (?, ?)", 
                 Statement.RETURN_GENERATED_KEYS)) {
            
            pstmt.setString(1, firstName);
            pstmt.setString(2, lastName);
            
            int affectedRows = pstmt.executeUpdate();
            
            if (affectedRows > 0) {
                JOptionPane.showMessageDialog(this, "Author added successfully.", 
                        "Success", JOptionPane.INFORMATION_MESSAGE);
                
                clearAuthorFields();
                loadAuthors();
                loadComboBoxes();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error adding author: " + e.getMessage(), 
                    "Database Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
    
    private void updateAuthor() {
        int selectedRow = authorsTable.getSelectedRow();
        
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Please select an author to update.", 
                    "Selection Required", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        int authorId = (Integer) authorsTable.getValueAt(selectedRow, 0);
        String firstName = firstNameField.getText().trim();
        String lastName = lastNameField.getText().trim();
        
        if (firstName.isEmpty() || lastName.isEmpty()) {
            JOptionPane.showMessageDialog(this, "First name and last name are required.", 
                    "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        try (Connection conn = MySQLConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(
                 "UPDATE Authors SET FirstName = ?, LastName = ? WHERE AuthorID = ?")) {
            
            pstmt.setString(1, firstName);
            pstmt.setString(2, lastName);
            pstmt.setInt(3, authorId);
            
            int affectedRows = pstmt.executeUpdate();
            
            if (affectedRows > 0) {
                JOptionPane.showMessageDialog(this, "Author updated successfully.", 
                        "Success", JOptionPane.INFORMATION_MESSAGE);
                
                clearAuthorFields();
                loadAuthors();
                loadRelations();
                loadComboBoxes();
                updateAuthorBtn.setEnabled(false);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error updating author: " + e.getMessage(), 
                    "Database Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
    
    private void addTitle() {
        String isbn = isbnField.getText().trim();
        String title = titleField.getText().trim();
        String editionStr = editionField.getText().trim();
        String copyright = copyrightField.getText().trim();
        
        if (isbn.isEmpty() || title.isEmpty() || editionStr.isEmpty() || copyright.isEmpty()) {
            JOptionPane.showMessageDialog(this, "All fields are required.", 
                    "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        int edition;
        try {
            edition = Integer.parseInt(editionStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Edition must be a number.", 
                    "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        try (Connection conn = MySQLConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(
                 "INSERT INTO Titles (ISBN, Title, EditionNumber, Copyright) VALUES (?, ?, ?, ?)")) {
            
            pstmt.setString(1, isbn);
            pstmt.setString(2, title);
            pstmt.setInt(3, edition);
            pstmt.setString(4, copyright);
            
            int affectedRows = pstmt.executeUpdate();
            
            if (affectedRows > 0) {
                JOptionPane.showMessageDialog(this, "Title added successfully.", 
                        "Success", JOptionPane.INFORMATION_MESSAGE);
                
                // Ask if user wants to link this title to an author
                int response = JOptionPane.showConfirmDialog(this, 
                        "Do you want to add an author for this title?", 
                        "Add Author Relation", JOptionPane.YES_NO_OPTION);
                
                if (response == JOptionPane.YES_OPTION) {
                    // If we have authors available
                    if (authorCombo.getItemCount() > 0) {
                        // Switch to relations tab
                        tabbedPane.setSelectedIndex(2);
                        
                        // Refresh combo boxes to include new title
                        loadComboBoxes();
                        
                        // Select the newly added ISBN in the combo box
                        for (int i = 0; i < isbnCombo.getItemCount(); i++) {
                            String item = isbnCombo.getItemAt(i).toString();
                            if (item.startsWith(isbn + ":")) {
                                isbnCombo.setSelectedIndex(i);
                                break;
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, 
                                "No authors available. Please add an author first.", 
                                "No Authors", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
                
                clearTitleFields();
                loadTitles();
                loadComboBoxes();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error adding title: " + e.getMessage(), 
                    "Database Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
    
    private void addRelation() {
        if (authorCombo.getSelectedIndex() == -1 || isbnCombo.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(this, "Please select both an author and an ISBN.", 
                    "Selection Required", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        // Extract author ID and ISBN from combo box selections
        String authorSelection = authorCombo.getSelectedItem().toString();
        String isbnSelection = isbnCombo.getSelectedItem().toString();
        
        int authorId = Integer.parseInt(authorSelection.substring(0, authorSelection.indexOf(":")));
        String isbn = isbnSelection.substring(0, isbnSelection.indexOf(":"));
        
        try (Connection conn = MySQLConnection.connect()) {
            // Check if relation already exists
            PreparedStatement checkStmt = conn.prepareStatement(
                    "SELECT COUNT(*) FROM AuthorISBN WHERE AuthorID = ? AND ISBN = ?");
            checkStmt.setInt(1, authorId);
            checkStmt.setString(2, isbn);
            ResultSet checkRs = checkStmt.executeQuery();
            
            checkRs.next();
            int count = checkRs.getInt(1);
            
            if (count > 0) {
                JOptionPane.showMessageDialog(this, "This author-ISBN relation already exists.", 
                        "Duplicate", JOptionPane.INFORMATION_MESSAGE);
                checkRs.close();
                checkStmt.close();
                return;
            }
            
            checkRs.close();
            checkStmt.close();
            
            // Add the relation
            PreparedStatement pstmt = conn.prepareStatement(
                    "INSERT INTO AuthorISBN (AuthorID, ISBN) VALUES (?, ?)");
            pstmt.setInt(1, authorId);
            pstmt.setString(2, isbn);
            
            int affectedRows = pstmt.executeUpdate();
            
            if (affectedRows > 0) {
                JOptionPane.showMessageDialog(this, "Author-ISBN relation added successfully.", 
                        "Success", JOptionPane.INFORMATION_MESSAGE);
                
                loadRelations();
            }
            
            pstmt.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error adding relation: " + e.getMessage(), 
                    "Database Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
    
    private void clearAuthorFields() {
        firstNameField.setText("");
        lastNameField.setText("");
        updateAuthorBtn.setEnabled(false);
    }
    
    private void clearTitleFields() {
        isbnField.setText("");
        titleField.setText("");
        editionField.setText("");
        copyrightField.setText("");
        isbnField.setEditable(true);
    }
}
