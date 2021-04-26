package Client.gui;

import Server.TradeDBSource;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.HashMap;


public class AssetsTable extends JFrame {


    public AssetsTable(JPanel panel, TradeDBSource db) {

        HashMap<String, int[]> trades = db.getTrades();

        // Row data in the table
        Object tableData[] = new Object[3];

        DefaultTableModel model = new DefaultTableModel();

        // Assets Table
        JTable assetsTable = new JTable(model);

        // Column names
        model.addColumn("Asset Type");
        model.addColumn("Quantity Available");
        model.addColumn("Lowest Price per Unit");

        // Adds a row for each Asset type by cycling through the HashMap
        for(String asset : trades.keySet()) {
            model.addRow(new Object[]{asset.toString(),
                    trades.get(asset)[0],
                    trades.get(asset)[1]});
        }


        JScrollPane scrollPane = new JScrollPane(assetsTable);
        assetsTable.setAutoCreateRowSorter(true);

        // Make cells uneditable
        assetsTable.setDefaultEditor(Object.class, null);

        JButton itemHistoryBtn = new JButton("Item History");
        JPanel topTableBar = new JPanel(new FlowLayout(FlowLayout.RIGHT,10,15));
        panel.add(topTableBar, BorderLayout.NORTH);
        topTableBar.add(itemHistoryBtn);
        panel.add(scrollPane);
    }
}


