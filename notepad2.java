/*
 *  * Advance Notepad
 */
package notepad;
import java.awt.datatransfer.*;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.FileDialog;
import java.awt.Font;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;      
import java.io.FileReader;
import javax.swing.JFileChooser;
import java.io.*;
import javax.swing.*;
import javax.swing.JTextArea;



/**
 *
 * @author Jyotish
 */
public class notepad2 extends JFrame {
    
     JPanel panel;
    int fileToOpen;
    int fileToSave;
    JFileChooser fileOpen;
    JFileChooser fileSave;
    String fname;
    Clipboard cBoard=getToolkit().getSystemClipboard();
      Color color= (Color.WHITE);
    notepad2(){                                       //constructor
        
        super("Advance notepad");
        
       
     
   final  JTextArea textArea=new JTextArea();
   final   JScrollPane scroll=new JScrollPane(textArea);
           add(scroll);
           JFileChooser fileOpen=new JFileChooser();
           final Font font1=new Font("SansSerif",Font.BOLD,20);
          
       
        MenuBar menubar=new MenuBar();
        Menu File=new Menu("File");
        Menu fontmenu=new Menu("Font");
        Menu sizemenu=new Menu("Size");
        Menu colormenu=new Menu("Background");
        Menu tcolormenu=new Menu("TextColor");
        Menu helpmenu=new Menu("Help");
        MenuItem menuitem=new MenuItem();
        
        textArea.setBackground(color);
        
        setMenuBar(menubar);
      
        menubar.add(File);
        menubar.add(fontmenu);
        menubar.add(colormenu);
        menubar.add(sizemenu);
        menubar.add(tcolormenu);
        menubar.add(helpmenu);
        
        MenuItem newOption=new MenuItem("New...");
        MenuItem open=new MenuItem("Open...");
        MenuItem save=new MenuItem("Save...");
        MenuItem copy=new MenuItem("Copy...");
        MenuItem cut=new MenuItem("Cut...");
        MenuItem paste=new MenuItem("Paste...");
        MenuItem print=new MenuItem("Print...");
        MenuItem close=new MenuItem("Close...");
           
        MenuItem itallic=new MenuItem("Itallic");
        MenuItem bold=new MenuItem("Bold");
        MenuItem simple=new MenuItem("Simple");
           
        MenuItem chosecolor=new MenuItem("Colour");
        
        MenuItem twenty=new MenuItem("20");
        MenuItem twentyfive=new MenuItem("25");
        MenuItem thirty=new MenuItem("30");
        MenuItem thirtyfive=new MenuItem("35");
        MenuItem fourty=new MenuItem("40");   
        MenuItem fourtyfive=new MenuItem("45");
        MenuItem fifty=new MenuItem("50");
        MenuItem fiftyfive=new MenuItem("55");
        MenuItem sixty=new MenuItem("60");
        MenuItem sixtyfive=new MenuItem("65");
        MenuItem seventy=new MenuItem("70");
        MenuItem seventyfive=new MenuItem("75");
        MenuItem eighty=new MenuItem("80");
        MenuItem eightyfive=new MenuItem("85");
        MenuItem ninety=new MenuItem("90");
        MenuItem ninetyfive=new MenuItem("95");
        MenuItem hundred=new MenuItem("100");
        MenuItem help=new MenuItem("Help");
        MenuItem about=new MenuItem("About");
        MenuItem tcolor=new MenuItem("Colour");
                 
        File.add(newOption);
        File.add(open);  
        File.add(save);
        File.add(cut);
        File.add(copy);
        File.add(paste);
        File.add(print);
        File.add(close);
           
           
        colormenu.add(chosecolor);
           
        fontmenu.add(itallic);
        fontmenu.add(bold);
        fontmenu.add(simple);
              
        sizemenu.add(twenty);
        sizemenu.add(twentyfive);
        sizemenu.add(thirty);
        sizemenu.add(thirtyfive);
        sizemenu.add(fourty);
        sizemenu.add(fourtyfive);
        sizemenu.add(fifty);
        sizemenu.add(fiftyfive);
        sizemenu.add(sixty);
        sizemenu.add(sixtyfive);
        sizemenu.add(seventy);
        sizemenu.add(seventyfive);
        sizemenu.add(seventyfive);
        sizemenu.add(eighty);
        sizemenu.add(eightyfive);
        sizemenu.add(ninety);
        sizemenu.add(ninetyfive);
        sizemenu.add(hundred);
                         
        helpmenu.add(about);
        helpmenu.add(help);
        
        tcolormenu.add(tcolor);
        
        textArea.setBackground(color);
              
        textArea.setFont(font1);
          
        
        newOption.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            textArea.setText("");
            }
        
        });
       
         open.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
    FileDialog fDialog=new FileDialog(notepad2.this,"Select a text file",FileDialog.LOAD);
    fDialog.show();
    if(fDialog.getFile()!=null)
    {
        fname=fDialog.getDirectory()+fDialog.getFile();
        setTitle(fname);
        Readfile();
        
    }
    
            
                
        }
        public void Readfile() 
    {
    BufferedReader br;
    StringBuffer sBuffer=new StringBuffer();
    try{
        
    br=new BufferedReader(new FileReader(fname));
    String oLine;
    while((oLine=br.readLine())!=null)
        sBuffer.append(oLine+"\n");
    textArea.setText(sBuffer.toString());
    br.close();
    }
    catch(FileNotFoundException fe)
    {
        System.out.printf("Required file not Found");
    
    }
    catch(IOException ioe)
    {}
    }
        });
         
          save.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
           JFileChooser fc = new JFileChooser();
           int returnVal = fc.showSaveDialog(notepad2.this);
                        
           if(returnVal == JFileChooser.APPROVE_OPTION)
             {
             String savefile = fc.getSelectedFile().getPath();
               if(savefile == null)
                  {
                     return;
                   }
                                else
                            {
                      String docToSave = textArea.getText();
                     if(docToSave != null)
             {
           FileOutputStream fstrm = null;
         BufferedOutputStream ostrm = null;
               try
                {
                           fstrm = new FileOutputStream(savefile);
                         ostrm = new BufferedOutputStream(fstrm);
                            byte[] bytes = null;
                        try
                         {
                      bytes = docToSave.getBytes();
                                 }
                      catch(Exception e1)
                         {
                              e1.printStackTrace();
                                                                }
                             ostrm.write(bytes);
                           }
                        catch(IOException io)
                                {
                 System.err.println("IOException: " +
                        io.getMessage());
                        }
              finally
               {
                 try
                    {
                         ostrm.flush();
                         fstrm.close();
                        ostrm.close();
                           }
                 catch(IOException ioe)
                   {
                  System.err.println("IOException: " +
                         ioe.getMessage());
                           }
                         }
                      }
                  }
                }
                else
                {
                    return;
                }      
        }
        });
     
          
      cut.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
                
            String sText=textArea.getSelectedText();
             StringSelection sSelection=new StringSelection(sText);
             cBoard.setContents(sSelection , sSelection);
             textArea.replaceRange("",textArea.getSelectionStart(),textArea.getSelectionEnd());
        }
        });
      
       copy.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
                
            String sText=textArea.getSelectedText();
             StringSelection cString=new StringSelection(sText);
             cBoard.setContents(cString , cString);
            
        }
        });
       
     
       paste.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
                
           Transferable ctransfer=cBoard.getContents(notepad2.this);
           try {
           String sText=(String)ctransfer.getTransferData(DataFlavor.stringFlavor);
           textArea.replaceRange(sText, textArea.getSelectionStart(), textArea.getSelectionEnd());
           }
           catch(Exception exc)
           {
           System.out.println("Not a String Flavor");
           }
        }
        });
      
      print.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
                
            try {
    boolean complete = textArea.print();
    if (complete) {
        
         JOptionPane.showMessageDialog(null,
                    "Successfully Done");
    } else {
        JOptionPane.showMessageDialog(null,
                    "Failed");
        
    }
} catch (Exception pe) {
    System.out.println("Something Went Wrong");
   
}
                
        }
        });
      
       
      close.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
                
            System.exit(0);
                
        }
        });
      
        itallic.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
           
             textArea.setFont(textArea.getFont().deriveFont(Font.ITALIC));
        }
        });
         bold.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
             textArea.setFont(textArea.getFont().deriveFont(Font.BOLD));
        }
        });
          simple.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
             textArea.setFont(textArea.getFont().deriveFont(Font.ROMAN_BASELINE));
        }
        });
       
           chosecolor.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            color=JColorChooser.showDialog(null, "pick ur color", color);
             textArea.setBackground(color);
            if(color==null)
            {
            color=(Color.WHITE);
            textArea.setBackground(color);
            }
        }
        });
            twenty.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            textArea.setFont(textArea.getFont().deriveFont(20f));        }
        });
         
            twentyfive.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            textArea.setFont(textArea.getFont().deriveFont(25f));        }
        });
            thirty.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            textArea.setFont(textArea.getFont().deriveFont(30f));        }
        });
            thirtyfive.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            textArea.setFont(textArea.getFont().deriveFont(35f));        }
        });
            fourty.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            textArea.setFont(textArea.getFont().deriveFont(40f));        }
        });
            fourtyfive.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            textArea.setFont(textArea.getFont().deriveFont(45f));        }
        });
            fifty.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            textArea.setFont(textArea.getFont().deriveFont(50f));        }
        });
            fiftyfive.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            textArea.setFont(textArea.getFont().deriveFont(55f));        }
        });
            sixty.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            textArea.setFont(textArea.getFont().deriveFont(60f));        }
        });
            sixtyfive.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            textArea.setFont(textArea.getFont().deriveFont(65f));        }
        });
            seventy.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            textArea.setFont(textArea.getFont().deriveFont(70f));        }
        });
            seventyfive.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            textArea.setFont(textArea.getFont().deriveFont(75f));        }
        });
            eighty.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            textArea.setFont(textArea.getFont().deriveFont(80f));        }
        });
            eightyfive.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            textArea.setFont(textArea.getFont().deriveFont(85f));        }
        });
            ninety.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            textArea.setFont(textArea.getFont().deriveFont(90f));        }
        });
            ninetyfive.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            textArea.setFont(textArea.getFont().deriveFont(95f));        }
        });
            hundred.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            textArea.setFont(textArea.getFont().deriveFont(100f));        }
        });
          
            
      about.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
        JOptionPane.showMessageDialog(null,
                    "Advance Notepad V 1.0\n Developed By  Jyotish kumar And His Team\n Email : Karnjyotish@gmail.com");    
        }
        });       
      
       tcolor.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
         color=JColorChooser.showDialog(null, "pick ur color", color);
             textArea.setForeground(color);
            if(color==null)
            {
            color=(Color.BLACK);
            textArea.setForeground(color);
           
        }}
        }); 
       help.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            
            
            JOptionPane.showMessageDialog(null,"Ctrl+ C for Copy \nCtrl+ X for cut \n Ctrl+ V for paste \n Ctrl+ A for Select All\n"
                    + "for More help Go on http://www.Microsoft.com  or Mail me :KarnJyotish@gmail.com");
        }});
     
    }
}
   
        
    
    

