import javax.swing.*; // for the Jbuttons,JLabels and JPannels
import java.awt.event.*; // For the events used in the program
import javax.swing.border.*; // Borders usdd by the JPanels
import java.awt.*; // For the Layouts used in the program
import java.awt.Dimension; // Resizing the JLabel

class buttons extends JFrame implements ActionListener{
	protected JButton num0,num1,num2,num3,num4,num5,num6,num7,num8,num9,add,sub,div,mul,eq,clear,dot,sin,tan,cos,sqrt,sqr,bS,pom,inv;
	protected JPanel gen,display,nom,geni,genio,p1,p2,p3;
	protected JLabel entry = new JLabel("0",JLabel.RIGHT);
	protected int count = 0;
	protected char sign='+';
	protected double first, second, result = 0.0;
	buttons(){
		entry.setPreferredSize(new Dimension(275,45));
		entry.setFont(new Font("TimesRoman", Font.BOLD, 20));
		gen = new JPanel();
		display = new JPanel();
		nom = new JPanel(new GridLayout(1,5,4,4));
		geni = new JPanel();
		p3 = new JPanel();
		genio = new JPanel();
		p1 = new JPanel(new GridLayout(6,4,4,4));
		p2 = new JPanel(new GridLayout(1,5,4,4));
		num0 = new JButton("0");num1 = new JButton("1");num2 = new JButton("2");
		num3 = new JButton("3");num4 = new JButton("4");num5 = new JButton("5");
		num6 = new JButton("6");num7 = new JButton("7");num8 = new JButton("8");
		num9 = new JButton("9");
		add = new JButton("+");sub = new JButton("-");div = new JButton("/");
		mul = new JButton("x");eq = new JButton("=");	dot = new JButton(".");
		sin = new JButton("sin");cos = new JButton("cos");tan = new JButton("tan");
		sqrt = new JButton("sqrt");sqr = new JButton("x^2");clear = new JButton("C");
		bS = new JButton("Delete");pom = new JButton("+/-");inv = new JButton("1/X");

		clear.setPreferredSize(new Dimension(45,60));
		//Signs
		setBackground(Color.WHITE); p2.add(entry);
		add.setBackground(Color.BLUE); add.setForeground(Color.WHITE);
		bS.setBackground(Color.RED); bS.setForeground(Color.WHITE);
		clear.setBackground(Color.RED); clear.setForeground(Color.WHITE);
		eq.setBackground(Color.RED); eq.setForeground(Color.WHITE);
		sub.setBackground(Color.BLUE); sub.setForeground(Color.WHITE);
		div.setBackground(Color.BLUE); div.setForeground(Color.WHITE);
		mul.setBackground(Color.BLUE); mul.setForeground(Color.WHITE);
		sin.setBackground(Color.BLACK); sin.setForeground(Color.WHITE);
		cos.setBackground(Color.BLACK); cos.setForeground(Color.WHITE);
		tan.setBackground(Color.BLACK); tan.setForeground(Color.WHITE);
		sqrt.setBackground(Color.BLACK); sqrt.setForeground(Color.WHITE);
		pom.setBackground(Color.BLACK); pom.setForeground(Color.WHITE);
		sqr.setBackground(Color.BLACK); sqr.setForeground(Color.WHITE);
		inv.setBackground(Color.BLACK); inv.setForeground(Color.WHITE);
		dot.setBackground(Color.BLACK); dot.setForeground(Color.WHITE);
		Color grey = new Color(255/2,255/2,255/2);
		num0.setBackground(grey); num0.setForeground(Color.WHITE);
		num1.setBackground(grey); num1.setForeground(Color.WHITE);
		num2.setBackground(grey); num2.setForeground(Color.WHITE);
		num3.setBackground(grey); num3.setForeground(Color.WHITE);
		num4.setBackground(grey); num4.setForeground(Color.WHITE);
		num5.setBackground(grey); num5.setForeground(Color.WHITE);
		num6.setBackground(grey); num6.setForeground(Color.WHITE);
		num7.setBackground(grey); num7.setForeground(Color.WHITE);
		num8.setBackground(grey); num8.setForeground(Color.WHITE);
		num9.setBackground(grey); num9.setForeground(Color.WHITE);
		p1.add(sin);p1.add(cos);p1.add(tan);
		p1.add(sqrt);
		p1.add(sqr);p1.add(pom);
		p1.add(inv);p1.add(add);
		p1.add(num7);p1.add(num8);
		p1.add(num9);p1.add(sub);p1.add(num4);
		p1.add(num5);p1.add(num6);p1.add(div);
		p1.add(num1);p1.add(num2);p1.add(num3);
		p1.add(mul);p1.add(dot);p1.add(num0);
		p1.add(bS);p1.add(eq);
		geni.setBorder(new LineBorder(null, 1));
		geni.add(p1);
		p2.setBorder(new LineBorder(Color.BLACK,1));
		p2.setBackground(Color.WHITE); p2.setForeground(Color.BLACK);
		gen.add(geni, BorderLayout.SOUTH);
		genio.add(p2);
		genio.setBorder(new LineBorder(null, 1));
		
		display.add(genio, BorderLayout.NORTH);
		genio.add(clear);
		display.add(clear, BorderLayout.CENTER);
		add(display, BorderLayout.EAST);
		
		add(gen, BorderLayout.SOUTH);
		num0.addActionListener(this);num1.addActionListener(this);
		num2.addActionListener(this);num3.addActionListener(this);
		num4.addActionListener(this);num5.addActionListener(this);
		num6.addActionListener(this);num7.addActionListener(this);
		num8.addActionListener(this);num9.addActionListener(this);
		add.addActionListener(this);sub.addActionListener(this);
		div.addActionListener(this);mul.addActionListener(this);
		eq.addActionListener(this);dot.addActionListener(this);
		sin.addActionListener(this);cos.addActionListener(this);
		tan.addActionListener(this);sqrt.addActionListener(this);
		sqr.addActionListener(this);clear.addActionListener(this);
		inv.addActionListener(this);bS.addActionListener(this);
		pom.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e){
		String text = "0", convert;
		text = entry.getText();
		if((e.getSource()==num9)||(e.getSource()==num8)||(e.getSource()==num7)||(e.getSource()==num6)||(e.getSource()==num5)||(e.getSource()==num4)||(e.getSource()==num3)||(e.getSource()==num2)||(e.getSource()==num1)||(e.getSource()==num0)){
			if(count>=1){ //checks if an operation has been performed and resets the dispalyed text to empty
				text = "0";
				count = 0;
			}
			text = ((text.length()==1) && (text.charAt(0)=='0'))? "":text;
			if(e.getSource()==num9)	entry.setText(""+text+""+9);
			if(e.getSource()==num8) entry.setText(""+text+""+8);
			if(e.getSource()==num7) entry.setText(""+text+""+7);
			if(e.getSource()==num6) entry.setText(""+text+""+6);
			if(e.getSource()==num5) entry.setText(""+text+""+5);
			if(e.getSource()==num4) entry.setText(""+text+""+4);
			if(e.getSource()==num3) entry.setText(""+text+""+3);
			if(e.getSource()==num2) entry.setText(""+text+""+2);
			if(e.getSource()==num1) entry.setText(""+text+""+1);
			if(e.getSource()==num0) entry.setText(""+text+""+0);
		}else if((e.getSource()==sqrt)||(e.getSource()==tan)||(e.getSource()==cos)||(e.getSource()==sin)||(e.getSource()==sqr)||(e.getSource()==inv)){
			count+=1;
			if(e.getSource()==inv){
				try{
					entry.setText(clearString(""+(1/(Double.parseDouble(entry.getText())))));
				}catch(ArithmeticException excp){
					entry.setText("Divide by 0.");
				}
			}else if(e.getSource()==sqrt){
				try{
					entry.setText(clearString(""+(Math.sqrt(Double.parseDouble(entry.getText())))));
				}catch(ArithmeticException excp){
					entry.setText("Divide by 0.");
				}
			}else if(e.getSource()==tan){
				try{
					entry.setText(clearString(""+(Math.tan((Double.parseDouble(entry.getText()))))));
				}catch(ArithmeticException excp){
					entry.setText("Divide by 0.");
				}
			}else if(e.getSource()==cos){
				try{
					entry.setText(clearString(""+(Math.cos((Double.parseDouble(entry.getText()))))));
				}catch(ArithmeticException excp){
					entry.setText("Divide by 0.");
				}
			}else if(e.getSource()==sin){
				try{
					entry.setText(clearString(""+(Math.sin((Double.parseDouble(entry.getText()))))));
				}catch(ArithmeticException excp){
					entry.setText("Divide by 0.");
				}	
			}else if(e.getSource()==sqr){
				try{
					entry.setText(clearString(""+(Math.pow((Double.parseDouble(entry.getText())),2))));	
				}catch(ArithmeticException excp){
					entry.setText("Divide by 0.");
				}
			}
		}else if(e.getSource()==dot){
			if(count>=1){ //checks if an operation has been performed and resets the dispalyed text to empty
				text = "0";
				count = 0;
			}
			if(text.indexOf(".")>=0){// checking if dot(.) exists in the string
				//shows that the dot(.) exists in string. therefor can't be added again
			}else{
				if((text.charAt(0)=='0') && (text.length()==1)){
					entry.setText("0.");
				}else{
					entry.setText(text+".");
				}
			}
		}else{
			//the Arithmetic operators +-/* used in the calculator
			count+=1;
			if(e.getSource()!=eq){
				first = Double.parseDouble(entry.getText());
				if(e.getSource()==add) sign = '+';
				else if(e.getSource()==sub) sign = '-';
				else if (e.getSource()==div) sign = '/';
				else if (e.getSource()==mul) sign = '*';	
			}else{
				second = Double.parseDouble(entry.getText());
				switch(sign){
					case '+': result = first +second; break;
					case '-': result = first -second; break;
					case '*': result = first *second; break;
					case '/': result = first /second; break;
					default: result = second+0; break;
				}
				sign = ' ';
				entry.setText(clearString(""+result));
			}	
		}
		if(e.getSource()==clear) entry.setText("0");
		else if(e.getSource()==bS) entry.setText(clearString(""+deletelast(text)));
		else if(e.getSource()==pom){
			if(text.indexOf("-")>=0){
				text = entry.getText();
				entry.setText(clearString(""+deleteFirst(text)));
			}else entry.setText(clearString("-"+text));
		}
	}	
	public String deletelast(String str){
		String last = "0";
		if((str.length()>1) && str!=null && str.charAt(0)!=0){
			return str.substring(0,str.length()-1);
		}else{
			return last;
		}
	}
	public String deleteFirst(String str){
		if((str.length()>1) && str!=null && str.charAt(0)=='-'){
			return str.substring(1);
		}else return str; 
	}
	public String clearString(String str){
		if(str.indexOf(".0")>=0) return str.substring(0, str.length()-2);
		else return str;
	}
}
public class calculator{
	public static void main(String[] args) {
		buttons frame = new buttons();
		frame.setTitle("Amoko");
		frame.pack();
		frame.setResizable(false);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}