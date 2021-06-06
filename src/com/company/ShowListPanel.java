package com.company;

// Importing the necessary to use classes and static variables

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.util.Arrays;

import static com.company.ParkingSpace.parkingPlaces;


// This class is used in order to display the information using Java Swing and to sorting functionality.
public class ShowListPanel extends JFrame {

    // Declaring the Field of the Class.
    private JFrame frame;
    private JScrollPane scrollPane;
    private JTable table;
    private JButton sortByNumberButton, sortByNameButton, sortByAreaButton, exitButton;
    private String [] names = {"Number", "Area", "Name of User", "Description"};

    public ShowListPanel(){
        // Using the JFrame constructor
        super("List of Parking Spaces");

        // Setting title for the window
        frame = new JFrame("List of Parking Spaces");

        // Initialization the JTable and assigning data
        table = new JTable(ParkingSpace.getDataFromParkingPlaces(), names);
        updateTable(table);

        // Initialization of the ScrollPane and setting its properties
        scrollPane = new JScrollPane();
        scrollPane.setViewportView(table);
        scrollPane.setBounds(10, 10, 1000, 800);

        // Initialization of the Sort By Area Button, setting font, bounds, and functionality.
        sortByAreaButton = new JButton("Sort By Area");
        sortByAreaButton.setFont(new Font("Serif", Font.ITALIC, 20));
        sortByAreaButton.setBounds(1050, 10, 200, 30);
        sortByAreaButton.addActionListener(e -> {
            ParkingSpace.setTypeOfSorting(TypeOfSorting.AREA);
            Arrays.sort(parkingPlaces);
            updateTable(table);
        });

        // Initialization of the Sort By Number Button, setting font, bounds, and functionality.
        sortByNumberButton = new JButton("Sort By Number");
        sortByNumberButton.setFont(new Font("Serif", Font.ITALIC, 20));
        sortByNumberButton.setBounds(1050, 50, 200, 30);
        sortByNumberButton.addActionListener(e -> {
            ParkingSpace.setTypeOfSorting(TypeOfSorting.NUMBER);
            Arrays.sort(parkingPlaces);
            updateTable(table);
        });

        // Initialization of the Sort By Name Button, setting font, bounds, and functionality.
        sortByNameButton = new JButton("Sort By Name");
        sortByNameButton.setFont(new Font("Serif", Font.ITALIC, 20));
        sortByNameButton.setBounds(1050, 90, 200, 30);
        sortByNameButton.addActionListener(e -> {
            ParkingSpace.setTypeOfSorting(TypeOfSorting.NAME);
            Arrays.sort(parkingPlaces);
            updateTable(table);
        });

        // Initialization of the Exit Button, setting font, bounds, and functionality.
        exitButton = new JButton("Exit Program");
        exitButton.setFont(new Font("Serif", Font.ITALIC, 20));
        exitButton.setBounds(1050, 770, 200, 30);
        exitButton.addActionListener(e -> {
            dispose();
            System.exit(0);
        });

        // Adding the components to the frame and updating its properties.
        {
            frame.add(scrollPane);
            frame.add(sortByAreaButton);
            frame.add(sortByNameButton);
            frame.add(sortByNumberButton);
            frame.add(exitButton);

            frame.setResizable(false);
            frame.setSize(1300, 900);
            frame.setLocationRelativeTo(null);
            frame.setLayout(null);
            frame.setVisible(true);
        }
    }

    // Updating the properties of the JTable. This process happens at the initialization of the class and at each query for sorting.
    private void updateTable(JTable table) {
        table.setModel(new DefaultTableModel(ParkingSpace.getDataFromParkingPlaces(), names) {
            // Setting the cells not to be editable.
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        });
        // Setting the fonts, heights of the rows, and the preferred widths of the columns.
        table.setFont(new Font("Serif", Font.PLAIN, 15));
        table.getTableHeader().setFont(new Font("Serif", Font.BOLD, 17));
        table.setRowHeight(50);
        table.getColumnModel().getColumn(0).setPreferredWidth(85);
        table.getColumnModel().getColumn(1).setPreferredWidth(100);
        table.getColumnModel().getColumn(2).setPreferredWidth(250);
        table.getColumnModel().getColumn(3).setPreferredWidth(800);
        table.getColumnModel().getColumn(3).setCellRenderer(new MyTableCellRenderer());
    }
}

// Setting a different Table Cell Renderer for the final column because of the text wrapping on multiple lines.
class MyTableCellRenderer extends JTextArea implements TableCellRenderer {
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int rowIndex, int vColIndex) {

        // Setting the value and the other parameters of the cell.
        setText((String) value);
        setText(value.toString());
        setFont(new Font("Serif", Font.PLAIN, 15));
        setLineWrap(true);
        setWrapStyleWord(true);
        setCaretPosition(0);

        // Changing the colors when selected.
        if (isSelected) {
            setForeground(table.getSelectionForeground());
            setBackground(table.getSelectionBackground());
            setForeground(table.getSelectionForeground());
            setBackground(table.getSelectionBackground());
        } else {
            setForeground(table.getForeground());
            setBackground(table.getBackground());
            setForeground(table.getForeground());
            setBackground(table.getBackground());
        }

        return this;
    }
}
