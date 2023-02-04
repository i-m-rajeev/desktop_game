import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class TicTacToe 
{
	JFrame fr=new JFrame("Tic Tac Toe");
	JLabel la=new JLabel(new ImageIcon(getClass().getResource("images/t2.jpg")));
	JPanel [] pa=new JPanel[3];
	JLabel msg=new JLabel("First player turn...");
	JButton reset=new JButton("RESET");
	JButton [] bt=new JButton[9];
	ImageIcon icon1=new ImageIcon(getClass().getResource("images/user1.png"));
	ImageIcon icon2=new ImageIcon(getClass().getResource("images/user2.png"));
	int player=1;
	int c=0;
	public TicTacToe()
	{
		fr.setSize(600,650);
		fr.setResizable(false);
		fr.setDefaultCloseOperation(3);
		fr.setLocationRelativeTo(null);
		fr.add(la);
		addPanels();
		fr.setVisible(true);
	}
	private void addPanels()
	{
		la.setLayout(null);
		for(int i=0;i<3;i++)
		{
			pa[i]=new JPanel();
			la.add(pa[i]);
		}
		pa[0].setBounds(70,30,460,40);
		pa[0].setBackground(Color.cyan);
		pa[1].setBounds(70,100,460,400);
		pa[2].setBounds(70,530,460,40);
		pa[2].setOpaque(false);
		addComponents();
	}
	private void addComponents()
	{
		pa[0].add(msg);
		msg.setFont(new Font("elephant",0,30));
		msg.setForeground(Color.blue);
		pa[2].add(reset);
		reset.setFont(new Font("arial",0,20));
		reset.setEnabled(false);
		reset.addActionListener(new ResetListener());
		addButtons();
	}
	private void addButtons()
	{
		pa[1].setLayout(new GridLayout(3,3));
		TicListener listener=new TicListener();
		for(int i=0;i<9;i++)
		{
			bt[i]=new JButton();
			bt[i].addActionListener(listener);
			bt[i].setBackground(Color.yellow);
			pa[1].add(bt[i]);
		}
	}
	class TicListener implements ActionListener
	{
		public void actionPerformed(ActionEvent evt)
		{
			JButton bb=(JButton)evt.getSource();
			if(bb.getIcon()!=null || c==1)//when button will have image
			{
				JOptionPane.showMessageDialog(fr,"Wrong clicked");
				return;
			}
			if(player==1)
			{
				bb.setIcon(icon1);
				msg.setText("Second player turn...");
				msg.setForeground(Color.white);
				pa[0].setBackground(Color.blue);
				player=2;
			}
			else if(player==2)
			{
				bb.setIcon(icon2);
				msg.setText("First player turn...");
				msg.setForeground(Color.blue);
				pa[0].setBackground(Color.cyan);
				player=1;
			}
			findWinner();
		}
		private void findWinner()
		{
			if(bt[0].getIcon()==icon1 && bt[1].getIcon()==icon1 && bt[2].getIcon()==icon1)
				announceWinner(0,1,2,"First");
			if(bt[0].getIcon()==icon2 && bt[1].getIcon()==icon2 && bt[2].getIcon()==icon2)
				announceWinner(0,1,2,"Second");
			if(bt[3].getIcon()==icon1 && bt[4].getIcon()==icon1 && bt[5].getIcon()==icon1)
				announceWinner(3,4,5,"First");
			if(bt[3].getIcon()==icon2 && bt[4].getIcon()==icon2 && bt[5].getIcon()==icon2)
				announceWinner(3,4,5,"Second");
			if(bt[6].getIcon()==icon1 && bt[7].getIcon()==icon1 && bt[8].getIcon()==icon1)
				announceWinner(6,7,8,"First");
			if(bt[6].getIcon()==icon2 && bt[7].getIcon()==icon2 && bt[8].getIcon()==icon2)
				announceWinner(6,7,8,"Second");
			if(bt[0].getIcon()==icon1 && bt[4].getIcon()==icon1 && bt[8].getIcon()==icon1)
				announceWinner(0,4,8,"First");
			if(bt[0].getIcon()==icon2 && bt[4].getIcon()==icon2 && bt[8].getIcon()==icon2)
				announceWinner(0,4,8,"Second");
			if(bt[2].getIcon()==icon1 && bt[4].getIcon()==icon1 && bt[6].getIcon()==icon1)
					announceWinner(2,4,6,"First");
			if(bt[2].getIcon()==icon2 && bt[4].getIcon()==icon2 && bt[6].getIcon()==icon2)
					announceWinner(2,4,6,"Second");
			
		}
		private void announceWinner(int i,int j,int k,String p)
		{
			bt[i].setBackground(Color.red);
			bt[j].setBackground(Color.red);
			bt[k].setBackground(Color.red);
			c=1;
			msg.setText("Game is over...");
			pa[0].setBackground(Color.green);
			reset.setEnabled(true);
			JOptionPane.showMessageDialog(fr,p+" player won");
		}
	}
	class ResetListener implements ActionListener
	{
		public void actionPerformed(ActionEvent evt)
		{
			//clear all
			for(int i=0;i<9;i++)
			{
				bt[i].setIcon(null);
				bt[i].setBackground(Color.yellow);
			}
			player=1;
			c=0;
			msg.setText("First player turn...");
			msg.setForeground(Color.blue);
			pa[0].setBackground(Color.cyan);
			reset.setEnabled(false);
		}
	}
	public static void main(String[] args) 
	{
		new TicTacToe();
	}
}
