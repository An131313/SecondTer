package thirteen;


import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;

import javax.swing.Timer;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

import javax.swing.JPanel;

class SortingPanel extends JPanel {

	private ArrayList<Integer> numbers = new ArrayList(Arrays.asList(5, 1, 3, 2, 4));

	private static int noSortingStage = -1;
	private static int incrementIStage = 0; // not visible on animation -- nothing to show -- sravnqwane
	private static int incrementJStage = 1;
	private static int compareStage = 2; // show j and j+1
	private static int switchStage = 3; //samoto razmenqne
	private static int isSortedStage = 4;

	private int stage = noSortingStage;//do kakuv stadii na sortiraneto se e stignalo

	int currentI = -1; //dokude se e stignalo
	int currentJ = -1;
	boolean haveElementsBeenSwapedForCurrentI = false;
	
	public SortingPanel() {

	}

	public void nextStepInSorting() { //pravene na sledvachata stupka
		if (stage == isSortedStage) {
			return;
		}

		if (stage == noSortingStage) {
			stage = incrementIStage; // Initializing stage, continue directly to next stage
		}

		if (stage == incrementIStage) {
			currentI++;
			haveElementsBeenSwapedForCurrentI = false;
			stage = incrementJStage; // Initializing stage, continue directly to next stage
		}

		if (stage == incrementJStage) {
			currentJ++;
		} else if (stage == switchStage) {
			Integer numberJ = numbers.get(currentJ);
			Integer numberJPlus1 = numbers.get(currentJ + 1);
			if (numberJ > numberJPlus1) {
				haveElementsBeenSwapedForCurrentI = true;
				numbers.set(currentJ + 1, numberJ);
				numbers.set(currentJ, numberJPlus1);
			}
		}

		repaint(); //purvo che se izpulni vsichko drugo; metoda se vika posleden - 
					//zatova se vijda purvo koq e sledvachata stupka i praveneto j
					//repaint ne se vika vednaga, a kogato wsichko e dovursheno

	}

	private void nextStage() { //izchislqva se sledvachata stupka, dokune sa izvurtqni i and j-ne se pravi samata stupka
		if (stage == incrementJStage) { //ako j e uvelicheno 
			stage = compareStage;
		} else if (stage == compareStage) {
			stage = switchStage;
		} else if (stage == switchStage) {
			// allows j++ only when j will not get greater than  numbers.size() - 2- currentI (the last valid option) 
			if (currentJ < numbers.size() - 2 - currentI) { //ima li kapachitet j da se uvelichava poveche
				stage = incrementJStage; //size - 2 ---- 0 do n-1 wkluchitelno se vurti; ako ima 5 elementa i 4 sa sortiravi,  to ne trqbva da se proverqva
			} else {
				currentJ = -1; // finished comparing all pair for this iteration of i
				//System.out.println(currentI);
				// allows i++ only when i will not get greater than  numbers.size() - 2 (the last valid option) 
				if (currentI < numbers.size() - 2 && haveElementsBeenSwapedForCurrentI) {//ima li kapachitet i da se uvelichava poveche
					stage = incrementIStage; // next i
					
				} else {
					currentI = -1;
					stage = isSortedStage; // finished sorting
					repaint();
				}
			}
		}
	}

	@Override
	protected void paintComponent(Graphics g) { //izrisuvane - znaniq na stadiq - za risuvane w cheveno
		super.paintComponent(g);
		int towerWidth = ((getWidth() - 20) / numbers.size()) - 2; //kolko da e shiroko pravougulnicheto
		int towerHeghtIndex = (getHeight() - 20) / maxElement(numbers); //stoinostta po koqto da se umnoji stoinostta na elementa za da sa razlichni visochini
		int downY = getHeight() - 5; 
		for (int m = 0; m < numbers.size(); m++) { //na koi element ot masiva sme 

			// establish color
			if (stage == noSortingStage) {
				g.setColor(Color.BLACK);
			} else if (stage == isSortedStage) {
				Color myC1 = new Color (226, 36, 97); 
				g.setColor(myC1);
			} else if (m == currentJ + 1 && (stage == compareStage || stage == switchStage)) {
				g.setColor(Color.ORANGE);
			} else if (m == currentJ) {
				g.setColor(Color.ORANGE);
			} else {
				g.setColor(Color.BLACK);
			}

			int leftX = m * towerWidth + 5 * (m + 1); //tolkova nadqsno kolkoto sa bili dosega elementite + razstoqnieto za wseki element + 1 (za predi purviq)
			int rightX = leftX + towerWidth; 
			int upperY = downY - numbers.get(m) * towerHeghtIndex; // zavisi ot stoinostta na m; y raste nadolu 
			g.drawLine(leftX, downY, leftX, upperY); // left side line
			g.drawLine(leftX, upperY, rightX, upperY); // top line
			g.drawLine(rightX, downY, rightX, upperY); // right line

			g.drawString(numbers.get(m).toString(), leftX + towerWidth / 2, downY - 5); 
		}

		if (stage != noSortingStage) { //ako paint component e izvikan ot otvarqne ili resize nextStage ne se vika
			nextStage();
		}
	}

	public static Integer maxElement(ArrayList<Integer> numbers) {
		Integer max = numbers.get(0);
		for (Integer a : numbers) {
			if (a > max) {
				max = a;
			}
		}

		return max;
	}

}