package thirteen;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class SortControll extends JPanel {
	private SortingPanel sortingPanel = new SortingPanel();

	private JButton nextStepBtn = new JButton("NextStep");

	public SortControll() {

		setLayout(new BorderLayout());
		sortingPanel.setBackground(Color.WHITE);
		add(sortingPanel, BorderLayout.CENTER);
		nextStepBtn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		nextStepBtn.setBackground(Color.ORANGE);
		add(nextStepBtn, BorderLayout.SOUTH);
		
		nextStepBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				sortingPanel.nextStepInSorting();
			}
		});

	}
}
