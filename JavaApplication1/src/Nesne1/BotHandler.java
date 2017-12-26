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
				Arrays.asList("Güle güle", "hoþçakalýn", "kendinize iyi bakýn","elveda"));

		ArrayList<String> whatsUpMessageList = new ArrayList<String>(
				Arrays.asList("iyilik, sizler nasýlsýnýz", "teþekkürler, sizleri sormalý","iyiyim, siz nasýlsýnýz?"));

		
		

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
		
		label.setText("Giriþ:");
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

				   } else if (uText.contains("ürün seçeceðim")||uText.contains("kategorileri görmek istiyorum")||uText.contains("alýþveriþ")) {
					// urun secimi
				       txtChat.append("AI: " + "Lütfen Kategoriyi seçiniz:" + "\n");
					   txtChat.append("    " + "1: Elektronik" + "\n");
					   txtChat.append("    " + "2: Beyaz Eþya" + "\n");
					   txtChat.append("    " + "3: Kýrtasiye" + "\n");
 
				   } else if (uText.equals("1")) {
					   txtChat.append("AI: " + "Elektronik kategorisi seçildi." + "\n");
					   txtChat.append("    " + "Ürünler:" + "\n");
					   txtChat.append("    " + "1: Cep Telefonu:" + "\n");
					   txtChat.append("    " + "2: Yazýcý:" + "\n");
					
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
								   
								   txtChat.append("AI: Bir Diðer Sýralama....\n");
								   for (CellPhone cellP : AnaMenu.cepTelefonuListesi2) {
								    	txtChat.append("AI: " + cellP.toString() +"\n");
								   }
							   }else if(uText.equals("2"))
							   {
								   for (Yazýcý yazýcý : AnaMenu.yazýcýListesi) 
									    txtChat.append("AI: " + yazýcý +"\n");
								   
								   txtChat.append("AI: Bir Diðer Sýralama....\n");
								   
								   for (Yazýcý yazýcý : AnaMenu.yazýcýListesi2) 
									    txtChat.append("AI: " + yazýcý +"\n");
							   }
								   else txtChat.append("AI:" + "Yanlýþ seçim ana menüye geri dönüldü" + "\n");
							
							   
							   txtEnter.removeActionListener(this);
						 }
						
					   });
					

		           	} else if (uText.equals("2")) {
		       		   txtChat.append("AI: " + "Beyaz Eþya kategorisi seçildi" + "\n");
					   txtChat.append("    " + "Ürünler:" + "\n");
					   txtChat.append("    " + "1: Buzdolabý:" + "\n");
					   txtEnter.addActionListener(new ActionListener()
					   {
						   @Override
						   public void actionPerformed(ActionEvent e) {
							   String uText = txtEnter.getText();
							   txtChat.append("You:" + uText + "\n");
							   txtEnter.setText("x12x22");
						    if(uText.equals("1"))
						    {
						      for (Buzdolabý buzdolabý : AnaMenu.buzdolabýListesi) {
							      txtChat.append("AI: " + buzdolabý +"\n");
						      }
						      txtChat.append("AI: Bir Diðer Sýralama....\n");
						      
						      for (Buzdolabý buzdolabý : AnaMenu.buzdolabýListesi2) {
							      txtChat.append("AI: " + buzdolabý +"\n");
						      }
						    }
						    else txtChat.append("AI:" + "Yanlýþ seçim ana menüye geri dönüldü" + "\n");
						    txtEnter.removeActionListener(this);
						   }
						   
					   });
				   } else if(uText.equals("3"))
				   {
					
					   txtChat.append("AI: " + "Kýrtasiye kategorisi seçildi" + "\n");
					   txtChat.append("    " + "Ürünler:" + "\n");
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
								   txtChat.append("AI: Bir Diðer Sýralama....\n");
								   
								   for (VersatilKalem versatilKalem : AnaMenu.versatilKalemListesi2) {
								    	txtChat.append("AI: " + versatilKalem +"\n");
								   }
							   }
							   else txtChat.append("AI:" + "Yanlýþ seçim ana menüye geri dönüldü" + "\n");
						    txtEnter.removeActionListener(this);
						   }
						   
					   });
					   
				
				   }
		       	
		       	
		       	   else if(uText.contains("güle güle")||uText.contains("hoþçakal")||uText.contains("elveda")){
		       		   decideRandom(goodByeMessageList);
		       		   
		       	   }else if(uText.contains("nasýlsýnýz")||uText.contains("naber")||uText.contains("nasýl gidiyor")){
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
