import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.StyledEditorKit.BoldAction;


public class Frame extends JFrame implements ActionListener {
    private JButton searchname = new JButton("Search By Name");
    private JButton searchid = new JButton("Search By ID");
    private JButton searchBookName = new JButton("Search By BookName");
    private JTextField nametext = new JTextField(9);
    private JTextField idtext = new JTextField(9);
    private JTextField datetext = new JTextField(9);
    private JButton addauthor=new JButton("Add Author");

    private JTextArea textarea = new JTextArea();
    private JPanel panel = new JPanel();
    private JPanel panel1 = new JPanel();
    private JPanel panel2 = new JPanel();

    public Frame() {

        textarea.setFont(new Font("Sylfaen", Font.BOLD, 16));
        textarea.setEditable(false);

        panel.setBackground(new Color(195,195,195));
        panel.setBounds(0, 30, 600, 50);
        panel.add(idtext);
        panel.add(searchid);
        panel.add(nametext);
        panel.add(searchname);
        add(panel);

        panel1.setBackground(new Color(195,195,195));
        panel1.setBounds(0, 75, 600, 40);
        panel1.add(datetext);
        panel1.add(searchBookName);
        add(panel1);

        panel2.setBackground(new Color(195,195,195));
        panel2.setBounds(5, 135, 585, 50);
        panel2.add(addauthor);
        add(panel2);

        textarea.setBounds(10, 190, 585, 420);
        textarea.setFont(new Font("Sylfaen", Font.BOLD, 18));
        textarea.setCaretPosition(0);
        add(textarea);
        searchname.addActionListener(this);
        searchid.addActionListener(this);
        searchBookName.addActionListener(this);
        addauthor.addActionListener(this);

        getContentPane().setBackground(new Color(195, 195, 195));
        setLayout(null);
        setResizable(false);
        setSize(610, 600);
        setVisible(true);
    }

    public void buttonEnablefalse() {
        idtext.setEditable(false);
        datetext.setEditable(false);
        nametext.setEditable(false);
        searchid.setEnabled(false);
        searchBookName.setEnabled(false);
        searchname.setEnabled(false);

    }

    public void showAuthor(String showAuthor) {
        textarea.setText(showAuthor + "" + textarea.getText() + "");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ArrayList<Authors> list = new ArrayList<>();
        // Search by name

        try {
            if (e.getSource() == searchname && !nametext.equals("")) {
                String s = nametext.getText();
                // buttonEnablefalse();
                searchname.setEnabled(true);
                nametext.setEditable(true);

                try {
                    Authorslist.fillAuthors();
                    for (Authors ob : Authorslist.searchbyName(s)) {
                        list.add(ob);
                        showAuthor(list + "\n");

                    }

                } catch (SQLException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }

        } catch (NumberFormatException e2) {
            // TODO: handle exception
        }

        // Search by ID

        try {
            if (e.getSource() == searchid && !idtext.equals("")) {
                String s = idtext.getText();
                int y = Integer.parseInt(idtext.getText());
                // buttonEnablefalse();
                searchid.setEnabled(true);
                idtext.setEditable(true);

                try {
                    Authorslist.fillAuthors();
                    list.add(Authorslist.searchbyID(y));
                    showAuthor(Authorslist.searchbyID(y) + "\n");

                } catch (SQLException e1) {
                    // TODO Auto-generated catch block
                    System.out.println("Insert Number");
                }

            }

        } catch (NumberFormatException e1) {
            System.out.println("insert ID");
        }

        // search by Date

        if (e.getSource() == searchBookName && !datetext.equals("")) {
            String s = datetext.getText();
            // buttonEnablefalse();
            searchBookName.setEnabled(true);
            datetext.setEditable(true);

            try {
                Authorslist.fillAuthors();

                for (Authors searchbydate : Authorslist.searchbyDate(s)) {
                    list.add(searchbydate);
                    showAuthor(list + "\n");

                }
            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                System.out.println("Problems");
            }
        }

//        if(e.getSource()==addauthor) {
//            AddAuthorFrame frame=new AddAuthorFrame();
//        }

    }
}
