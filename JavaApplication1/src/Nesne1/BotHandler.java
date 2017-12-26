package Nesne1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

public class BotHandler extends JFrame {
	private JTextField txtEnter = new JTextField();
	private JTextArea txtChat = new JTextArea();
	private JScrollPane sp = new JScrollPane(txtChat); 
	private JLabel label = new JLabel();

	public BotHandler() {
		ArrayList<String> exceptionMessageList = new ArrayList<String>(
				Arrays.asList("maalesef anlasilmadi...", "lutfen tekrarlar misin", "???"));

		ArrayList<String> greetingMessageList = new ArrayList<String>(
				Arrays.asList("Merhaba", "merhabalar", "mrb"));
		
		ArrayList<String> goodByeMessageList = new ArrayList<String>(
				Arrays.asList("G�le g�le", "ho��akal�n", "kendinize iyi bak�n","elveda"));

		ArrayList<String> whatsUpMessageList = new ArrayList<String>(
				Arrays.asList("iyilik, sizler nas�ls�n�z", "te�ekk�rler, sizleri sormal�","iyiyim, siz nas�ls�n�z?"));

		
		

		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.setSize(900, 630);
		this.setVisible(true);
		this.setResizable(true);
		this.setLayout(null);
		this.setTitle("Chat Bot");
			
		txtEnter.setLocation(10, 540);
		txtEnter.setSize(590, 30);
		txtEnter.requestFocusInWindow();

		txtChat.setLocation(20, 5);
		txtChat.setSize(880, 510);
		txtChat.setEditable(false);
		
		label.setText("Giri�:");
		label.setSize(50,15);
		label.setLocation(10,520);
		
		sp.setLocation(20,5);
		sp.setBounds(10,5,880,500);
		sp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		
		
		// etkilesim
		txtEnter.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String uText = txtEnter.getText();
				txtEnter.setText("");
				if(!uText.equals("x12x22"))
				{
			       txtChat.append("You:" + uText + "\n");
				   

				   if (uText.contains("selam")||uText.contains("merhaba")) {
					   
					   decideRandom(greetingMessageList);

				   } else if (uText.contains("�r�n se�ece�im")||uText.contains("kategorileri g�rmek istiyorum")||uText.contains("al��veri�")) {
					// urun secimi
				       txtChat.append("AI: " + "L�tfen Kategoriyi se�iniz:" + "\n");
					   txtChat.append("    " + "1: Elektronik" + "\n");
					   txtChat.append("    " + "2: Beyaz E�ya" + "\n");
					   txtChat.append("    " + "3: K�rtasiye" + "\n");
 
				   } else if (uText.equals("1")) {
					   txtChat.append("AI: " + "Elektronik kategorisi se�ildi." + "\n");
					   txtChat.append("    " + "�r�nler:" + "\n");
					   txtChat.append("    " + "1: Cep Telefonu:" + "\n");
					   txtChat.append("    " + "2: Yaz�c�:" + "\n");
					
					   txtEnter.addActionListener(new ActionListener()
					   {
						   @Override
						   public void actionPerformed(ActionEvent e) {
						       String uText = txtEnter.getText();
							   txtChat.append("You:" + uText + "\n");
							   txtEnter.setText("x12x22");
							   if(uText.equals("1"))
							   {
								   for (CellPhone cellP : AnaMenu.cepTelefonuListesi) {
								    	txtChat.append("AI: " + cellP.toString() +"\n");
								   }
								   
								   txtChat.append("AI: Bir Di�er S�ralama....\n");
								   for (CellPhone cellP : AnaMenu.cepTelefonuListesi2) {
								    	txtChat.append("AI: " + cellP.toString() +"\n");
								   }
							   }else if(uText.equals("2"))
							   {
								   for (Yaz�c� yaz�c� : AnaMenu.yaz�c�Listesi) 
									    txtChat.append("AI: " + yaz�c� +"\n");
								   
								   txtChat.append("AI: Bir Di�er S�ralama....\n");
								   
								   for (Yaz�c� yaz�c� : AnaMenu.yaz�c�Listesi2) 
									    txtChat.append("AI: " + yaz�c� +"\n");
							   }
								   else txtChat.append("AI:" + "Yanl�� se�im ana men�ye geri d�n�ld�" + "\n");
							
							   
							   txtEnter.removeActionListener(this);
						 }
						
					   });
					

		           	} else if (uText.equals("2")) {
		       		   txtChat.append("AI: " + "Beyaz E�ya kategorisi se�ildi" + "\n");
					   txtChat.append("    " + "�r�nler:" + "\n");
					   txtChat.append("    " + "1: Buzdolab�:" + "\n");
					   txtEnter.addActionListener(new ActionListener()
					   {
						   @Override
						   public void actionPerformed(ActionEvent e) {
							   String uText = txtEnter.getText();
							   txtChat.append("You:" + uText + "\n");
							   txtEnter.setText("x12x22");
						    if(uText.equals("1"))
						    {
						      for (Buzdolab� buzdolab� : AnaMenu.buzdolab�Listesi) {
							      txtChat.append("AI: " + buzdolab� +"\n");
						      }
						      txtChat.append("AI: Bir Di�er S�ralama....\n");
						      
						      for (Buzdolab� buzdolab� : AnaMenu.buzdolab�Listesi2) {
							      txtChat.append("AI: " + buzdolab� +"\n");
						      }
						    }
						    else txtChat.append("AI:" + "Yanl�� se�im ana men�ye geri d�n�ld�" + "\n");
						    txtEnter.removeActionListener(this);
						   }
						   
					   });
				   } else if(uText.equals("3"))
				   {
					
					   txtChat.append("AI: " + "K�rtasiye kategorisi se�ildi" + "\n");
					   txtChat.append("    " + "�r�nler:" + "\n");
					   txtChat.append("    " + "1: Versatil Kalem:" + "\n");
					   
					   txtEnter.addActionListener(new ActionListener()
					   {
						   @Override
						   public void actionPerformed(ActionEvent e) {
							   String uText = txtEnter.getText();
							   txtChat.append("You:" + uText + "\n");
							   txtEnter.setText("x12x22");
							   if(uText.equals("1"))
							   {
								   for (VersatilKalem versatilKalem : AnaMenu.versatilKalemListesi) {
								    	txtChat.append("AI: " + versatilKalem +"\n");
								   }
								   txtChat.append("AI: Bir Di�er S�ralama....\n");
								   
								   for (VersatilKalem versatilKalem : AnaMenu.versatilKalemListesi2) {
								    	txtChat.append("AI: " + versatilKalem +"\n");
								   }
							   }
							   else txtChat.append("AI:" + "Yanl�� se�im ana men�ye geri d�n�ld�" + "\n");
						    txtEnter.removeActionListener(this);
						   }
						   
					   });
					   
				
				   }
		       	
		       	
		       	   else if(uText.contains("g�le g�le")||uText.contains("ho��akal")||uText.contains("elveda")){
		       		   decideRandom(goodByeMessageList);
		       		   
		       	   }else if(uText.contains("nas�ls�n�z")||uText.contains("naber")||uText.contains("nas�l gidiyor")){
		       		   decideRandom(whatsUpMessageList);
		       		   
		       	   }else
		       	   {
					   decideRandom(exceptionMessageList);
				   }
			   }
			}
		});

		// elemanlari JFrame'e ekle
		this.add(txtEnter);
		this.getContentPane().add(sp);
		this.add(label);
	}

	private void decideRandom(ArrayList<String> messageList) {
		int decider = (int) (Math.random() * messageList.size());
		txtChat.append("AI: " + messageList.get(decider) + "\n");
	}

	public static void main(String[] args) {
		new BotHandler();
	}

}
