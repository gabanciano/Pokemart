import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class pokemartshop extends JFrame implements ActionListener
{
//é
//itemarray
	String[] martems = {"Please choose an item.","Pokéball","Great Ball","Ultra Ball","Potion","Super Potion","Hyper Potion","Antidote","Awakening","Paralyze Heal","Burn Heal","Ice Heal","Full Heal","Max Potion","Full Restore","Repel","Max Repel","Super Repel","Escape Rope"};
//delivery
	int delivernum = 0;
//Counters (per item)
	int counter1 = 0,
	counter2 = 0,
	counter3 = 0,
	counter4 = 0,
	counter5 = 0,
	counter6 = 0,
	counter7 = 0,
	counter8 = 0,
	counter9 = 0,
	counter10 = 0,
	counter11 = 0,
	counter12 = 0,
	counter13 = 0,
	counter14 = 0,
	counter15 = 0,
	counter16 = 0,
	counter17 = 0,
	counter18 = 0,
	counter19 = 0;
//Item Prices
	int totalsale = 0;
	int pokeballp = 200,
	greatballp = 600,
	ultraballp = 1200,
	potionp = 300,
	superpotionp = 700,
	hyperpotionp = 1200,
	antidotep = 100,
	paralyzhealp = 200,
	awakeningp = 250,
	burnhealp = 250,
	icehealp = 250,
	fullhealp = 1000,
	revivep = 1500,
	maxpotionp = 2500,
	fullrestorep = 3000,
	escaperopep = 550,
	repelp = 350,
	maxrepelp = 700,
	superrepelp = 500;
	
//Items Inventory
	String shopcart = "";
	int pokeball = 20,
	greatball = 20,
	ultraball = 20,
	potion = 40,
	superpotion = 30,
	hyperpotion = 30,
	maxpotion = 15,
	fullrestore = 15,
	antidote = 20,
	awakening = 20,
	burnheal = 20,
	iceheal = 20,
	paralyzeheal = 20,
	fullheal = 20,
	revive = 30,
	repel = 50,
	maxrepel = 50,
	superrepel = 50,
	escaperope = 10;
//checker
	int itemcheck1 = pokeball + delivernum,
	itemcheck2 = greatball + delivernum,
	itemcheck3 = ultraball + delivernum,
	itemcheck4 = potion + delivernum,
	itemcheck5 = superpotion + delivernum,
	itemcheck6 = hyperpotion + delivernum,
	itemcheck7 = antidote + delivernum,
	itemcheck8 = paralyzeheal + delivernum,
	itemcheck9 = awakening + delivernum,
	itemcheck10 = burnheal + delivernum,
	itemcheck11 = iceheal + delivernum,
	itemcheck12 = fullheal + delivernum,
	itemcheck13 = revive + delivernum,
	itemcheck14 = maxpotion + delivernum,
	itemcheck15 = fullrestore + delivernum,
	itemcheck16 = repel + delivernum,
	itemcheck17 = superrepel + delivernum,
	itemcheck18 = maxrepel + delivernum,
	itemcheck19 = escaperope + delivernum;
//Images
	ImageIcon icon = new ImageIcon("pokeball.png");
	Image picon = Toolkit.getDefaultToolkit().getImage("pokeicon.png");
//Tabs & Panels
	JTabbedPane tabs = new JTabbedPane();
	JPanel cashierpanel = new JPanel();
	JPanel invenpanel = new JPanel();
//Inventory
	JTextArea items = new JTextArea(5,5);
	JScrollPane itempane = new JScrollPane(items);
//Frames
	JFrame login = new JFrame();
	JFrame delivery = new JFrame();
	JFrame voidframe = new JFrame();
//Login
	JLabel title = new JLabel(new ImageIcon("titlelogo.png"));
	JLabel back = new JLabel(new ImageIcon("bckground.png"));
	JLabel usernamel = new JLabel("Username: ");
	JLabel passwordl = new JLabel("Password: ");
	JTextField userfield = new JTextField(5);
	JPasswordField passfield = new JPasswordField(5);
	JButton log = new JButton("Login");
//Void
	JLabel pass = new JLabel("Enter password: ");
	JPasswordField voidpass = new JPasswordField(10);
//Delivery
	JLabel itemdeli = new JLabel("Choose an item to add:");
	JLabel itemdeli2 = new JLabel("Enter quantity:");
	JComboBox itemdrops = new JComboBox(martems);
	JTextField addamount = new JTextField(2);
	JTextField itemset = new JTextField(5);
	
//Cashier
	JTextArea trans = new JTextArea(5,5);
	JScrollPane transpane = new JScrollPane(trans);
	JLabel imageplace = new JLabel(new ImageIcon("none.png"));
	JLabel iis = new JLabel("Items in stock:");
	JLabel total = new JLabel("Total: P " + totalsale);
	JLabel id = new JLabel("ID: ");
	JLabel itemname = new JLabel("Item name");
	JTextField identer = new JTextField(5);
	JButton addid = new JButton("Add Item");
	JButton payment = new JButton("Payment");
	JButton additems = new JButton("Add Quantity");
	JButton voidb = new JButton("Void");

	public pokemartshop()
	{
		Container x = getContentPane();
		x.setLayout(new GridLayout());
		x.add(tabs);
		{
			tabs.addTab("Cashier",null,cashierpanel,"Transactions and payments.");
			cashierpanel.setLayout(null);
			{
				cashierpanel.add(transpane);
				cashierpanel.add(id);
				cashierpanel.add(identer);
				cashierpanel.add(addid);
				cashierpanel.add(payment);
				cashierpanel.add(imageplace);
				cashierpanel.add(total);
				cashierpanel.add(itemname);
				cashierpanel.add(voidb);
				trans.setEditable(false);
				
				identer.addActionListener(this);
				addid.addActionListener(this);
				payment.addActionListener(this);
				voidb.addActionListener(this);
				voidpass.addActionListener(this);
				
				transpane.setBounds(95,5,190,190);
				id.setBounds(5,110,20,20);
				identer.setBounds(25,110,65,20);
				imageplace.setBounds(11,10,70,70);
				addid.setBounds(5,135,85,20);
				payment.setBounds(100,197,85,20);
				total.setBounds(200,197,100,20);
				itemname.setBounds(12,80,100,20);
				voidb.setBounds(5,160,85,20);
			}
			tabs.addTab("Inventory",null,invenpanel);
			invenpanel.setLayout(null);
			{
				invenpanel.add(itempane);
				items.setText("R: " + pokeball + " || 0001 - Pokéball\nR: " + greatball + " || 0002 - Great Ball\nR: " + ultraball + " || 0003 - Ultra Ball\nR: " + potion + " || 0004 - Potion\nR: " + superpotion +" || 0005 - Super Potion\nR: " + hyperpotion + " || 0006 - Hyper Potion\nR: " + antidote + " || 0007 - Antidote\nR: " + paralyzeheal + " || 0008 - Paralyze Heal\nR: " + awakening + " || 0009 - Awakening\nR: " + burnheal + " || 0010 - Burn Heal\nR: " + iceheal + " || 0011 - Ice Heal\nR: " + fullheal + " || 0012 - Full Heal\nR: " + revive + " || 0013 - Revive\nR: " + maxpotion + " || 0014 - Max Potion\nR: " + fullrestore + " || 0015 - Full Restore\nR: " + repel + " || 0016 - Repel\nR: " + superrepel + " || 0017 - Super Repel\nR: " + maxrepel + " || 0018 - Max Repel\nR: " + escaperope + " || 0019 - Escape Rope");
				items.setEditable(false);
				invenpanel.add(iis);
				invenpanel.add(additems);
				
				additems.addActionListener(this);
				
				itempane.setBounds(5,20,280,170);
				iis.setBounds(5,2,100,20);
				additems.setBounds(5,195,120,20);
			}
		}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(picon);
		setTitle("PokéMart Beta v1.9");
		setResizable(false);
		setSize(300,275);
		setLocationRelativeTo(null);

//Login 
		

		login.setIconImage(picon);
		//login.getContentPane().setBackground(Color.white);
		login.setTitle("Login");
		login.setContentPane(new JLabel(new ImageIcon("frameb.png")));
		login.setLayout(null);
		login.setSize(300,300);
		login.setLocationRelativeTo(null);
		login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		login.setVisible(true);
		
		
		login.add(title);
		login.add(usernamel);
		login.add(passwordl);
		login.add(userfield);
		login.add(passfield);
		login.add(log);
		
		userfield.addActionListener(this);
		passfield.addActionListener(this);
		log.addActionListener(this);
		
		title.setBounds(140,210,130,50);
		usernamel.setBounds(10,10,100,20);
		userfield.setBounds(10,30,100,20);
		passwordl.setBounds(10,50,100,20);
		passfield.setBounds(10,70,100,20);
		log.setBounds(10,100,100,20);
		
//Mainframe spawner
		
		
		
	}
	public void actionPerformed(ActionEvent act)
	{
		String username = userfield.getText();
		String password = passfield.getText();
		if(act.getSource() == log || act.getSource() == userfield || act.getSource() == passfield)
		{
			if(username.equals("gabanciano") && password.equals("12345"))
			{
				setVisible(true);
				login.setVisible(false);
			}	
			else
			{
				JOptionPane.showMessageDialog(null,"Invalid username or password!","Error",JOptionPane.ERROR_MESSAGE);	
			}
			
		}
		
		if(act.getSource() == addid || act.getSource() == identer)
		{
			String id = identer.getText();
			if(id.equals("0001"))
			{
				if(pokeball > 0)
				{
					shopcart = shopcart + "Pokéball                            P" + pokeballp +"\n";
					imageplace.setIcon(new ImageIcon("pokeball.png"));
					itemname.setText("1x Pokéball"); 
					trans.setText(shopcart);
					totalsale = totalsale + pokeballp;
					total.setText("Total: P " + totalsale);
					pokeball--;
					identer.setText("");
					counter1++;
					items.setText("R: " + pokeball + " || 0001 - Pokéball\nR: " + greatball + " || 0002 - Great Ball\nR: " + ultraball + " || 0003 - Ultra Ball\nR: " + potion + " || 0004 - Potion\nR: " + superpotion +" || 0005 - Super Potion\nR: " + hyperpotion + " || 0006 - Hyper Potion\nR: " + antidote + " || 0007 - Antidote\nR: " + paralyzeheal + " || 0008 - Paralyze Heal\nR: " + awakening + " || 0009 - Awakening\nR: " + burnheal + " || 0010 - Burn Heal\nR: " + iceheal + " || 0011 - Ice Heal\nR: " + fullheal + " || 0012 - Full Heal\nR: " + revive + " || 0013 - Revive\nR: " + maxpotion + " || 0014 - Max Potion\nR: " + fullrestore + " || 0015 - Full Restore\nR: " + repel + " || 0016 - Repel\nR: " + superrepel + " || 0017 - Super Repel\nR: " + maxrepel + " || 0018 - Max Repel\nR: " + escaperope + " || 0019 - Escape Rope");

				}
				else if(pokeball == 0)
				{
					JOptionPane.showMessageDialog(null,"Pokeballs are out of stock.","Error",JOptionPane.ERROR_MESSAGE);
				}
			}
			else if(id.equals("0002"))
			{
				if(greatball > 0)
				{
					shopcart = shopcart + "Great Ball                          P" + greatballp + "\n";
					imageplace.setIcon(new ImageIcon("greatball.png")); 
					itemname.setText("1x Great Ball"); 
					trans.setText(shopcart);
					totalsale = totalsale + greatballp;
					total.setText("Total: P " + totalsale);
					greatball--;
					identer.setText("");
					counter2++;
					items.setText("R: " + pokeball + " || 0001 - Pokéball\nR: " + greatball + " || 0002 - Great Ball\nR: " + ultraball + " || 0003 - Ultra Ball\nR: " + potion + " || 0004 - Potion\nR: " + superpotion +" || 0005 - Super Potion\nR: " + hyperpotion + " || 0006 - Hyper Potion\nR: " + antidote + " || 0007 - Antidote\nR: " + paralyzeheal + " || 0008 - Paralyze Heal\nR: " + awakening + " || 0009 - Awakening\nR: " + burnheal + " || 0010 - Burn Heal\nR: " + iceheal + " || 0011 - Ice Heal\nR: " + fullheal + " || 0012 - Full Heal\nR: " + revive + " || 0013 - Revive\nR: " + maxpotion + " || 0014 - Max Potion\nR: " + fullrestore + " || 0015 - Full Restore\nR: " + repel + " || 0016 - Repel\nR: " + superrepel + " || 0017 - Super Repel\nR: " + maxrepel + " || 0018 - Max Repel\nR: " + escaperope + " || 0019 - Escape Rope");

				}
				else if(greatball == 0)
				{
					JOptionPane.showMessageDialog(null,"Great Balls are out of stock.","Error",JOptionPane.ERROR_MESSAGE);
				}
			}
			else if(id.equals("0003"))
			{
				if(ultraball > 0)
				{
					shopcart = shopcart + "Ultra Ball                          P"+ ultraballp +"\n";
					imageplace.setIcon(new ImageIcon("ultraball.png")); 
					itemname.setText("1x Ultra Ball"); 
					trans.setText(shopcart);
					totalsale = totalsale + ultraballp;
					total.setText("Total: P " + totalsale);
					ultraball--;
					identer.setText("");
					counter3++;
					items.setText("R: " + pokeball + " || 0001 - Pokéball\nR: " + greatball + " || 0002 - Great Ball\nR: " + ultraball + " || 0003 - Ultra Ball\nR: " + potion + " || 0004 - Potion\nR: " + superpotion +" || 0005 - Super Potion\nR: " + hyperpotion + " || 0006 - Hyper Potion\nR: " + antidote + " || 0007 - Antidote\nR: " + paralyzeheal + " || 0008 - Paralyze Heal\nR: " + awakening + " || 0009 - Awakening\nR: " + burnheal + " || 0010 - Burn Heal\nR: " + iceheal + " || 0011 - Ice Heal\nR: " + fullheal + " || 0012 - Full Heal\nR: " + revive + " || 0013 - Revive\nR: " + maxpotion + " || 0014 - Max Potion\nR: " + fullrestore + " || 0015 - Full Restore\nR: " + repel + " || 0016 - Repel\nR: " + superrepel + " || 0017 - Super Repel\nR: " + maxrepel + " || 0018 - Max Repel\nR: " + escaperope + " || 0019 - Escape Rope");
				}
				else if(ultraball == 0)
				{
					JOptionPane.showMessageDialog(null,"Ultra Balls are out of stock.","Error",JOptionPane.ERROR_MESSAGE);
				}
			}
			else if(id.equals("0004"))
			{
				shopcart = shopcart + "Potion                                P" + potionp + "\n";
				imageplace.setIcon(new ImageIcon("potion.png")); 
				itemname.setText("1x Potion"); 
				trans.setText(shopcart);
				totalsale = totalsale + potionp;
				total.setText("Total: P " + totalsale);
				potion--;
				identer.setText("");
				counter4++;
				items.setText("R: " + pokeball + " || 0001 - Pokéball\nR: " + greatball + " || 0002 - Great Ball\nR: " + ultraball + " || 0003 - Ultra Ball\nR: " + potion + " || 0004 - Potion\nR: " + superpotion +" || 0005 - Super Potion\nR: " + hyperpotion + " || 0006 - Hyper Potion\nR: " + antidote + " || 0007 - Antidote\nR: " + paralyzeheal + " || 0008 - Paralyze Heal\nR: " + awakening + " || 0009 - Awakening\nR: " + burnheal + " || 0010 - Burn Heal\nR: " + iceheal + " || 0011 - Ice Heal\nR: " + fullheal + " || 0012 - Full Heal\nR: " + revive + " || 0013 - Revive\nR: " + maxpotion + " || 0014 - Max Potion\nR: " + fullrestore + " || 0015 - Full Restore\nR: " + repel + " || 0016 - Repel\nR: " + superrepel + " || 0017 - Super Repel\nR: " + maxrepel + " || 0018 - Max Repel\nR: " + escaperope + " || 0019 - Escape Rope");
			}
			else if(id.equals("0005"))
			{
				shopcart = shopcart + "Super Potion                    P" + superpotionp + "\n";
				imageplace.setIcon(new ImageIcon("superpotion.png"));
				itemname.setText("1x S. Potion"); 
				trans.setText(shopcart);
				totalsale = totalsale + potionp;
				total.setText("Total: P " + totalsale);
				superpotion--;
				identer.setText("");
				counter5++;
				items.setText("R: " + pokeball + " || 0001 - Pokéball\nR: " + greatball + " || 0002 - Great Ball\nR: " + ultraball + " || 0003 - Ultra Ball\nR: " + potion + " || 0004 - Potion\nR: " + superpotion +" || 0005 - Super Potion\nR: " + hyperpotion + " || 0006 - Hyper Potion\nR: " + antidote + " || 0007 - Antidote\nR: " + paralyzeheal + " || 0008 - Paralyze Heal\nR: " + awakening + " || 0009 - Awakening\nR: " + burnheal + " || 0010 - Burn Heal\nR: " + iceheal + " || 0011 - Ice Heal\nR: " + fullheal + " || 0012 - Full Heal\nR: " + revive + " || 0013 - Revive\nR: " + maxpotion + " || 0014 - Max Potion\nR: " + fullrestore + " || 0015 - Full Restore\nR: " + repel + " || 0016 - Repel\nR: " + superrepel + " || 0017 - Super Repel\nR: " + maxrepel + " || 0018 - Max Repel\nR: " + escaperope + " || 0019 - Escape Rope");
				
			}
			else if(id.equals("0006"))
			{
				shopcart = shopcart + "Hyper Potion                   P" + hyperpotionp + "\n";
				imageplace.setIcon(new ImageIcon("hyperpotion.png"));
				itemname.setText("1x H. Potion");  
				trans.setText(shopcart);
				totalsale = totalsale + potionp;
				total.setText("Total: P " + totalsale);
				hyperpotion--;
				identer.setText("");
				counter6++;
				items.setText("R: " + pokeball + " || 0001 - Pokéball\nR: " + greatball + " || 0002 - Great Ball\nR: " + ultraball + " || 0003 - Ultra Ball\nR: " + potion + " || 0004 - Potion\nR: " + superpotion +" || 0005 - Super Potion\nR: " + hyperpotion + " || 0006 - Hyper Potion\nR: " + antidote + " || 0007 - Antidote\nR: " + paralyzeheal + " || 0008 - Paralyze Heal\nR: " + awakening + " || 0009 - Awakening\nR: " + burnheal + " || 0010 - Burn Heal\nR: " + iceheal + " || 0011 - Ice Heal\nR: " + fullheal + " || 0012 - Full Heal\nR: " + revive + " || 0013 - Revive\nR: " + maxpotion + " || 0014 - Max Potion\nR: " + fullrestore + " || 0015 - Full Restore\nR: " + repel + " || 0016 - Repel\nR: " + superrepel + " || 0017 - Super Repel\nR: " + maxrepel + " || 0018 - Max Repel\nR: " + escaperope + " || 0019 - Escape Rope");

			}
			else if(id.equals("0007"))
			{
				shopcart = shopcart + "Antidote                             P" + antidotep + "\n";
				imageplace.setIcon(new ImageIcon("antidote.png")); 
				itemname.setText("1x Antidote"); 
				trans.setText(shopcart);
				totalsale = totalsale + antidotep;
				total.setText("Total: P " + totalsale);
				antidote--;
				identer.setText("");
				counter7++;
				items.setText("R: " + pokeball + " || 0001 - Pokéball\nR: " + greatball + " || 0002 - Great Ball\nR: " + ultraball + " || 0003 - Ultra Ball\nR: " + potion + " || 0004 - Potion\nR: " + superpotion +" || 0005 - Super Potion\nR: " + hyperpotion + " || 0006 - Hyper Potion\nR: " + antidote + " || 0007 - Antidote\nR: " + paralyzeheal + " || 0008 - Paralyze Heal\nR: " + awakening + " || 0009 - Awakening\nR: " + burnheal + " || 0010 - Burn Heal\nR: " + iceheal + " || 0011 - Ice Heal\nR: " + fullheal + " || 0012 - Full Heal\nR: " + revive + " || 0013 - Revive\nR: " + maxpotion + " || 0014 - Max Potion\nR: " + fullrestore + " || 0015 - Full Restore\nR: " + repel + " || 0016 - Repel\nR: " + superrepel + " || 0017 - Super Repel\nR: " + maxrepel + " || 0018 - Max Repel\nR: " + escaperope + " || 0019 - Escape Rope");

			}
			else if(id.equals("0008"))
			{
				shopcart = shopcart + "Paralyze Heal                   P" + paralyzhealp + "\n";
				imageplace.setIcon(new ImageIcon("paralyzeheal.png")); 
				itemname.setText("1x P. Heal"); 
				trans.setText(shopcart);
				totalsale = totalsale + paralyzhealp;
				total.setText("Total: P " + totalsale);
				paralyzeheal--;
				identer.setText("");
				counter8++;
				items.setText("R: " + pokeball + " || 0001 - Pokéball\nR: " + greatball + " || 0002 - Great Ball\nR: " + ultraball + " || 0003 - Ultra Ball\nR: " + potion + " || 0004 - Potion\nR: " + superpotion +" || 0005 - Super Potion\nR: " + hyperpotion + " || 0006 - Hyper Potion\nR: " + antidote + " || 0007 - Antidote\nR: " + paralyzeheal + " || 0008 - Paralyze Heal\nR: " + awakening + " || 0009 - Awakening\nR: " + burnheal + " || 0010 - Burn Heal\nR: " + iceheal + " || 0011 - Ice Heal\nR: " + fullheal + " || 0012 - Full Heal\nR: " + revive + " || 0013 - Revive\nR: " + maxpotion + " || 0014 - Max Potion\nR: " + fullrestore + " || 0015 - Full Restore\nR: " + repel + " || 0016 - Repel\nR: " + superrepel + " || 0017 - Super Repel\nR: " + maxrepel + " || 0018 - Max Repel\nR: " + escaperope + " || 0019 - Escape Rope");
			}
			else if(id.equals("0009"))
			{
				shopcart = shopcart + "Awakening                        P" + awakeningp + "\n";
				imageplace.setIcon(new ImageIcon("awakening.png")); 
				itemname.setText("1x Awakening"); 
				trans.setText(shopcart);
				totalsale = totalsale + awakeningp;
				total.setText("Total: P " + totalsale);
				awakening--;
				identer.setText("");
				counter9++;
				items.setText("R: " + pokeball + " || 0001 - Pokéball\nR: " + greatball + " || 0002 - Great Ball\nR: " + ultraball + " || 0003 - Ultra Ball\nR: " + potion + " || 0004 - Potion\nR: " + superpotion +" || 0005 - Super Potion\nR: " + hyperpotion + " || 0006 - Hyper Potion\nR: " + antidote + " || 0007 - Antidote\nR: " + paralyzeheal + " || 0008 - Paralyze Heal\nR: " + awakening + " || 0009 - Awakening\nR: " + burnheal + " || 0010 - Burn Heal\nR: " + iceheal + " || 0011 - Ice Heal\nR: " + fullheal + " || 0012 - Full Heal\nR: " + revive + " || 0013 - Revive\nR: " + maxpotion + " || 0014 - Max Potion\nR: " + fullrestore + " || 0015 - Full Restore\nR: " + repel + " || 0016 - Repel\nR: " + superrepel + " || 0017 - Super Repel\nR: " + maxrepel + " || 0018 - Max Repel\nR: " + escaperope + " || 0019 - Escape Rope");

			}
			else if(id.equals("0010"))
			{
				shopcart = shopcart + "Burn Heal                          P" + burnhealp + "\n";
				imageplace.setIcon(new ImageIcon("burnheal.png")); 
				itemname.setText("1x Burn Heal"); 
				trans.setText(shopcart);
				totalsale = totalsale + burnhealp;
				total.setText("Total: P " + totalsale);
				burnheal--;
				identer.setText("");
				counter10++;
				items.setText("R: " + pokeball + " || 0001 - Pokéball\nR: " + greatball + " || 0002 - Great Ball\nR: " + ultraball + " || 0003 - Ultra Ball\nR: " + potion + " || 0004 - Potion\nR: " + superpotion +" || 0005 - Super Potion\nR: " + hyperpotion + " || 0006 - Hyper Potion\nR: " + antidote + " || 0007 - Antidote\nR: " + paralyzeheal + " || 0008 - Paralyze Heal\nR: " + awakening + " || 0009 - Awakening\nR: " + burnheal + " || 0010 - Burn Heal\nR: " + iceheal + " || 0011 - Ice Heal\nR: " + fullheal + " || 0012 - Full Heal\nR: " + revive + " || 0013 - Revive\nR: " + maxpotion + " || 0014 - Max Potion\nR: " + fullrestore + " || 0015 - Full Restore\nR: " + repel + " || 0016 - Repel\nR: " + superrepel + " || 0017 - Super Repel\nR: " + maxrepel + " || 0018 - Max Repel\nR: " + escaperope + " || 0019 - Escape Rope");

			}
			else if(id.equals("0011"))
			{
				shopcart = shopcart + "Ice Heal                             P" + icehealp + "\n";
				imageplace.setIcon(new ImageIcon("iceheal.png")); 
				itemname.setText("1x Ice Heal"); 
				trans.setText(shopcart);
				totalsale = totalsale + icehealp;
				total.setText("Total: P " + totalsale);
				iceheal--;
				identer.setText("");
				counter11++;
				items.setText("R: " + pokeball + " || 0001 - Pokéball\nR: " + greatball + " || 0002 - Great Ball\nR: " + ultraball + " || 0003 - Ultra Ball\nR: " + potion + " || 0004 - Potion\nR: " + superpotion +" || 0005 - Super Potion\nR: " + hyperpotion + " || 0006 - Hyper Potion\nR: " + antidote + " || 0007 - Antidote\nR: " + paralyzeheal + " || 0008 - Paralyze Heal\nR: " + awakening + " || 0009 - Awakening\nR: " + burnheal + " || 0010 - Burn Heal\nR: " + iceheal + " || 0011 - Ice Heal\nR: " + fullheal + " || 0012 - Full Heal\nR: " + revive + " || 0013 - Revive\nR: " + maxpotion + " || 0014 - Max Potion\nR: " + fullrestore + " || 0015 - Full Restore\nR: " + repel + " || 0016 - Repel\nR: " + superrepel + " || 0017 - Super Repel\nR: " + maxrepel + " || 0018 - Max Repel\nR: " + escaperope + " || 0019 - Escape Rope");

			}
			else if(id.equals("0012"))
			{
				shopcart = shopcart + "Full Heal                          P" + fullhealp + "\n";
				imageplace.setIcon(new ImageIcon("fullheal.png")); 
				itemname.setText("1x Full Heal"); 
				trans.setText(shopcart);
				totalsale = totalsale + fullhealp;
				total.setText("Total: P " + totalsale);
				fullheal--;
				identer.setText("");
				counter12++;
				items.setText("R: " + pokeball + " || 0001 - Pokéball\nR: " + greatball + " || 0002 - Great Ball\nR: " + ultraball + " || 0003 - Ultra Ball\nR: " + potion + " || 0004 - Potion\nR: " + superpotion +" || 0005 - Super Potion\nR: " + hyperpotion + " || 0006 - Hyper Potion\nR: " + antidote + " || 0007 - Antidote\nR: " + paralyzeheal + " || 0008 - Paralyze Heal\nR: " + awakening + " || 0009 - Awakening\nR: " + burnheal + " || 0010 - Burn Heal\nR: " + iceheal + " || 0011 - Ice Heal\nR: " + fullheal + " || 0012 - Full Heal\nR: " + revive + " || 0013 - Revive\nR: " + maxpotion + " || 0014 - Max Potion\nR: " + fullrestore + " || 0015 - Full Restore\nR: " + repel + " || 0016 - Repel\nR: " + superrepel + " || 0017 - Super Repel\nR: " + maxrepel + " || 0018 - Max Repel\nR: " + escaperope + " || 0019 - Escape Rope");
			}
			else if(id.equals("0013"))
			{
				shopcart = shopcart + "Revive                              P" + revivep + "\n";
				imageplace.setIcon(new ImageIcon("revive.png")); 
				itemname.setText("1x Revive"); 
				trans.setText(shopcart);
				totalsale = totalsale + revivep;
				total.setText("Total: P " + totalsale);
				revive--;
				identer.setText("");
				counter13++;
				items.setText("R: " + pokeball + " || 0001 - Pokéball\nR: " + greatball + " || 0002 - Great Ball\nR: " + ultraball + " || 0003 - Ultra Ball\nR: " + potion + " || 0004 - Potion\nR: " + superpotion +" || 0005 - Super Potion\nR: " + hyperpotion + " || 0006 - Hyper Potion\nR: " + antidote + " || 0007 - Antidote\nR: " + paralyzeheal + " || 0008 - Paralyze Heal\nR: " + awakening + " || 0009 - Awakening\nR: " + burnheal + " || 0010 - Burn Heal\nR: " + iceheal + " || 0011 - Ice Heal\nR: " + fullheal + " || 0012 - Full Heal\nR: " + revive + " || 0013 - Revive\nR: " + maxpotion + " || 0014 - Max Potion\nR: " + fullrestore + " || 0015 - Full Restore\nR: " + repel + " || 0016 - Repel\nR: " + superrepel + " || 0017 - Super Repel\nR: " + maxrepel + " || 0018 - Max Repel\nR: " + escaperope + " || 0019 - Escape Rope");

			}
			else if(id.equals("0014"))
			{
				shopcart = shopcart + "Max Potion                       P" + maxpotionp + "\n";
				imageplace.setIcon(new ImageIcon("maxpotion.png")); 
				itemname.setText("1x Max Potion"); 
				trans.setText(shopcart);
				totalsale = totalsale + maxpotionp;
				total.setText("Total: P " + totalsale);
				maxpotion--;
				identer.setText("");
				counter14++;
				items.setText("R: " + pokeball + " || 0001 - Pokéball\nR: " + greatball + " || 0002 - Great Ball\nR: " + ultraball + " || 0003 - Ultra Ball\nR: " + potion + " || 0004 - Potion\nR: " + superpotion +" || 0005 - Super Potion\nR: " + hyperpotion + " || 0006 - Hyper Potion\nR: " + antidote + " || 0007 - Antidote\nR: " + paralyzeheal + " || 0008 - Paralyze Heal\nR: " + awakening + " || 0009 - Awakening\nR: " + burnheal + " || 0010 - Burn Heal\nR: " + iceheal + " || 0011 - Ice Heal\nR: " + fullheal + " || 0012 - Full Heal\nR: " + revive + " || 0013 - Revive\nR: " + maxpotion + " || 0014 - Max Potion\nR: " + fullrestore + " || 0015 - Full Restore\nR: " + repel + " || 0016 - Repel\nR: " + superrepel + " || 0017 - Super Repel\nR: " + maxrepel + " || 0018 - Max Repel\nR: " + escaperope + " || 0019 - Escape Rope");

			}
			else if(id.equals("0015"))
			{
				shopcart = shopcart + "Full Restore                     P" + fullrestorep + "\n";
				imageplace.setIcon(new ImageIcon("fullrestore.png")); 
				itemname.setText("1x F. Restore"); 
				trans.setText(shopcart);
				totalsale = totalsale + fullrestorep;
				total.setText("Total: P " + totalsale);
				fullrestore--;
				identer.setText("");
				counter15++;
				items.setText("R: " + pokeball + " || 0001 - Pokéball\nR: " + greatball + " || 0002 - Great Ball\nR: " + ultraball + " || 0003 - Ultra Ball\nR: " + potion + " || 0004 - Potion\nR: " + superpotion +" || 0005 - Super Potion\nR: " + hyperpotion + " || 0006 - Hyper Potion\nR: " + antidote + " || 0007 - Antidote\nR: " + paralyzeheal + " || 0008 - Paralyze Heal\nR: " + awakening + " || 0009 - Awakening\nR: " + burnheal + " || 0010 - Burn Heal\nR: " + iceheal + " || 0011 - Ice Heal\nR: " + fullheal + " || 0012 - Full Heal\nR: " + revive + " || 0013 - Revive\nR: " + maxpotion + " || 0014 - Max Potion\nR: " + fullrestore + " || 0015 - Full Restore\nR: " + repel + " || 0016 - Repel\nR: " + superrepel + " || 0017 - Super Repel\nR: " + maxrepel + " || 0018 - Max Repel\nR: " + escaperope + " || 0019 - Escape Rope");

			}
			else if(id.equals("0016"))
			{
				shopcart = shopcart + "Repel                              P" + repelp + "\n";
				imageplace.setIcon(new ImageIcon("repel.png")); 
				itemname.setText("1x Repel"); 
				trans.setText(shopcart);
				totalsale = totalsale + repelp;
				total.setText("Total: P " + totalsale);
				repel--;
				identer.setText("");
				counter16++;
				items.setText("R: " + pokeball + " || 0001 - Pokéball\nR: " + greatball + " || 0002 - Great Ball\nR: " + ultraball + " || 0003 - Ultra Ball\nR: " + potion + " || 0004 - Potion\nR: " + superpotion +" || 0005 - Super Potion\nR: " + hyperpotion + " || 0006 - Hyper Potion\nR: " + antidote + " || 0007 - Antidote\nR: " + paralyzeheal + " || 0008 - Paralyze Heal\nR: " + awakening + " || 0009 - Awakening\nR: " + burnheal + " || 0010 - Burn Heal\nR: " + iceheal + " || 0011 - Ice Heal\nR: " + fullheal + " || 0012 - Full Heal\nR: " + revive + " || 0013 - Revive\nR: " + maxpotion + " || 0014 - Max Potion\nR: " + fullrestore + " || 0015 - Full Restore\nR: " + repel + " || 0016 - Repel\nR: " + superrepel + " || 0017 - Super Repel\nR: " + maxrepel + " || 0018 - Max Repel\nR: " + escaperope + " || 0019 - Escape Rope");

			}
			else if(id.equals("0017"))
			{
				shopcart = shopcart + "Super Repel                        P" + superrepelp + "\n";
				imageplace.setIcon(new ImageIcon("superrepel.png")); 
				itemname.setText("1x S. Repel"); 
				trans.setText(shopcart);
				totalsale = totalsale + superrepelp;
				total.setText("Total: P " + totalsale);
				superrepel--;
				identer.setText("");
				counter17++;
				items.setText("R: " + pokeball + " || 0001 - Pokéball\nR: " + greatball + " || 0002 - Great Ball\nR: " + ultraball + " || 0003 - Ultra Ball\nR: " + potion + " || 0004 - Potion\nR: " + superpotion +" || 0005 - Super Potion\nR: " + hyperpotion + " || 0006 - Hyper Potion\nR: " + antidote + " || 0007 - Antidote\nR: " + paralyzeheal + " || 0008 - Paralyze Heal\nR: " + awakening + " || 0009 - Awakening\nR: " + burnheal + " || 0010 - Burn Heal\nR: " + iceheal + " || 0011 - Ice Heal\nR: " + fullheal + " || 0012 - Full Heal\nR: " + revive + " || 0013 - Revive\nR: " + maxpotion + " || 0014 - Max Potion\nR: " + fullrestore + " || 0015 - Full Restore\nR: " + repel + " || 0016 - Repel\nR: " + superrepel + " || 0017 - Super Repel\nR: " + maxrepel + " || 0018 - Max Repel\nR: " + escaperope + " || 0019 - Escape Rope");

			}
			else if(id.equals("0018"))
			{
				shopcart = shopcart + "Max Repel                          P" + maxrepelp + "\n";
				imageplace.setIcon(new ImageIcon("maxrepel.png")); 
				itemname.setText("1x M. Repel"); 
				trans.setText(shopcart);
				totalsale = totalsale + maxrepelp;
				total.setText("Total: P " + totalsale);
				maxrepel--;
				identer.setText("");
				counter18++;
				items.setText("R: " + pokeball + " || 0001 - Pokéball\nR: " + greatball + " || 0002 - Great Ball\nR: " + ultraball + " || 0003 - Ultra Ball\nR: " + potion + " || 0004 - Potion\nR: " + superpotion +" || 0005 - Super Potion\nR: " + hyperpotion + " || 0006 - Hyper Potion\nR: " + antidote + " || 0007 - Antidote\nR: " + paralyzeheal + " || 0008 - Paralyze Heal\nR: " + awakening + " || 0009 - Awakening\nR: " + burnheal + " || 0010 - Burn Heal\nR: " + iceheal + " || 0011 - Ice Heal\nR: " + fullheal + " || 0012 - Full Heal\nR: " + revive + " || 0013 - Revive\nR: " + maxpotion + " || 0014 - Max Potion\nR: " + fullrestore + " || 0015 - Full Restore\nR: " + repel + " || 0016 - Repel\nR: " + superrepel + " || 0017 - Super Repel\nR: " + maxrepel + " || 0018 - Max Repel\nR: " + escaperope + " || 0019 - Escape Rope");

			}
			else if(id.equals("0019"))
			{
				shopcart = shopcart + "Escape Rope                   P" + escaperopep + "\n";
				imageplace.setIcon(new ImageIcon("escaperope.png")); 
				itemname.setText("1x E. Rope"); 
				trans.setText(shopcart);
				totalsale = totalsale + escaperopep;
				total.setText("Total: P " + totalsale);
				escaperope--;
				identer.setText("");
				counter19++;
				items.setText("R: " + pokeball + " || 0001 - Pokéball\nR: " + greatball + " || 0002 - Great Ball\nR: " + ultraball + " || 0003 - Ultra Ball\nR: " + potion + " || 0004 - Potion\nR: " + superpotion +" || 0005 - Super Potion\nR: " + hyperpotion + " || 0006 - Hyper Potion\nR: " + antidote + " || 0007 - Antidote\nR: " + paralyzeheal + " || 0008 - Paralyze Heal\nR: " + awakening + " || 0009 - Awakening\nR: " + burnheal + " || 0010 - Burn Heal\nR: " + iceheal + " || 0011 - Ice Heal\nR: " + fullheal + " || 0012 - Full Heal\nR: " + revive + " || 0013 - Revive\nR: " + maxpotion + " || 0014 - Max Potion\nR: " + fullrestore + " || 0015 - Full Restore\nR: " + repel + " || 0016 - Repel\nR: " + superrepel + " || 0017 - Super Repel\nR: " + maxrepel + " || 0018 - Max Repel\nR: " + escaperope + " || 0019 - Escape Rope");

			}
			else if(id.equals("about"))
			{
				trans.setText("PokéMart v1.0\nby Gabriel Anciano\nBIT-13\n\nProject in \nComputer Programming 2");
			}
			else
			{
				JOptionPane.showMessageDialog(null,"ID or item not found in the inventory","Error",JOptionPane.ERROR_MESSAGE);
			}
		}
		if(act.getSource() == payment)
		{
			if(totalsale == 0)
			{
				JOptionPane.showMessageDialog(null,"No items found for payment","Error",JOptionPane.ERROR_MESSAGE);
			}
			else
			{
				int paymoney = Integer.parseInt(JOptionPane.showInputDialog("Enter amount tendered:"));
				if(paymoney < totalsale)
				{
					JOptionPane.showMessageDialog(null,"Insufficient funds!","Error",JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					int change = paymoney - totalsale;
					JOptionPane.showMessageDialog(null,"Your change: P" + change + "\nThank you for shopping!","Payment",JOptionPane.PLAIN_MESSAGE);
					identer.setText("");
					totalsale = 0;
					total.setText("Total: P " + totalsale);
					imageplace.setIcon(new ImageIcon("none.png"));
					trans.setText("");
					shopcart = "";
					itemname.setText("Item name");		
				}
			
			}
			
		}
		if(act.getSource() == voidb)
		{
			voidframe.setIconImage(picon);
			voidframe.setLayout(new FlowLayout());
			voidframe.setResizable(false);
			voidframe.setSize(300,60);
			voidframe.setLocationRelativeTo(null);
			voidframe.setTitle("Voiding");
			voidframe.setVisible(true);
			
			voidframe.add(pass);
			voidframe.add(voidpass);
			

		}
		if(act.getSource() == voidpass)
		{
			String voidpswrd = voidpass.getText();
			if(voidpswrd.equals("gabanciano"))
			{
				identer.setText("");
				totalsale = 0;
				total.setText("Total: P " + totalsale);
				imageplace.setIcon(new ImageIcon("none.png"));
				trans.setText("");
				shopcart = "";
				itemname.setText("Item name");
				voidpass.setText("");
				voidframe.setVisible(false);
				pokeball = pokeball + counter1;
				greatball = greatball + counter2;
				ultraball = ultraball + counter3;
				potion = potion + counter4;
				superpotion = superpotion + counter5;
				hyperpotion = hyperpotion + counter6;
				antidote = antidote + counter7;
				paralyzeheal = paralyzeheal + counter8;
				awakening = awakening + counter9;
				burnheal = burnheal + counter10;
				iceheal = iceheal + counter11;
				fullheal = fullheal + counter12;
				revive = revive + counter13;
				maxpotion = maxpotion + counter14;
				fullrestore = fullrestore + counter15;
				repel = repel + counter16;
				superrepel = superrepel + counter17;
				maxrepel = maxrepel + counter18;
				escaperope = escaperope + counter19;
				
				items.setText("R: " + pokeball + " || 0001 - Pokéball\nR: " + greatball + " || 0002 - Great Ball\nR: " + ultraball + " || 0003 - Ultra Ball\nR: " + potion + " || 0004 - Potion\nR: " + superpotion +" || 0005 - Super Potion\nR: " + hyperpotion + " || 0006 - Hyper Potion\nR: " + antidote + " || 0007 - Antidote\nR: " + paralyzeheal + " || 0008 - Paralyze Heal\nR: " + awakening + " || 0009 - Awakening\nR: " + burnheal + " || 0010 - Burn Heal\nR: " + iceheal + " || 0011 - Ice Heal\nR: " + fullheal + " || 0012 - Full Heal\nR: " + revive + " || 0013 - Revive\nR: " + maxpotion + " || 0014 - Max Potion\nR: " + fullrestore + " || 0015 - Full Restore\nR: " + repel + " || 0016 - Repel\nR: " + superrepel + " || 0017 - Super Repel\nR: " + maxrepel + " || 0018 - Max Repel\nR: " + escaperope + " || 0019 - Escape Rope");

				JOptionPane.showMessageDialog(null,"The current transaction is now void","Success",JOptionPane.INFORMATION_MESSAGE);
			}
			else
			{
				voidpass.setText("");
				JOptionPane.showMessageDialog(null,"Invalid password!","Error",JOptionPane.ERROR_MESSAGE);
			}
		}
		if(act.getSource() == additems)
		{
			delivery.setTitle("Delivery");
			delivery.setIconImage(picon);
			delivery.setLayout(null);
			delivery.setResizable(false);
			delivery.setSize(200,145);
			delivery.setLocationRelativeTo(null);
			delivery.setVisible(true);
			
			delivery.add(itemdeli);
			delivery.add(itemdrops);
			delivery.add(itemdeli2);
			delivery.add(addamount);
			delivery.add(itemset);
			
			addamount.setEditable(false);
			
			itemset.addActionListener(this);
			addamount.addActionListener(this);
			itemdrops.addActionListener(this);
			
			itemdeli.setBounds(5,5,150,20);
			itemdeli2.setBounds(5,55,150,20);
			itemset.setBounds(150,80,35,20);
			itemdrops.setBounds(10,30,175,20);
			addamount.setBounds(10,80,135,20);
		}
		if(act.getSource() == itemdrops)
		{
			String deliitem = (String)itemdrops.getSelectedItem();
			addamount.setText(deliitem);
		}
		if(act.getSource() == itemset)
		{
			String itemtext = addamount.getText();
			delivernum = Integer.parseInt(itemset.getText());
			if(itemtext.equals("Please choose an item."))
			{
				addamount.setText("");
			}
			if(itemtext.equals("Pokéball"))
			{
				if(pokeball < 99)
				{
					pokeball = pokeball + delivernum;
					JOptionPane.showMessageDialog(null,"Added " + delivernum + " stocks of Pokéballs to the inventory.","Added",JOptionPane.INFORMATION_MESSAGE);
					items.setText("R: " + pokeball + " || 0001 - Pokéball\nR: " + greatball + " || 0002 - Great Ball\nR: " + ultraball + " || 0003 - Ultra Ball\nR: " + potion + " || 0004 - Potion\nR: " + superpotion +" || 0005 - Super Potion\nR: " + hyperpotion + " || 0006 - Hyper Potion\nR: " + antidote + " || 0007 - Antidote\nR: " + paralyzeheal + " || 0008 - Paralyze Heal\nR: " + awakening + " || 0009 - Awakening\nR: " + burnheal + " || 0010 - Burn Heal\nR: " + iceheal + " || 0011 - Ice Heal\nR: " + fullheal + " || 0012 - Full Heal\nR: " + revive + " || 0013 - Revive\nR: " + maxpotion + " || 0014 - Max Potion\nR: " + fullrestore + " || 0015 - Full Restore\nR: " + repel + " || 0016 - Repel\nR: " + superrepel + " || 0017 - Super Repel\nR: " + maxrepel + " || 0018 - Max Repel\nR: " + escaperope + " || 0019 - Escape Rope");
				}
				else if(pokeball > 99)
				{
					JOptionPane.showMessageDialog(null,"The inventory can only hold 99 stocks per items!","Error",JOptionPane.ERROR_MESSAGE);
				}
			}
			if(itemtext.equals("Great Ball"))
			{
				if(itemcheck2 < 99)
				{
					greatball = greatball + delivernum;
					JOptionPane.showMessageDialog(null,"Added " + delivernum + " stocks of Great Balls to the inventory.","Added",JOptionPane.INFORMATION_MESSAGE);
					items.setText("R: " + pokeball + " || 0001 - Pokéball\nR: " + greatball + " || 0002 - Great Ball\nR: " + ultraball + " || 0003 - Ultra Ball\nR: " + potion + " || 0004 - Potion\nR: " + superpotion +" || 0005 - Super Potion\nR: " + hyperpotion + " || 0006 - Hyper Potion\nR: " + antidote + " || 0007 - Antidote\nR: " + paralyzeheal + " || 0008 - Paralyze Heal\nR: " + awakening + " || 0009 - Awakening\nR: " + burnheal + " || 0010 - Burn Heal\nR: " + iceheal + " || 0011 - Ice Heal\nR: " + fullheal + " || 0012 - Full Heal\nR: " + revive + " || 0013 - Revive\nR: " + maxpotion + " || 0014 - Max Potion\nR: " + fullrestore + " || 0015 - Full Restore\nR: " + repel + " || 0016 - Repel\nR: " + superrepel + " || 0017 - Super Repel\nR: " + maxrepel + " || 0018 - Max Repel\nR: " + escaperope + " || 0019 - Escape Rope");
				}
				else if(itemcheck2 > 99)
				{
					JOptionPane.showMessageDialog(null,"The inventory can only hold 99 stocks per items!","Error",JOptionPane.ERROR_MESSAGE);
				}
			}
			if(itemtext.equals("Ultra Ball"))
			{
				if(itemcheck3 < 99)
				{
					ultraball = ultraball + delivernum;
					JOptionPane.showMessageDialog(null,"Added " + delivernum + " stocks of Ultra Balls to the inventory.","Added",JOptionPane.INFORMATION_MESSAGE);
					items.setText("R: " + pokeball + " || 0001 - Pokéball\nR: " + greatball + " || 0002 - Great Ball\nR: " + ultraball + " || 0003 - Ultra Ball\nR: " + potion + " || 0004 - Potion\nR: " + superpotion +" || 0005 - Super Potion\nR: " + hyperpotion + " || 0006 - Hyper Potion\nR: " + antidote + " || 0007 - Antidote\nR: " + paralyzeheal + " || 0008 - Paralyze Heal\nR: " + awakening + " || 0009 - Awakening\nR: " + burnheal + " || 0010 - Burn Heal\nR: " + iceheal + " || 0011 - Ice Heal\nR: " + fullheal + " || 0012 - Full Heal\nR: " + revive + " || 0013 - Revive\nR: " + maxpotion + " || 0014 - Max Potion\nR: " + fullrestore + " || 0015 - Full Restore\nR: " + repel + " || 0016 - Repel\nR: " + superrepel + " || 0017 - Super Repel\nR: " + maxrepel + " || 0018 - Max Repel\nR: " + escaperope + " || 0019 - Escape Rope");
				}
				else if(itemcheck3 > 99)
				{
					JOptionPane.showMessageDialog(null,"The inventory can only hold 99 stocks per items!","Error",JOptionPane.ERROR_MESSAGE);
				}
			}
			if(itemtext.equals("Potion"))
			{
				if(itemcheck4 < 99)
				{
					potion = potion + delivernum;
					JOptionPane.showMessageDialog(null,"Added " + delivernum + " stocks of Potions to the inventory.","Added",JOptionPane.INFORMATION_MESSAGE);
					items.setText("R: " + pokeball + " || 0001 - Pokéball\nR: " + greatball + " || 0002 - Great Ball\nR: " + ultraball + " || 0003 - Ultra Ball\nR: " + potion + " || 0004 - Potion\nR: " + superpotion +" || 0005 - Super Potion\nR: " + hyperpotion + " || 0006 - Hyper Potion\nR: " + antidote + " || 0007 - Antidote\nR: " + paralyzeheal + " || 0008 - Paralyze Heal\nR: " + awakening + " || 0009 - Awakening\nR: " + burnheal + " || 0010 - Burn Heal\nR: " + iceheal + " || 0011 - Ice Heal\nR: " + fullheal + " || 0012 - Full Heal\nR: " + revive + " || 0013 - Revive\nR: " + maxpotion + " || 0014 - Max Potion\nR: " + fullrestore + " || 0015 - Full Restore\nR: " + repel + " || 0016 - Repel\nR: " + superrepel + " || 0017 - Super Repel\nR: " + maxrepel + " || 0018 - Max Repel\nR: " + escaperope + " || 0019 - Escape Rope");
				}
				else if(itemcheck4 > 99)
				{
					JOptionPane.showMessageDialog(null,"The inventory can only hold 99 stocks per items!","Error",JOptionPane.ERROR_MESSAGE);
				}
			}
			if(itemtext.equals("Super Potion"))
			{
				if(itemcheck5 < 99)
				{
					superpotion = superpotion + delivernum;
					JOptionPane.showMessageDialog(null,"Added " + delivernum + " stocks of Super Potions to the inventory.","Added",JOptionPane.INFORMATION_MESSAGE);
					items.setText("R: " + pokeball + " || 0001 - Pokéball\nR: " + greatball + " || 0002 - Great Ball\nR: " + ultraball + " || 0003 - Ultra Ball\nR: " + potion + " || 0004 - Potion\nR: " + superpotion +" || 0005 - Super Potion\nR: " + hyperpotion + " || 0006 - Hyper Potion\nR: " + antidote + " || 0007 - Antidote\nR: " + paralyzeheal + " || 0008 - Paralyze Heal\nR: " + awakening + " || 0009 - Awakening\nR: " + burnheal + " || 0010 - Burn Heal\nR: " + iceheal + " || 0011 - Ice Heal\nR: " + fullheal + " || 0012 - Full Heal\nR: " + revive + " || 0013 - Revive\nR: " + maxpotion + " || 0014 - Max Potion\nR: " + fullrestore + " || 0015 - Full Restore\nR: " + repel + " || 0016 - Repel\nR: " + superrepel + " || 0017 - Super Repel\nR: " + maxrepel + " || 0018 - Max Repel\nR: " + escaperope + " || 0019 - Escape Rope");
				}
				else if(itemcheck5 > 99)
				{
					JOptionPane.showMessageDialog(null,"The inventory can only hold 99 stocks per items!","Error",JOptionPane.ERROR_MESSAGE);
				}
			}
			if(itemtext.equals("Hyper Potion"))
			{
				if(itemcheck6 < 99)
				{
					hyperpotion = hyperpotion + delivernum;
					JOptionPane.showMessageDialog(null,"Added " + delivernum + " stocks of Hyper Potions to the inventory.","Added",JOptionPane.INFORMATION_MESSAGE);
					items.setText("R: " + pokeball + " || 0001 - Pokéball\nR: " + greatball + " || 0002 - Great Ball\nR: " + ultraball + " || 0003 - Ultra Ball\nR: " + potion + " || 0004 - Potion\nR: " + superpotion +" || 0005 - Super Potion\nR: " + hyperpotion + " || 0006 - Hyper Potion\nR: " + antidote + " || 0007 - Antidote\nR: " + paralyzeheal + " || 0008 - Paralyze Heal\nR: " + awakening + " || 0009 - Awakening\nR: " + burnheal + " || 0010 - Burn Heal\nR: " + iceheal + " || 0011 - Ice Heal\nR: " + fullheal + " || 0012 - Full Heal\nR: " + revive + " || 0013 - Revive\nR: " + maxpotion + " || 0014 - Max Potion\nR: " + fullrestore + " || 0015 - Full Restore\nR: " + repel + " || 0016 - Repel\nR: " + superrepel + " || 0017 - Super Repel\nR: " + maxrepel + " || 0018 - Max Repel\nR: " + escaperope + " || 0019 - Escape Rope");
				}
				else if(itemcheck6 > 99)
				{
					JOptionPane.showMessageDialog(null,"The inventory can only hold 99 stocks per items!","Error",JOptionPane.ERROR_MESSAGE);
				}
			}
			if(itemtext.equals("Antidote"))
			{
				if(itemcheck7 < 99)
				{
					antidote = antidote + delivernum;
					JOptionPane.showMessageDialog(null,"Added " + delivernum + " stocks of Antidotes to the inventory.","Added",JOptionPane.INFORMATION_MESSAGE);
					items.setText("R: " + pokeball + " || 0001 - Pokéball\nR: " + greatball + " || 0002 - Great Ball\nR: " + ultraball + " || 0003 - Ultra Ball\nR: " + potion + " || 0004 - Potion\nR: " + superpotion +" || 0005 - Super Potion\nR: " + hyperpotion + " || 0006 - Hyper Potion\nR: " + antidote + " || 0007 - Antidote\nR: " + paralyzeheal + " || 0008 - Paralyze Heal\nR: " + awakening + " || 0009 - Awakening\nR: " + burnheal + " || 0010 - Burn Heal\nR: " + iceheal + " || 0011 - Ice Heal\nR: " + fullheal + " || 0012 - Full Heal\nR: " + revive + " || 0013 - Revive\nR: " + maxpotion + " || 0014 - Max Potion\nR: " + fullrestore + " || 0015 - Full Restore\nR: " + repel + " || 0016 - Repel\nR: " + superrepel + " || 0017 - Super Repel\nR: " + maxrepel + " || 0018 - Max Repel\nR: " + escaperope + " || 0019 - Escape Rope");
				}
				else if(itemcheck7 > 99)
				{
					JOptionPane.showMessageDialog(null,"The inventory can only hold 99 stocks per items!","Error",JOptionPane.ERROR_MESSAGE);
				}
			}
			if(itemtext.equals("Paralyze Heal"))
			{
				if(itemcheck8 < 99)
				{
					paralyzeheal = paralyzeheal + delivernum;
					JOptionPane.showMessageDialog(null,"Added " + delivernum + " stocks of Paralyze Heals to the inventory.","Added",JOptionPane.INFORMATION_MESSAGE);
					items.setText("R: " + pokeball + " || 0001 - Pokéball\nR: " + greatball + " || 0002 - Great Ball\nR: " + ultraball + " || 0003 - Ultra Ball\nR: " + potion + " || 0004 - Potion\nR: " + superpotion +" || 0005 - Super Potion\nR: " + hyperpotion + " || 0006 - Hyper Potion\nR: " + antidote + " || 0007 - Antidote\nR: " + paralyzeheal + " || 0008 - Paralyze Heal\nR: " + awakening + " || 0009 - Awakening\nR: " + burnheal + " || 0010 - Burn Heal\nR: " + iceheal + " || 0011 - Ice Heal\nR: " + fullheal + " || 0012 - Full Heal\nR: " + revive + " || 0013 - Revive\nR: " + maxpotion + " || 0014 - Max Potion\nR: " + fullrestore + " || 0015 - Full Restore\nR: " + repel + " || 0016 - Repel\nR: " + superrepel + " || 0017 - Super Repel\nR: " + maxrepel + " || 0018 - Max Repel\nR: " + escaperope + " || 0019 - Escape Rope");
				}
				else if(itemcheck8 > 99)
				{
					JOptionPane.showMessageDialog(null,"The inventory can only hold 99 stocks per items!","Error",JOptionPane.ERROR_MESSAGE);
				}
			}
			if(itemtext.equals("Awakening"))
			{
				if(itemcheck9 < 99)
				{
					greatball = greatball + delivernum;
					JOptionPane.showMessageDialog(null,"Added " + delivernum + " stocks of Awakenings to the inventory.","Added",JOptionPane.INFORMATION_MESSAGE);
					items.setText("R: " + pokeball + " || 0001 - Pokéball\nR: " + greatball + " || 0002 - Great Ball\nR: " + ultraball + " || 0003 - Ultra Ball\nR: " + potion + " || 0004 - Potion\nR: " + superpotion +" || 0005 - Super Potion\nR: " + hyperpotion + " || 0006 - Hyper Potion\nR: " + antidote + " || 0007 - Antidote\nR: " + paralyzeheal + " || 0008 - Paralyze Heal\nR: " + awakening + " || 0009 - Awakening\nR: " + burnheal + " || 0010 - Burn Heal\nR: " + iceheal + " || 0011 - Ice Heal\nR: " + fullheal + " || 0012 - Full Heal\nR: " + revive + " || 0013 - Revive\nR: " + maxpotion + " || 0014 - Max Potion\nR: " + fullrestore + " || 0015 - Full Restore\nR: " + repel + " || 0016 - Repel\nR: " + superrepel + " || 0017 - Super Repel\nR: " + maxrepel + " || 0018 - Max Repel\nR: " + escaperope + " || 0019 - Escape Rope");
				}
				else if(itemcheck9 > 99)
				{
					JOptionPane.showMessageDialog(null,"The inventory can only hold 99 stocks per items!","Error",JOptionPane.ERROR_MESSAGE);
				}
			}
			if(itemtext.equals("Burn Heal"))
			{
				if(itemcheck10 < 99)
				{
					burnheal = burnheal + delivernum;
					JOptionPane.showMessageDialog(null,"Added " + delivernum + " stocks of Burn Heals to the inventory.","Added",JOptionPane.INFORMATION_MESSAGE);
					items.setText("R: " + pokeball + " || 0001 - Pokéball\nR: " + greatball + " || 0002 - Great Ball\nR: " + ultraball + " || 0003 - Ultra Ball\nR: " + potion + " || 0004 - Potion\nR: " + superpotion +" || 0005 - Super Potion\nR: " + hyperpotion + " || 0006 - Hyper Potion\nR: " + antidote + " || 0007 - Antidote\nR: " + paralyzeheal + " || 0008 - Paralyze Heal\nR: " + awakening + " || 0009 - Awakening\nR: " + burnheal + " || 0010 - Burn Heal\nR: " + iceheal + " || 0011 - Ice Heal\nR: " + fullheal + " || 0012 - Full Heal\nR: " + revive + " || 0013 - Revive\nR: " + maxpotion + " || 0014 - Max Potion\nR: " + fullrestore + " || 0015 - Full Restore\nR: " + repel + " || 0016 - Repel\nR: " + superrepel + " || 0017 - Super Repel\nR: " + maxrepel + " || 0018 - Max Repel\nR: " + escaperope + " || 0019 - Escape Rope");
				}
				else if(itemcheck10 > 99)
				{
					JOptionPane.showMessageDialog(null,"The inventory can only hold 99 stocks per items!","Error",JOptionPane.ERROR_MESSAGE);
				}
			}
			if(itemtext.equals("Ice Heal"))
			{
				if(itemcheck11 < 99)
				{
					iceheal = iceheal + delivernum;
					JOptionPane.showMessageDialog(null,"Added " + delivernum + " stocks of Ice Heals to the inventory.","Added",JOptionPane.INFORMATION_MESSAGE);
					items.setText("R: " + pokeball + " || 0001 - Pokéball\nR: " + greatball + " || 0002 - Great Ball\nR: " + ultraball + " || 0003 - Ultra Ball\nR: " + potion + " || 0004 - Potion\nR: " + superpotion +" || 0005 - Super Potion\nR: " + hyperpotion + " || 0006 - Hyper Potion\nR: " + antidote + " || 0007 - Antidote\nR: " + paralyzeheal + " || 0008 - Paralyze Heal\nR: " + awakening + " || 0009 - Awakening\nR: " + burnheal + " || 0010 - Burn Heal\nR: " + iceheal + " || 0011 - Ice Heal\nR: " + fullheal + " || 0012 - Full Heal\nR: " + revive + " || 0013 - Revive\nR: " + maxpotion + " || 0014 - Max Potion\nR: " + fullrestore + " || 0015 - Full Restore\nR: " + repel + " || 0016 - Repel\nR: " + superrepel + " || 0017 - Super Repel\nR: " + maxrepel + " || 0018 - Max Repel\nR: " + escaperope + " || 0019 - Escape Rope");
				}
				else if(itemcheck11 > 99)
				{
					JOptionPane.showMessageDialog(null,"The inventory can only hold 99 stocks per items!","Error",JOptionPane.ERROR_MESSAGE);
				}
			}
			if(itemtext.equals("Full Heal"))
			{
				if(itemcheck12 < 99)
				{
					fullheal = fullheal + delivernum;
					JOptionPane.showMessageDialog(null,"Added " + delivernum + " stocks of Full Heals to the inventory.","Added",JOptionPane.INFORMATION_MESSAGE);
					items.setText("R: " + pokeball + " || 0001 - Pokéball\nR: " + greatball + " || 0002 - Great Ball\nR: " + ultraball + " || 0003 - Ultra Ball\nR: " + potion + " || 0004 - Potion\nR: " + superpotion +" || 0005 - Super Potion\nR: " + hyperpotion + " || 0006 - Hyper Potion\nR: " + antidote + " || 0007 - Antidote\nR: " + paralyzeheal + " || 0008 - Paralyze Heal\nR: " + awakening + " || 0009 - Awakening\nR: " + burnheal + " || 0010 - Burn Heal\nR: " + iceheal + " || 0011 - Ice Heal\nR: " + fullheal + " || 0012 - Full Heal\nR: " + revive + " || 0013 - Revive\nR: " + maxpotion + " || 0014 - Max Potion\nR: " + fullrestore + " || 0015 - Full Restore\nR: " + repel + " || 0016 - Repel\nR: " + superrepel + " || 0017 - Super Repel\nR: " + maxrepel + " || 0018 - Max Repel\nR: " + escaperope + " || 0019 - Escape Rope");
				}
				else if(itemcheck12 > 99)
				{
					JOptionPane.showMessageDialog(null,"The inventory can only hold 99 stocks per items!","Error",JOptionPane.ERROR_MESSAGE);
				}
			}
			if(itemtext.equals("Revive"))
			{
				if(itemcheck13 < 99)
				{
					revive = revive + delivernum;
					JOptionPane.showMessageDialog(null,"Added " + delivernum + " stocks of Revives to the inventory.","Added",JOptionPane.INFORMATION_MESSAGE);
					items.setText("R: " + pokeball + " || 0001 - Pokéball\nR: " + greatball + " || 0002 - Great Ball\nR: " + ultraball + " || 0003 - Ultra Ball\nR: " + potion + " || 0004 - Potion\nR: " + superpotion +" || 0005 - Super Potion\nR: " + hyperpotion + " || 0006 - Hyper Potion\nR: " + antidote + " || 0007 - Antidote\nR: " + paralyzeheal + " || 0008 - Paralyze Heal\nR: " + awakening + " || 0009 - Awakening\nR: " + burnheal + " || 0010 - Burn Heal\nR: " + iceheal + " || 0011 - Ice Heal\nR: " + fullheal + " || 0012 - Full Heal\nR: " + revive + " || 0013 - Revive\nR: " + maxpotion + " || 0014 - Max Potion\nR: " + fullrestore + " || 0015 - Full Restore\nR: " + repel + " || 0016 - Repel\nR: " + superrepel + " || 0017 - Super Repel\nR: " + maxrepel + " || 0018 - Max Repel\nR: " + escaperope + " || 0019 - Escape Rope");
				}
				else if(itemcheck14 > 99)
				{
					JOptionPane.showMessageDialog(null,"The inventory can only hold 99 stocks per items!","Error",JOptionPane.ERROR_MESSAGE);
				}
			}
			if(itemtext.equals("Max Potion"))
			{
				if(itemcheck14 < 99)
				{
					maxpotion = maxpotion + delivernum;
					JOptionPane.showMessageDialog(null,"Added " + delivernum + " stocks of Max Potions to the inventory.","Added",JOptionPane.INFORMATION_MESSAGE);
					items.setText("R: " + pokeball + " || 0001 - Pokéball\nR: " + greatball + " || 0002 - Great Ball\nR: " + ultraball + " || 0003 - Ultra Ball\nR: " + potion + " || 0004 - Potion\nR: " + superpotion +" || 0005 - Super Potion\nR: " + hyperpotion + " || 0006 - Hyper Potion\nR: " + antidote + " || 0007 - Antidote\nR: " + paralyzeheal + " || 0008 - Paralyze Heal\nR: " + awakening + " || 0009 - Awakening\nR: " + burnheal + " || 0010 - Burn Heal\nR: " + iceheal + " || 0011 - Ice Heal\nR: " + fullheal + " || 0012 - Full Heal\nR: " + revive + " || 0013 - Revive\nR: " + maxpotion + " || 0014 - Max Potion\nR: " + fullrestore + " || 0015 - Full Restore\nR: " + repel + " || 0016 - Repel\nR: " + superrepel + " || 0017 - Super Repel\nR: " + maxrepel + " || 0018 - Max Repel\nR: " + escaperope + " || 0019 - Escape Rope");
				}
				else if(itemcheck14 > 99)
				{
					JOptionPane.showMessageDialog(null,"The inventory can only hold 99 stocks per items!","Error",JOptionPane.ERROR_MESSAGE);
				}
			}
			if(itemtext.equals("Full Restore"))
			{
				if(itemcheck15 < 99)
				{
					fullrestore = fullrestore + delivernum;
					JOptionPane.showMessageDialog(null,"Added " + delivernum + " stocks of Full Restores to the inventory.","Added",JOptionPane.INFORMATION_MESSAGE);
					items.setText("R: " + pokeball + " || 0001 - Pokéball\nR: " + greatball + " || 0002 - Great Ball\nR: " + ultraball + " || 0003 - Ultra Ball\nR: " + potion + " || 0004 - Potion\nR: " + superpotion +" || 0005 - Super Potion\nR: " + hyperpotion + " || 0006 - Hyper Potion\nR: " + antidote + " || 0007 - Antidote\nR: " + paralyzeheal + " || 0008 - Paralyze Heal\nR: " + awakening + " || 0009 - Awakening\nR: " + burnheal + " || 0010 - Burn Heal\nR: " + iceheal + " || 0011 - Ice Heal\nR: " + fullheal + " || 0012 - Full Heal\nR: " + revive + " || 0013 - Revive\nR: " + maxpotion + " || 0014 - Max Potion\nR: " + fullrestore + " || 0015 - Full Restore\nR: " + repel + " || 0016 - Repel\nR: " + superrepel + " || 0017 - Super Repel\nR: " + maxrepel + " || 0018 - Max Repel\nR: " + escaperope + " || 0019 - Escape Rope");
				}
				else if(itemcheck15 > 99)
				{
					JOptionPane.showMessageDialog(null,"The inventory can only hold 99 stocks per items!","Error",JOptionPane.ERROR_MESSAGE);
				}
			}
			if(itemtext.equals("Repel"))
			{
				if(itemcheck16 < 99)
				{
					repel = repel + delivernum;
					JOptionPane.showMessageDialog(null,"Added " + delivernum + " stocks of Repels to the inventory.","Added",JOptionPane.INFORMATION_MESSAGE);
					items.setText("R: " + pokeball + " || 0001 - Pokéball\nR: " + greatball + " || 0002 - Great Ball\nR: " + ultraball + " || 0003 - Ultra Ball\nR: " + potion + " || 0004 - Potion\nR: " + superpotion +" || 0005 - Super Potion\nR: " + hyperpotion + " || 0006 - Hyper Potion\nR: " + antidote + " || 0007 - Antidote\nR: " + paralyzeheal + " || 0008 - Paralyze Heal\nR: " + awakening + " || 0009 - Awakening\nR: " + burnheal + " || 0010 - Burn Heal\nR: " + iceheal + " || 0011 - Ice Heal\nR: " + fullheal + " || 0012 - Full Heal\nR: " + revive + " || 0013 - Revive\nR: " + maxpotion + " || 0014 - Max Potion\nR: " + fullrestore + " || 0015 - Full Restore\nR: " + repel + " || 0016 - Repel\nR: " + superrepel + " || 0017 - Super Repel\nR: " + maxrepel + " || 0018 - Max Repel\nR: " + escaperope + " || 0019 - Escape Rope");
				}
				else if(itemcheck16 > 99)
				{
					JOptionPane.showMessageDialog(null,"The inventory can only hold 99 stocks per items!","Error",JOptionPane.ERROR_MESSAGE);
				}
			}
			if(itemtext.equals("Super Repel"))
			{
				if(itemcheck17 < 99)
				{
					superrepel = superrepel + delivernum;
					JOptionPane.showMessageDialog(null,"Added " + delivernum + " stocks of Super Repels to the inventory.","Added",JOptionPane.INFORMATION_MESSAGE);
					items.setText("R: " + pokeball + " || 0001 - Pokéball\nR: " + greatball + " || 0002 - Great Ball\nR: " + ultraball + " || 0003 - Ultra Ball\nR: " + potion + " || 0004 - Potion\nR: " + superpotion +" || 0005 - Super Potion\nR: " + hyperpotion + " || 0006 - Hyper Potion\nR: " + antidote + " || 0007 - Antidote\nR: " + paralyzeheal + " || 0008 - Paralyze Heal\nR: " + awakening + " || 0009 - Awakening\nR: " + burnheal + " || 0010 - Burn Heal\nR: " + iceheal + " || 0011 - Ice Heal\nR: " + fullheal + " || 0012 - Full Heal\nR: " + revive + " || 0013 - Revive\nR: " + maxpotion + " || 0014 - Max Potion\nR: " + fullrestore + " || 0015 - Full Restore\nR: " + repel + " || 0016 - Repel\nR: " + superrepel + " || 0017 - Super Repel\nR: " + maxrepel + " || 0018 - Max Repel\nR: " + escaperope + " || 0019 - Escape Rope");
				}
				else if(itemcheck17 > 99)
				{
					JOptionPane.showMessageDialog(null,"The inventory can only hold 99 stocks per items!","Error",JOptionPane.ERROR_MESSAGE);
				}
			}
			if(itemtext.equals("Max Repel"))
			{
				if(itemcheck18 < 99)
				{
					maxrepel = maxrepel + delivernum;
					JOptionPane.showMessageDialog(null,"Added " + delivernum + " stocks of Max Repels to the inventory.","Added",JOptionPane.INFORMATION_MESSAGE);
					items.setText("R: " + pokeball + " || 0001 - Pokéball\nR: " + greatball + " || 0002 - Great Ball\nR: " + ultraball + " || 0003 - Ultra Ball\nR: " + potion + " || 0004 - Potion\nR: " + superpotion +" || 0005 - Super Potion\nR: " + hyperpotion + " || 0006 - Hyper Potion\nR: " + antidote + " || 0007 - Antidote\nR: " + paralyzeheal + " || 0008 - Paralyze Heal\nR: " + awakening + " || 0009 - Awakening\nR: " + burnheal + " || 0010 - Burn Heal\nR: " + iceheal + " || 0011 - Ice Heal\nR: " + fullheal + " || 0012 - Full Heal\nR: " + revive + " || 0013 - Revive\nR: " + maxpotion + " || 0014 - Max Potion\nR: " + fullrestore + " || 0015 - Full Restore\nR: " + repel + " || 0016 - Repel\nR: " + superrepel + " || 0017 - Super Repel\nR: " + maxrepel + " || 0018 - Max Repel\nR: " + escaperope + " || 0019 - Escape Rope");
				}
				else if(itemcheck18 > 99)
				{
					JOptionPane.showMessageDialog(null,"The inventory can only hold 99 stocks per items!","Error",JOptionPane.ERROR_MESSAGE);
				}
			}
			if(itemtext.equals("Escape Rope"))
			{
				if(itemcheck17 < 99)
				{
					escaperope = escaperope + delivernum;
					JOptionPane.showMessageDialog(null,"Added " + delivernum + " stocks of Escape Ropes to the inventory.","Added",JOptionPane.INFORMATION_MESSAGE);
					items.setText("R: " + pokeball + " || 0001 - Pokéball\nR: " + greatball + " || 0002 - Great Ball\nR: " + ultraball + " || 0003 - Ultra Ball\nR: " + potion + " || 0004 - Potion\nR: " + superpotion +" || 0005 - Super Potion\nR: " + hyperpotion + " || 0006 - Hyper Potion\nR: " + antidote + " || 0007 - Antidote\nR: " + paralyzeheal + " || 0008 - Paralyze Heal\nR: " + awakening + " || 0009 - Awakening\nR: " + burnheal + " || 0010 - Burn Heal\nR: " + iceheal + " || 0011 - Ice Heal\nR: " + fullheal + " || 0012 - Full Heal\nR: " + revive + " || 0013 - Revive\nR: " + maxpotion + " || 0014 - Max Potion\nR: " + fullrestore + " || 0015 - Full Restore\nR: " + repel + " || 0016 - Repel\nR: " + superrepel + " || 0017 - Super Repel\nR: " + maxrepel + " || 0018 - Max Repel\nR: " + escaperope + " || 0019 - Escape Rope");
				}
				else if(itemcheck17 > 99)
				{
					JOptionPane.showMessageDialog(null,"The inventory can only hold 99 stocks per items!","Error",JOptionPane.ERROR_MESSAGE);
				}
			}
		}

	}
	public static void main(String[] args)
	{
		
		new pokemartshop();
	}
}