
package prolab2_p1;

import java.awt.Graphics;
import java.io.File;
import java.io.FileNotFoundException;
//import static java.lang.Integer.parseInt;
import java.util.LinkedList;
import java.util.*;
//import sun.security.provider.certpath.AdjacencyList;
//import java.util.Arrays;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
//import sun.java2d.loops.DrawLine;

public class Prolab2_p1{
    
    static class cizgi extends JPanel{
           int x;
           int y;
           int z;
           int t;
           Graphics g;
           
         public void paintt(int x,int y,int z,int t){
            this.x=x;
            this.y=y;
            this.z=z;
            this.t=t;
            paint(g);
        }  
           
        @Override
        public void paint(Graphics g){
            g.drawLine(x, y, z, t);
        }
                
        
    }
    static class kenar {
        int nereye;
        int nerden;
        int uzunluk;
        
 
        public kenar(int nerden, int nereye, int uzunluk) {
            this.nerden = nerden;
            this.nereye = nereye;
            this.uzunluk = uzunluk;
        }
        
       
    }
    static class Graf {
        
        LinkedList<kenar> [] LList;
        int sayac=0;
        int iladet=81;
        
        
        Graf(int iladet) {
            this.iladet = iladet;
            LList = new LinkedList[iladet];
           
            for (int i = 0; i <iladet ; i++) {
                 sayac++;
                LList[i] = new LinkedList<>();
                       

            }
        }
        public  void kenarekle(int nerden, int nereye, int uzunluk) {
            kenar kenar = new kenar(nerden, nereye, uzunluk);
            LList[nerden].add(kenar);
         
        }
    }
    static class git {
 
        int plk1;
        int plk2;
        int [][] Arr;
        Graf graf;
    
        
        
    public git(int plk1,int plk2, int [] [] Arr,Graf graf ){
        this.plk1=plk1;
        this.plk2=plk2;
        this.graf=graf;
        this.Arr=Arr;
    }
    
    public void gitf(){
       
        int uzunlukd;
        int plakad = 0;
        int bi=(plk1);
        int i=(plk1-1);
        
        while(Arr[i][plk2-1]!=0){
            LinkedList<kenar> er = graf.LList[i];
            
           
            uzunlukd=Arr[i][plk2-1];
            for(int j=0;j<er.size();j++){
                if(er.get(j).uzunluk!=0){
                    if(uzunlukd>Arr[j][plk2-1]){
                        uzunlukd=Arr[j][plk2-1];
                        plakad=j;
                        i=plakad;
                    }
                } 
            }   
            
               System.out.println( bi +"--->" +(plakad+1)+" Hedefe Kalan KM: "+uzunlukd);                                    
               bi=plakad+1;
        }
    }
        
}


    public static void main(String[] args) throws FileNotFoundException  {
       
        
       
        int kor [] [] = {{1,358,289},
                         {2,466,267},
                         {3,182,219},
                         {4,639,165},
                         {5,367,117},
                         {6,259,154},
                         {7,167,299},
                         {8,587,82},
                         {9,89,257},
                         {10,93,161},
                         {11,165,138},
                         {12,556,198},
                         {13,611,227},
                         {14,223,122},
                         {15,160,274},
                         {16,132,146},
                         {17,52,138},
                         {18,281,114},
                         {19,327,135},
                         {20,130,257},
                         {21,546,248},
                         {22,45,71},
                         {23,500,221},
                         {24,496,162},
                         {25,589,148},
                         {26,204,169},
                         {27,443,308},
                         {28,471,124},
                         {29,501,131},
                         {30,675,263},
                         {31,383,346},
                         {32,190,261},
                         {33,296,326},
                         {34,121,88},
                         {35,53,219},
                         {36,641,122},
                         {37,302,78},
                         {38,366,228},
                         {39,80,62},
                         {40,322,194},
                         {41,163,106},
                         {42,237,235},
                         {43,147,188},
                         {44,457,231},
                         {45,95,214},
                         {46,417,265},
                         {47,557,285},
                         {48,102,299},
                         {49,587,200},
                         {50,335,222},
                         {51,332,263},
                         {52,439,114},
                         {53,551,107},
                         {54,185,111},
                         {55,371,81},
                         {56,609,252},
                         {57,340,55},
                         {58,425,178},
                         {59,62,88},
                         {60,388,142},
                         {61,515,108},
                         {62,507,188},
                         {63,501,294},
                         {64,135,220},
                         {65,669,215},
                         {66,353,173},
                         {67,231,86},
                         {68,301,240},
                         {69,532,141},
                         {70,275,299},
                         {71,292,166},
                         {72,579,250},
                         {73,627,269},
                         {74,254,70},
                         {75,625,85},
                         {76,672,142},
                         {77,138,112},
                         {78,255,89},
                         {79,421,314},
                         {80,395,297},
                         {81,207,100}, };
        
        File kuzaklık = new File("C:\\prolab2_p1\\komsuuzaklik.txt");
        
      
        int iladet = 81;
        Graf  graf = new Graf(iladet);
       
        
        Scanner kUzak = new Scanner(kuzaklık);
        int i = 0;
        while(kUzak.hasNextLine()){
            int j=0;
            int ara;
            String gg = kUzak.nextLine();
            StringTokenizer ff = new StringTokenizer(gg,",");
            ff.nextElement(); 
            while(ff.hasMoreElements()){
                int b= Integer.parseInt(ff.nextElement().toString());
                ara=b;
                graf.kenarekle(i,j,ara);
                
                j++;
            }
            i++;
          
            
        }i=0;
        int [][] Arr = new int[81][81];
        File kArray = new File("C:\\prolab2_p1\\range.txt");
        Scanner kArr = new Scanner(kArray);
        while(kArr.hasNextLine()){
            int j=0;
            String na =kArr.nextLine();
            
            StringTokenizer vk = new StringTokenizer(na);
            while (vk.hasMoreElements()) {
               Arr[i][j]=Integer.parseInt(vk.nextElement().toString());
                
                j++;
            }
           i++;
        }
        
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        
        System.out.println("Gidilecek Sehri Giriniz:");
        Scanner gir1 =new Scanner(System.in);
        int plaka1 =gir1.nextInt();
        
        System.out.println("Gidilecek Sehri Giriniz:");
        Scanner gir2 =new Scanner(System.in);
        int plaka2 =gir2.nextInt();
        
        System.out.println("Gidilecek Sehri Giriniz:");
        Scanner gir3 =new Scanner(System.in);
        int plaka3 =gir3.nextInt();
        
        int merkez=41;
        
        int enkisayol;
        int enuzakyol;
        int yol1=(Arr[merkez-1][plaka1-1]+Arr[plaka1-1][plaka2-1]+Arr[plaka2-1][plaka3-1]+Arr[plaka3-1][merkez-1]);
        enkisayol=yol1;
        enuzakyol=yol1;
        int yol2=(Arr[merkez-1][plaka1-1]+Arr[plaka1-1][plaka3-1]+Arr[plaka3-1][plaka2-1]+Arr[plaka2-1][merkez-1]);       
        int yol3=(Arr[merkez-1][plaka2-1]+Arr[plaka2-1][plaka1-1]+Arr[plaka1-1][plaka3-1]+Arr[plaka3-1][merkez-1]);
        
        
        if(yol2>enuzakyol){
            enuzakyol=yol2;
        }
        
        if(yol3>enuzakyol){
            enuzakyol=yol3;
        }
        
        if(yol2<enkisayol){
            enkisayol=yol2;
        }
        
        if(yol3<enkisayol){
            enkisayol=yol3;
        }
        System.out.println();
        System.out.println("Gidilebilecek en 1.kısa yol ="+enkisayol);
        if((yol1<enuzakyol && yol1>enkisayol) || yol1==enuzakyol || yol1==enkisayol){
            System.out.println("Gidilebilecek alternatif 2.yol ="+yol1);
        }else if((yol2<enuzakyol && yol2>enkisayol) || yol2==enuzakyol || yol2==enkisayol){
            System.out.println("Gidilebilecek alternatif 2.yol ="+yol2);
        }else if((yol3<enuzakyol && yol3>enkisayol) || yol3==enuzakyol || yol3==enkisayol){
            System.out.println("Gidilebilecek alternatif 2.yol ="+yol3);
        }
        System.out.println("Gidilebilecek alternatif 3.yol ="+enuzakyol);
        System.out.println();
        System.out.println("En kısa yolun güzergahı =");
        
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // EKRAN///////////////////////
         JFrame ekran = new JFrame();
         ekran.setSize(716, 380);
        ekran.setVisible(true);
        ekran.setResizable(false);
        
        JLabel jLabel1 = new javax.swing.JLabel();
        JPanel jPanel1 = new javax.swing.JPanel();

        ekran.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        ekran.getContentPane().setLayout(null);

         javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 340, Short.MAX_VALUE)
        );
        
        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\prolab2_p1\\map.jpg")); // NOI18N
       ekran.getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 700, 340);

       

        ekran.getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 700, 340);
        
        
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        
        if(enkisayol==yol1){
            
        git git1=new git(41,plaka1,Arr,graf);
        git1.gitf();
        System.out.println();
          
        git git2=new git(plaka1,plaka2,Arr,graf);
        git2.gitf();
        System.out.println();
          
        git git3=new git(plaka2,plaka3,Arr,graf);
        git3.gitf();
        System.out.println();
        
        git git4=new git(plaka3,41,Arr,graf);
        git4.gitf();
            
        }else if(enkisayol==yol2){
            
        git git1=new git(41,plaka1,Arr,graf);
        git1.gitf();
        System.out.println();
          
        git git2=new git(plaka1,plaka3,Arr,graf);
        git2.gitf();
        System.out.println();
          
        git git3=new git(plaka3,plaka2,Arr,graf);
        git3.gitf();
        System.out.println();
        
        git git4=new git(plaka2,41,Arr,graf);
        git4.gitf(); 
            
            
            
        }else {
            
        git git1=new git(41,plaka2,Arr,graf);
        git1.gitf();
        System.out.println();
          
        git git2=new git(plaka2,plaka1,Arr,graf);
        git2.gitf();
        System.out.println();
          
        git git3=new git(plaka1,plaka3,Arr,graf);
        git3.gitf();
        System.out.println();
        
        git git4=new git(plaka3,41,Arr,graf);
        git4.gitf();
            
        }
       
        
     
    }}
