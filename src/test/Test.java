/*
 * Created on May 9, 2018
 *
 */
package test;

import java.util.Scanner;

import javax.swing.JTextArea;

import music.Performance;
import music.Singer;
import music.Synchronizer;
import music.Voice;

public class Test {


	private Singer pattiSmith;
	private Singer bruceSpringsteen;
	private Singer u2;
	Synchronizer synch;
	
	public void initializeSingingInThreads(JTextArea textArea) {
		String lyrics1 = "Patti: Because the night";
		String lyrics2 = "Bruce: Belongs to lovers";

		String lyricsU2 = "U2: Because the night belongs to lust";

		boolean stopIt = false;
		
		synch=new Synchronizer(false, false, false, false, false, false);
		synch.setTextArea(textArea);

		Performance firstVoicePerformance = new Performance(lyrics1, 1500);
		Performance secondVoicePerformance = new Performance(lyrics2, 1500);
		Performance choirVoicePerformance = new Performance(lyricsU2, 1500);

		pattiSmith = new Singer("Patti Smith", Voice.FIRST, firstVoicePerformance, stopIt, synch);
		bruceSpringsteen = new Singer("Bruce Springsteen", Voice.SECOND, secondVoicePerformance, stopIt, synch);
		u2 = new Singer("U2", Voice.CHOIR, choirVoicePerformance, stopIt, synch);
	}

	public synchronized void startThreads() {
		pattiSmith.start();
		bruceSpringsteen.start();
		u2.start();
	}
	
	public synchronized void stopThreads() {
		pattiSmith.setStopIt(true);
		bruceSpringsteen.setStopIt(true);
		u2.setStopIt(true);
	}
	
	public synchronized void startPatti() {
		synch.setPattiActive(true);
		synch.setFirstVoiceFlag(true);
		synch.setSecondVoiceFlag(false);
		synch.setu2Flag(false);
		pattiSmith.start();
	}
	public synchronized void startBruce() {
		synch.setBruceActive(true);
		synch.setSecondVoiceFlag(true);
		synch.setFirstVoiceFlag(false);
		synch.setu2Flag(false);
		bruceSpringsteen.start();
	}
	public synchronized void startU2() {
		synch.setU2Active(true);
		synch.setu2Flag(true);
		synch.setSecondVoiceFlag(false);
		synch.setFirstVoiceFlag(false);
		u2.start();
	}
	public synchronized void stopPatti() {
		pattiSmith.setStopIt(true);
		synch.setPattiActive(false);
	}
	public synchronized void stopBruce() {
		bruceSpringsteen.setStopIt(true);
		synch.setBruceActive(false);
	}
	public synchronized void stopU2() {
		u2.setStopIt(true);
		synch.setU2Active(false);
	}
}
