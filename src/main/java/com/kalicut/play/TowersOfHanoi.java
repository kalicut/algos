package com.kalicut.play;

import java.util.ArrayList;
import java.util.List;

public class TowersOfHanoi {

	private List<Integer> towerA = new ArrayList<Integer>();
	private List<Integer> towerB = new ArrayList<Integer>();
	private List<Integer> towerC = new ArrayList<Integer>();
	
	
	public void play(int numOfDisks) throws InterruptedException {
		//populate first tower
		for (int i = 1; i < numOfDisks+1; i++) {
			towerA.add(i);
		}
		
		boolean moveSmallestDisk = true;
		char towerWithSmallestDisk = 'A';
		
		int iteration = 0;

		while (true) {
			System.out.println(++iteration + " -- " + towerA.toString() + "\t\t" + towerB.toString() + "\t\t" + towerC.toString());
			if (moveSmallestDisk) {
				moveSmallestDisk = false;
				
				if (towerWithSmallestDisk == 'A') {
					towerC.add(0, towerA.get(0));
					towerA.remove(0);
					towerWithSmallestDisk = 'C';
				} else if (towerWithSmallestDisk == 'B') {
					towerA.add(0, towerB.get(0));
					towerB.remove(0);
					towerWithSmallestDisk = 'A';					
				} else {
					towerB.add(0, towerC.get(0));
					towerC.remove(0);
					towerWithSmallestDisk = 'B';					
				}
				
				if (towerB.size() == numOfDisks || towerC.size() == numOfDisks) {
					break;
				}
			} else {
				moveSmallestDisk = true;
				
				if (!towerA.isEmpty() && towerA.get(0)!=1) {
					if (towerA.get(0) % 2 == 0) {
						if(towerB.isEmpty() || towerA.get(0) < towerB.get(0)) {
							towerB.add(0, towerA.get(0));
							towerA.remove(0);
							continue;
						}
					} else {
						if(towerC.isEmpty() || towerA.get(0) < towerC.get(0)) {
							towerC.add(0, towerA.get(0));
							towerA.remove(0);
							continue;
						}			
					}
				} 
				
				if (!towerB.isEmpty() && towerB.get(0)!=1) {
					if (towerB.get(0) % 2 == 0) {
						if(towerC.isEmpty() || towerB.get(0) < towerC.get(0)) {
							towerC.add(0, towerB.get(0));
							towerB.remove(0);
							continue;
						}
					} else {
						if(towerA.isEmpty() || towerB.get(0) < towerA.get(0)) {
							towerA.add(0, towerB.get(0));
							towerB.remove(0);
							continue;
						}			
					}
				} 
				
				if (!towerC.isEmpty() && towerC.get(0)!=1) {
					if (towerC.get(0) % 2 == 0) {
						if(towerA.isEmpty() || towerC.get(0) < towerA.get(0)) {
							towerA.add(0, towerC.get(0));
							towerC.remove(0);
							continue;
						}
					} else {
						if(towerB.isEmpty() || towerC.get(0) < towerB.get(0)) {
							towerB.add(0, towerC.get(0));
							towerC.remove(0);
							continue;
						}			
					}
				}
			}

		}

		System.out.println(++iteration + " -- " + towerA.toString() + "\t\t" + towerB.toString() + "\t\t" + towerC.toString());
	}
	
	public static void main(String args[]) {
		TowersOfHanoi _towersOfHanoi = new TowersOfHanoi();
		try {
			_towersOfHanoi.play(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
