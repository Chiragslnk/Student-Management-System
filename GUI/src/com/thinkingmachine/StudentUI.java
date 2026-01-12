package com.thinkingmachine;
import java.net.URL;
import java.util.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;	
/*
import com.thinkingmachine.dl.dto.*;
import com.thinkingmachine.dl.dao.*;
import com.thinkingmachine.dl.exceptions.*;
import com.thinkingmachine.dl.interfaces.dao.*;
import com.thinkingmachine.dl.interfaces.dto.*;
*/
public class StudentUI extends JFrame
{
private Container container;
private JScrollPane scrollPane;
private StudentTableModel studentTableModel;
private JTable table;


public StudentUI()
{
super("Student Master");
URL location =
StudentUI.class.getResource("/com/thinkingmachine/icons/Student.jpg");
if(location == null)
{
System.out.println("Student.png NOT FOUND in classpath");
}
else
{
setIconImage(new ImageIcon(location).getImage());
}


container=getContentPane();
studentTableModel=new StudentTableModel();



JPanel searchPanel = new JPanel();
searchPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
JLabel searchLabel = new JLabel("Search:");
searchLabel.setFont(new Font("Arial", Font.BOLD, 16));
JTextField searchField = new JTextField(20);
searchField.setFont(new Font("Arial", Font.PLAIN, 15));
searchField.setForeground(Color.BLACK);


searchPanel.add(searchLabel);
searchPanel.add(searchField);
container.add(searchPanel, BorderLayout.NORTH);

searchField.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() 
{
public void insertUpdate(javax.swing.event.DocumentEvent e) 
{
search();
}
public void removeUpdate(javax.swing.event.DocumentEvent e) 
{
search();
}
public void changedUpdate(javax.swing.event.DocumentEvent e) 
{
search();
}

private void search() 
{
String partialName = searchField.getText().trim();
if (partialName.length() == 0) 
{
searchField.setForeground(Color.BLACK);
table.clearSelection();
return;
}
int index = studentTableModel.SearchPartialName(partialName);
if (index == -1) 
{
searchField.setForeground(Color.RED);
} 
else 
{
searchField.setForeground(Color.BLACK);
table.setRowSelectionInterval(index, index);
table.scrollRectToVisible(table.getCellRect(index, 0, true));
}
}
});



table=new JTable(studentTableModel); 
table.setFont(new Font("Arial", Font.PLAIN, 14));


table.setRowHeight(22);
table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
TableColumnModel tableColumnModel=table.getColumnModel();
tableColumnModel.getColumn(0).setPreferredWidth(50);
tableColumnModel.getColumn(1).setPreferredWidth(200);
tableColumnModel.getColumn(2).setPreferredWidth(300);
tableColumnModel.getColumn(3).setPreferredWidth(150);



JTableHeader header = table.getTableHeader();
header.setFont(new Font("Arial", Font.BOLD, 15));
header.setBackground(Color.DARK_GRAY);
header.setForeground(Color.WHITE);

scrollPane=new JScrollPane(table,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
// default layout is border layout
container.add(scrollPane,BorderLayout.CENTER);
setLocation(10,10);
setSize(500,650);
setDefaultCloseOperation(EXIT_ON_CLOSE);
setVisible(true);
}
}