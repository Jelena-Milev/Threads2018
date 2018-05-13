package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import test.Test;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import java.awt.FlowLayout;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.Toolkit;

public class GlavniProzor extends JFrame {

	private JPanel contentPane;
	private JScrollPane scrollPaneCenter;
	private JPanel panelSouth;
	private JButton btnStart;
	private JButton btnStop;
	private JTextArea textArea;
	private GUIKontorler guiKontr;
	private JPanel panelEast;
	private JButton btnStartPatti;
	private JButton btnStartBruce;
	private JButton btnStartU;
	private JButton btnStopPatti;
	private JButton btnStopBruce;
	private JButton btnStopU;
	private JButton btnClear;
	private JButton btnRefresh;

	/**
	 * Create the frame.
	 */
	public GlavniProzor(GUIKontorler guiKontr) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(GlavniProzor.class.getResource("/music.png")));
		this.guiKontr=guiKontr;
		setTitle("Because the Night");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getScrollPaneCenter(), BorderLayout.CENTER);
		contentPane.add(getPanelSouth(), BorderLayout.SOUTH);
		contentPane.add(getPanelEast(), BorderLayout.EAST);
		guiKontr.inicijalizujThreds(getTextArea());
	}

	private JScrollPane getScrollPaneCenter() {
		if (scrollPaneCenter == null) {
			scrollPaneCenter = new JScrollPane();
			scrollPaneCenter.setViewportView(getTextArea());
		}
		return scrollPaneCenter;
	}
	private JPanel getPanelSouth() {
		if (panelSouth == null) {
			panelSouth = new JPanel();
			panelSouth.setPreferredSize(new Dimension(100, 50));
			panelSouth.setLayout(null);
			panelSouth.add(getBtnStart());
			panelSouth.add(getBtnStop());
			panelSouth.add(getBtnClear());
		}
		return panelSouth;
	}
	private JButton getBtnStart() {
		if (btnStart == null) {
			btnStart = new JButton("Start All");
			btnStart.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
//					guiKontr.inicijalizujThreds(textArea);
					
					guiKontr.getT().startU2();					
					guiKontr.getT().startBruce();
					guiKontr.getT().startPatti();
					
					btnStartU.setEnabled(false);
					btnStartBruce.setEnabled(false);
					btnStartPatti.setEnabled(false);
					
					btnStart.setEnabled(false);
				}
			});
			btnStart.setBounds(24, 12, 117, 25);
		}
		return btnStart;
	}
	private JButton getBtnStop() {
		if (btnStop == null) {
			btnStop = new JButton("Stop All");
			btnStop.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
//					guiKontr.stopThreads();
					guiKontr.getT().stopPatti();
					guiKontr.getT().stopBruce();
					guiKontr.getT().stopU2();
					btnStartBruce.setEnabled(false);
					btnStartPatti.setEnabled(false);
					btnStartU.setEnabled(false);
					btnStart.setEnabled(false);
				}
			});
			btnStop.setBounds(311, 12, 117, 25);
		}
		return btnStop;
	}
	private JTextArea getTextArea() {
		if (textArea == null) {
			textArea = new JTextArea();
		}
		return textArea;
	}
	private JPanel getPanelEast() {
		if (panelEast == null) {
			panelEast = new JPanel();
			panelEast.setPreferredSize(new Dimension(150, 50));
			panelEast.setLayout(null);
			panelEast.add(getBtnStartPatty());
			panelEast.add(getBtnStartBruce());
			panelEast.add(getBtnStartU());
			panelEast.add(getBtnStopPatti());
			panelEast.add(getBtnStopBruce());
			panelEast.add(getBtnStopU());
			panelEast.add(getBtnRefresh());
		}
		return panelEast;
	}
	private JButton getBtnStartPatty() {
		if (btnStartPatti == null) {
			btnStartPatti = new JButton("Start Patti");
			btnStartPatti.setBounds(21, 5, 108, 25);
			btnStartPatti.setBackground(UIManager.getColor("Button.background"));
			btnStartPatti.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					guiKontr.getT().startPatti();
					btnStartPatti.setEnabled(false);
					btnStart.setEnabled(false); 
				}
			});
			btnStartPatti.setHorizontalAlignment(SwingConstants.RIGHT);
		}
		return btnStartPatti;
	}
	private JButton getBtnStartBruce() {
		if (btnStartBruce == null) {
			btnStartBruce = new JButton("Start Bruce");
			btnStartBruce.setBounds(18, 35, 114, 25);
			btnStartBruce.setBackground(UIManager.getColor("Button.background"));
			btnStartBruce.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					guiKontr.getT().startBruce();
					btnStartBruce.setEnabled(false);
					btnStart.setEnabled(false); 
				}
			});
		}
		return btnStartBruce;
	}
	private JButton getBtnStartU() {
		if (btnStartU == null) {
			btnStartU = new JButton("Start U2");
			btnStartU.setBounds(29, 65, 92, 25);
			btnStartU.setBackground(UIManager.getColor("Button.background"));
			btnStartU.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					guiKontr.getT().startU2();
					btnStartU.setEnabled(false);
					btnStart.setEnabled(false); 
				}
			});
		}
		return btnStartU;
	}
	private JButton getBtnStopPatti() {
		if (btnStopPatti == null) {
			btnStopPatti = new JButton("Stop Patti");
			btnStopPatti.setBounds(21, 140, 105, 25);
			btnStopPatti.setBackground(UIManager.getColor("Button.light"));
			btnStopPatti.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					guiKontr.getT().stopPatti();
				}
			});
		}
		return btnStopPatti;
	}
	private JButton getBtnStopBruce() {
		if (btnStopBruce == null) {
			btnStopBruce = new JButton("Stop Bruce");
			btnStopBruce.setBounds(18, 170, 111, 25);
			btnStopBruce.setBackground(UIManager.getColor("Button.light"));
			btnStopBruce.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					guiKontr.getT().stopBruce();
				}
			});
		}
		return btnStopBruce;
	}
	private JButton getBtnStopU() {
		if (btnStopU == null) {
			btnStopU = new JButton("Stop U2");
			btnStopU.setBounds(29, 200, 89, 25);
			btnStopU.setBackground(UIManager.getColor("Button.light"));
			btnStopU.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					guiKontr.getT().stopU2();
				}
			});
		}
		return btnStopU;
	}
	private JButton getBtnClear() {
		if (btnClear == null) {
			btnClear = new JButton("Clear");
			btnClear.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					textArea.setText(null);
				}
			});
			btnClear.setBounds(168, 12, 117, 25);
		}
		return btnClear;
	}
	private JButton getBtnRefresh() {
		if (btnRefresh == null) {
			btnRefresh = new JButton("Refresh");
			btnRefresh.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					guiKontr.getT().stopPatti();
					guiKontr.getT().stopBruce();
					guiKontr.getT().stopU2();
					guiKontr.inicijalizujThreds(textArea);
					btnStartBruce.setEnabled(true);
					btnStartPatti.setEnabled(true);
					btnStartU.setEnabled(true);
					btnStart.setEnabled(true);
				}
			});
			btnRefresh.setBounds(29, 270, 89, 25);
		}
		return btnRefresh;
	}
}
