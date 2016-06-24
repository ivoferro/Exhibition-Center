/**
 * Package location for UI components classes.
 */
package lapr.project.ui.components;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableCellRenderer;
import lapr.project.controller.StaffEvaluationsAnalysisController;
import lapr.project.model.ExhibitionCenter;
import lapr.project.model.StaffMemberAnalytic.ConfidenceIntervals;

/**
 * Represents a panel with the staff evaluations analysis.
 *
 * @author Daniel Gonçalves 1151452
 * @author Eric Amaral 1141570
 * @author Ivo Ferro 1151159
 * @author Renato Oliveira 1140822
 * @author Ricardo Correia 1151231
 */
public class StaffEvaluationsAnalysisPanel extends JPanel {

    /**
     * The staff evaluations analysis controller.
     */
    private final StaffEvaluationsAnalysisController controller;

    /**
     * Output Table with staff evaluations analytics.
     */
    private JTable analyticsTable;

    /**
     * ComboBox with different significance levels.
     */
    private JComboBox signLvlcomboBox;

    /**
     * Label with selected z value.
     */
    private JLabel zValueLbl;

    /**
     * prefix to z value string
     */
    private static final String PREFIX_Z_Value = "> ";

    /**
     * Padding border.
     */
    final static EmptyBorder PADDING_BORDER = new EmptyBorder(10, 10, 10, 10);

    /**
     * Constructor of a panel with the staff evaluations analysis.
     *
     * @param exhibitionCenter the exhibition center
     */
    public StaffEvaluationsAnalysisPanel(ExhibitionCenter exhibitionCenter) {
        super();

        controller = new StaffEvaluationsAnalysisController(exhibitionCenter);

        setLayout(new BorderLayout());

        add(createTopPanel(), BorderLayout.NORTH);
        add(createTable(), BorderLayout.CENTER);
    }

    /**
     * Creates a panel with significance level selection combo box.
     *
     * @return panel with significance level selection combo box
     */
    private JPanel createTopPanel() {

        JLabel signLvlLbl = new JLabel("Significance Level:", JLabel.LEADING);
        JLabel criticalRegionLbl = new JLabel("Critical Region:", JLabel.LEADING);

        signLvlcomboBox = new JComboBox(ConfidenceIntervals.values());
        // Start with a default Significance Level of 95%
        signLvlcomboBox.setSelectedIndex(1);
        signLvlcomboBox.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                updateTable();
            }
        });

        float selectedValue = ((ConfidenceIntervals) signLvlcomboBox.getSelectedItem()).zValue();
        zValueLbl = new JLabel(String.format("%s%.2f", PREFIX_Z_Value, selectedValue), JLabel.LEADING);

        JPanel topPanel = new JPanel(new GridLayout(1, 2));
        JPanel comboPanel = new JPanel();
        GroupLayout layout = new GroupLayout(comboPanel);
        comboPanel.setLayout(layout);
        layout.setAutoCreateContainerGaps(true);
        // Align horizontally
        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(signLvlLbl)
                        .addComponent(criticalRegionLbl)
                )
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(signLvlcomboBox)
                        .addComponent(zValueLbl)
                )
        );
        // Align vertically
        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(signLvlLbl)
                        .addComponent(signLvlcomboBox))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(criticalRegionLbl)
                        .addComponent(zValueLbl)
                )
        );

        topPanel.add(comboPanel);
        topPanel.add(new JPanel());

        return topPanel;
    }

    /**
     * Creates a panel with analytics table.
     *
     * @return panel with analytics table
     */
    private JScrollPane createTable() {

        analyticsTable = new JTable(new ModelTableStaffMemeberAnalytics(controller.getStaffAnalyticsList())) {

            @Override
            public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {

                int warningColumn = analyticsTable.getColumnCount() - 1;
                Component component = super.prepareRenderer(renderer, row, column);
                try {
                    String value = (String) getModel().getValueAt(row, warningColumn);
                    if (value.equals("Affirmative") && warningColumn == column) {
                        component.setForeground(Color.red);
//                        component.setBackground(Color.red);
                    } else {
                        component.setForeground(this.getForeground());
//                        component.setBackground(this.getBackground());
                    }

                } catch (Exception ex) {
                    // Do nothing
                }
                return component;
            }

        };
        updateTable();

        JScrollPane scrollPane = new JScrollPane(analyticsTable);
        scrollPane.setBorder(PADDING_BORDER);

        return scrollPane;
    }

    /**
     * Update the table information.
     */
    public void updateTable() {

        ConfidenceIntervals selectedConfInterval = (ConfidenceIntervals) signLvlcomboBox.getSelectedItem();
        float selectedValue = selectedConfInterval.zValue();
        zValueLbl.setText(String.format("%s%.2f", PREFIX_Z_Value, selectedValue));

        controller.updateWarnings(selectedConfInterval);
        analyticsTable.setModel(new ModelTableStaffMemeberAnalytics(controller.getStaffAnalyticsList()));
        analyticsTable.repaint();
    }
}
