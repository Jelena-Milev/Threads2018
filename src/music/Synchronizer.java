/*
 * Created on May 10, 2018
 *
 */
package music;

import javax.swing.JTextArea;

public class Synchronizer {

	private boolean firstVoiceFlag;
	private boolean secondVoiceFlag;
	private boolean u2Flag;
	private JTextArea textArea;
	private boolean pattiActive;
	private boolean bruceActive;
	private boolean u2Active;

	public Synchronizer(boolean firstVoiceFlag, boolean secondVoiceFlag, boolean u2Flag, boolean pattiActive,
			boolean bruceActive, boolean u2Active) {
		super();
		this.firstVoiceFlag = firstVoiceFlag;
		this.secondVoiceFlag = secondVoiceFlag;
		this.u2Flag = u2Flag;
		this.pattiActive = pattiActive;
		this.bruceActive = bruceActive;
		this.u2Active = u2Active;
	}

	public Synchronizer(boolean firstVoiceFlag, boolean secondVoiceFlag, boolean u2Flag, JTextArea textArea) {
		super();
		this.firstVoiceFlag = firstVoiceFlag;
		this.secondVoiceFlag = secondVoiceFlag;
		this.u2Flag = u2Flag;
		this.textArea = textArea;
	}

	public Synchronizer() {

	}

	public synchronized void singFirstVoice(String lyrics, int delay) {
		while (!firstVoiceFlag) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		sing(lyrics, delay);
	}

	public synchronized void singSecondVoice(String lyrics, int delay) {
		while (!secondVoiceFlag) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		sing(lyrics, delay);
	}

	public synchronized void singChoir(String lyrics, int delay) {
		while (!u2Flag) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		sing(lyrics, delay);
	}

	private void sing(String lyrics, int delay) {
		textArea.append(lyrics + "\n");
		try {
			wait(delay);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (firstVoiceFlag) {
			if (bruceActive) {
				firstVoiceFlag = false;
				secondVoiceFlag = true;
				notifyAll();
				return;
			}
			if (!bruceActive && u2Active) {
				firstVoiceFlag = false;
				u2Flag = true;
				notifyAll();
				return;
			}
		}
		if (u2Flag) {
			if (pattiActive) {
				u2Flag = false;
				firstVoiceFlag = true;
				notifyAll();
				return;
			}
			if(!pattiActive && bruceActive) {
				u2Flag=false;
				secondVoiceFlag=true;
				notifyAll();
				return;
			}
		}
		if (secondVoiceFlag) {
			if (u2Active) {
				secondVoiceFlag = false;
				u2Flag = true;
				notifyAll();
				return;
			}
			if (!u2Active && pattiActive) {
				secondVoiceFlag = false;
				firstVoiceFlag = true;
				notifyAll();
				return;
			}
		}
		
	}

	public JTextArea getTextArea() {
		return textArea;
	}

	public void setTextArea(JTextArea textArea) {
		this.textArea = textArea;
	}

	public boolean isFirstVoiceFlag() {
		return firstVoiceFlag;
	}

	public void setFirstVoiceFlag(boolean firstVoiceFlag) {
		this.firstVoiceFlag = firstVoiceFlag;
	}

	public boolean isSecondVoiceFlag() {
		return secondVoiceFlag;
	}

	public void setSecondVoiceFlag(boolean secondVoiceFlag) {
		this.secondVoiceFlag = secondVoiceFlag;
	}

	public boolean isu2Flag() {
		return u2Flag;
	}

	public void setu2Flag(boolean choirFlag) {
		this.u2Flag = choirFlag;
	}

	public boolean isPattiActive() {
		return pattiActive;
	}

	public void setPattiActive(boolean pattiActive) {
		this.pattiActive = pattiActive;
	}

	public boolean isBruceActive() {
		return bruceActive;
	}

	public void setBruceActive(boolean bruceActive) {
		this.bruceActive = bruceActive;
	}

	public boolean isU2Active() {
		return u2Active;
	}

	public void setU2Active(boolean u2Active) {
		this.u2Active = u2Active;
	}

}
