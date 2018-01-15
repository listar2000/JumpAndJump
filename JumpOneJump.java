package com.star.JumpOneJump;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JumpOneJump extends JFrame{
	
	private int x1=0;
	private int x2=0;
	private int y1=0;
	private int y2=0;
	
	private boolean flag = false;
	
	public JumpOneJump() {
		super();
		this.setUndecorated(true);
		this.setBackground(Color.yellow);
		this.setAlwaysOnTop(true);
		this.setSize(340, 608);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(3);
		this.setOpacity(0.3f);
		
		this.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				
				if (e.getButton() == e.BUTTON1) {
					x1 = e.getX();
					y1 = e.getY();
				}
				if (e.getButton() == e.BUTTON3) {
					x2 = e.getX();
					y2 = e.getY();
				}
				
				if (x1 != 0 && x2!=0) {
					flag = true;
				}
				
				if (flag == true) {
					
					double c = Math.sqrt((y2-y1)*(y2-y1)+(x2-x1)*(x2-x1))*(1920/608);
					int end = (int) (Math.round(c)*1.393);
					System.out.println(end+"ms");
					x1 = 0;
					y1 = 0;
					x2 = 0;
					y2 = 0;
					
					flag = false;
					
					String cmd = "E:\\star_coding\\adb\\adb.exe shell input swipe 50 50 100 100 "+end;
					
					System.out.println("command: "+cmd);
					
					Runtime run = Runtime.getRuntime();
					try {
						Process process = run.exec(cmd);
			            
			        } catch (Exception h) {  
			            h.printStackTrace();  
						
					}
				}
				
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JumpOneJump jump = new JumpOneJump();
	}

}
