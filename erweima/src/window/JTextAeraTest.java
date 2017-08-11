package window;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import decode.QRCodeDecoderHandler;
import encode.Test;  
  
//实现接口ActionListener  
public class JTextAeraTest implements ActionListener {  
  
    JFrame jf;  
    JPanel jpanel;  
    JButton jb1, jb2, jb3,jb4,jb5,jb6;  
    JTextArea jta = null;  
    JScrollPane jscrollPane; 
    String content = "";
    String image = "";
    File file2 = null;
    String  logurl = "";
    String outpath="";
    private JPanel panel;

    
  
    public JTextAeraTest() {  
  
        jf = new JFrame("二维码生成与解析");  
        Container contentPane = jf.getContentPane();  
        contentPane.setLayout(new BorderLayout());  
  
        jta = new JTextArea(10, 15);  
        jta.setTabSize(10);  
        jta.setFont(new Font("标楷体", Font.BOLD,25));  
        jta.setLineWrap(true);// 激活自动换行功能  
        jta.setWrapStyleWord(true);// 激活断行不断字功能  
        jta.setBackground(Color.pink);  
  
        jscrollPane = new JScrollPane(jta);  
        jpanel = new JPanel();  
        jpanel.setLayout(new GridLayout(1, 4));
        
        
        
        
   		jb1 = new JButton("内容");
        jb1.addActionListener(this); 
        
        jb2 = new JButton("头像选择");  
        jb2.addActionListener(this);  
        
        jb3 = new JButton("输出路径");  
        jb3.addActionListener(this); 
     
        jb4  = new JButton("生成");  
        jb4.addActionListener(this); 
        
        jb5  = new JButton("选择图片");  
        jb5.addActionListener(this);  
        
        jb6  = new JButton("解析");  
        jb6.addActionListener(this);  
       
        jpanel.add(jb1);  
        jpanel.add(jb2);  
        jpanel.add(jb3);
        jpanel.add(jb4);
        jpanel.add(jb5);
        jpanel.add(jb6);
        
        contentPane.add(jscrollPane, BorderLayout.CENTER);  
        contentPane.add(jpanel, BorderLayout.SOUTH);
            
        
  
        jf.setSize(942, 563);  
        jf.setLocation(400, 200);  
        jf.setVisible(true);  
        
  
        jf.addWindowListener(new WindowAdapter() {  
            public void windowClosing(WindowEvent e) {  
                System.exit(0);  
            }  
        });  
    }  
  
    // 覆盖接口ActionListener的方法actionPerformed  
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == jb1) {
			content = jta.getText();
			jta.setText("");
		}
		
		if (e.getSource() == jb2) {
			 JFileChooser jfc = new JFileChooser();
			 jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);  
	         jfc.showDialog(new JLabel(), "选择");
	         logurl = jfc.getSelectedFile().getAbsolutePath();
	         jta.setText("");
		}
		
		
		if (e.getSource() == jb3) {
			outpath = jta.getText();
			jta.setText("");
		}
		
		
		if(e.getSource()==jb4){
			try {
				jta.append("输入的内容"+content+"\n"+"头像"+logurl+"\n"+"输出路径"+new File(outpath).getCanonicalPath()+"\n");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			new Test().setPicture(content, logurl,outpath);
		}
		
		
		
		if(e.getSource()==jb5){		
			JFileChooser jfc = new JFileChooser();
			 jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);  
	         jfc.showDialog(new JLabel(), "选择");  
	          file2 = jfc.getSelectedFile(); 
	          jta.setText("选择图片成功\n");
		}
		
		
		if(e.getSource()==jb6){
			try {
				jta.setText("解析成功！\n"+new QRCodeDecoderHandler().decoderQRCode(file2.getCanonicalPath()));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
  
    public static void main(String[] args) {  
        JTextAeraTest jTextAeraTest=new JTextAeraTest(); 
        
    }  
}  