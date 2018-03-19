package calculate;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;


public class Main {
	public static String s= new String();
	public static int n;
	//����ķ���Ϊ��ʽ����
    public static String simplification(int a,int b){
        int y = 1;
        for(int i=a;i>=1;i--){
            if(a%i==0&&b%i==0){
                y = i;
                break;
            }
        }
        int z = a/y;
        int m = b/y;
        if(z==0) {
            return "0";
        }
        return ""+z+"/"+m;
    }   
       
     //����ķ���Ϊ��������Ӽ��˳����ַ�
    public static String Sign(int a){
    	if(a==0)
    		return "+";
    	if(a==1)
    		return "-";
    	if(a==2)
    		return "*";
    	if(a==3)
    		return "/";
    	return "";
    }
    	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int i,result;
		File writename = new File("result.txt"); // ���·�������û����Ҫ����һ���µ�result.txt�ļ�
		try{
		writename.createNewFile(); // �������ļ�
		}catch(IOException e)
		{
			e.printStackTrace();
		}
       
		System.out.println("��������Ŀ������1-1000");
        Scanner in=new Scanner(System.in);
        n=-1;        		
       // boolean flag=true;
        while(n<1||n>1000)
        {
        //while(true){

          try{

        	  n=in.nextInt();
        	  

          }catch(Exception e){

              System.out.println("����������������������");

              in.next();
              //flag = false;
              n=0;
              //e.printStackTrace();  
        }
         if((n<1||n>1000)&&n!=0)
        	 System.out.println("����������������������");
        //}
        }
        BufferedWriter out = new BufferedWriter(new FileWriter(writename));
        out.write("201571030118\r\n"); // \r\n��Ϊ���� 
         // n=in.nextInt();
        int value;
        for(i=0;i<n;i++){
            int num1=(int)(Math.random()*100);//�������һ��0-100������
            int num2=(int)(Math.random()*100);//�������һ��0-100������
            int num3=(int)(Math.random()*100);//�������һ��0-100������
            int num4=(int)(Math.random()*100);//�������һ��0-100������
            int num5=(int)(Math.random()*100);//�������һ��0-100������
            int numn=(int)(Math.random()*4);//�������һ��0-3������,0��ʾ3����������1��ʾ4����������2��ʾ5��������,3��ʾ��������
            switch(numn)
            {
               case 0:
            	    s=threenum(num1,num2,num3);
            	    value = jisuan(s);
            	    if(value==-1)
            	    	i--;
            	    else
            	    	out.write(s+value+"\r\n"); // \r\n��Ϊ����    
            	   // System.out.println(s+value);
            	    break;
               case 1:
            	   s=fournum(num1,num2,num3,num4);
            	   //System.out.println(s);
           	    value = jisuan(s);
           	    if(value==-1)
           	    	i--;
           	    else
           	    	out.write(s+value+"\r\n"); // \r\n��Ϊ����
           	    	//System.out.println(s+value);
           	    break;
               case 2:
            	   s=fivenum(num1,num2,num3,num4,num5);
            	   //System.out.println(s);
           	    value = jisuan(s);
           	    if(value==-1)
           	    	i--;
           	    else
           	    	out.write(s+value+"\r\n"); // \r\n��Ϊ����
           	    	//System.out.println(s+value);
           	    break;
               case 3:
            	    num1=1+(int)(Math.random()*100);//�������һ��0-100������
                    num2=1+(int)(Math.random()*100);//�������һ��0-100������
                    num3=1+(int)(Math.random()*100);//�������һ��0-100������
            	   int M,Z;
                   int x1,x2,x3;
                       x1=1+(int)(Math.random()*num1);//����һ���ȷ�ĸnum1С�ķ��ӣ�ʵ�������
                       x2=1+(int)(Math.random()*num2);//����һ���ȷ�ĸnum2С�ķ��ӣ�ʵ�������
                       x3=1+(int)(Math.random()*num3);//����һ���ȷ�ĸnum3С�ķ��ӣ�ʵ�������
                           Z=x1*num2*num3+x2*num1*num3+x3*num1*num2;
                           M=num1*num2*num3;
                           String d=simplification(Z,M);
                           s=x1+"/"+num1+"+"+x2+"/"+num2+"+"+x3+"/"+num3+"="+d;
                           out.write(s+"\r\n"); // \r\n��Ϊ����
                          // System.out.println(s);
            	}
            out.flush();
        }
        }
        
        
       
        
        //����Ϊ3��������������ʽ�Ĳ���������
        public static String threenum(int num1,int num2,int num3)
        {
        	String s1= new String();
        	int sign1=(int)(Math.random()*4);//�������һ��0-3��������0��ʾ�ӷ���1��ʾ������2��ʾ�˷���3��ʾ����
        	int sign2=(int)(Math.random()*4);//�������һ��0-3��������0��ʾ�ӷ���1��ʾ������2��ʾ�˷���3��ʾ����
        	int sign3=(int)(Math.random()*2);//�����1��ʾ�����ţ������0 ��ʾ������
        	int sign4=(int)(Math.random()*2);//�����1��ʾ������ʽ�������0 ��ʾ��ʽ��
        	// switch(sign4)
            // {
                //case 0:
                	if(sign1==sign2)
                	{
                		sign2=(sign1+1)%3;//��֤�������������ͬ��
                	}
                	
                	if(sign3==0)//��ʾ������
                	{
                		//����Ĺ���Ϊ�ų����������ģ����з�ĸΪ0��
                		if(sign1==3)
                		{
                			if(num2==0)//�����ĸΪ0
                					num2=1+(int)(Math.random()*100);//�������һ��1-100������
                		    while(num1%num2!=0)
                		    {
                		    	num1=(int)(Math.random()*100);
                		    }
                		}
                		    	
                		if(sign2==3)
                		{
                			if(num3==0)//�����ĸΪ0
                			       num3=1+(int)(Math.random()*100);//�������һ��1-100������
                		 	while(num2%num3!=0)
                		 	{
                		 		num2=(int)(Math.random()*100);
                		 	}
                		}
                		s1= num1+Sign(sign1)+num2+Sign(sign2)+num3+"=";
                		return s1;	
                	}
                	else  //��ʾ������
                	{
                		int location=(int)(Math.random()*1);//�����0��ʾ������ǰ�������1 ��ʾ�����ں�
                		if(location==0)
                		{
                			if(sign1==3)
                			{
                				if(num2==0)//�����ĸΪ0
                					num2=1+(int)(Math.random()*100);//�������һ��1-100������
                				while(num1%num2!=0)
                				{
                					num1=(int)(Math.random()*100);
                				}
                			}
                			if(sign2==3)
                			{
                				if(num3==0)//�����ĸΪ0
                			       num3=1+(int)(Math.random()*100);//�������һ��1-100
                				if(sign1==0)
                					while((num1+num2)%num3!=0)
                    				{
                    					num3=1+(int)(Math.random()*100);
                    				}
                				if(sign1==1)
                					while((num1-num2)%num3!=0)
                    				{
                    					num3=1+(int)(Math.random()*100);
                    				}
                				if(sign1==2)
                					while((num1*num2)%num3!=0)
                    				{
                    					num3=1+(int)(Math.random()*100);
                    				}
                			}
                			 s1= "("+num1+Sign(sign1)+num2+")"+Sign(sign2)+num3+"=";  
                		if(location==1)
                			if(sign2==3)
                			{
                				if(num3==0)//�����ĸΪ0
                			       num3=1+(int)(Math.random()*100);//�������һ��1-100������
                				while(num2%num3!=0)
                				{
                					num2=(int)(Math.random()*100);
                				}
                			}
                			if(sign1==3)//��������ں����е�һ������λ/
                			{
                				if(sign2==0)
                				{
                					if(num2==0&&num3==0)
                						num3=1+(int)(Math.random()*100);//�������һ��1-100������
                					while(num1%(num2+num3)!=0)
                						num1=(int)(Math.random()*100);
                				}
                			    if(sign2==1)
                			    {
                			    	if(num2==num3)   //���������Ϊ0�ˣ��ڳ�����
                			    		num2=num3+1+(int)(Math.random()*100);
                			    	while(num1%(num2-num3)!=0)
                						num1=(int)(Math.random()*100);
                			    }
                			    if(sign2==2)
                			    {
                			    	if(num2==0)
                			    		num2=1+(int)(Math.random()*100);
                			        if(num3==0)
                			        	num3=1+(int)(Math.random()*100);
                			        while(num1%(num2*num3)!=0)
                						num1=(int)(Math.random()*100);
                			    }
                			    s1= num1+Sign(sign1)+"("+num2+Sign(sign2)+num3+")"+"=";  
                			}	     		
                		
                		return s1;
                	}
                }
                	return s1;
                	
        }

           
        	
      //����Ϊ4��������������ʽ�Ĳ���������
        public static String fournum(int num1,int num2,int num3,int num4)
        {
        	String s1= new String();
        	int sign1=(int)(Math.random()*4);//�������һ��0-3��������0��ʾ�ӷ���1��ʾ������2��ʾ�˷���3��ʾ����
        	int sign2=(int)(Math.random()*4);//�������һ��0-3��������0��ʾ�ӷ���1��ʾ������2��ʾ�˷���3��ʾ����
        	int sign3=(int)(Math.random()*4);//�������һ��0-3��������0��ʾ�ӷ���1��ʾ������2��ʾ�˷���3��ʾ����
            if(sign1==sign2)
                sign2=(sign1+1)%3;//��֤�������������ͬ��
             if(sign2==sign3)
            	 sign3=(sign2+1)%3;//��֤�������������ͬ��
                	
                //����Ĺ���Ϊ�ų����������ģ����з�ĸΪ0��
               if(sign1==3)
               {
                	if(num2==0)//�����ĸΪ0
                		num2=1+(int)(Math.random()*100);//�������һ��1-100������
                	    while(num1%num2!=0)
                	    {
                		   num1=(int)(Math.random()*100);
                	     }
               }
               if(sign2==3)
               {
            	   if(num3==0)//�����ĸΪ0
               		num3=1+(int)(Math.random()*100);//�������һ��1-100������
               	    while(num2%num3!=0)
               	    {
               		   num2=(int)(Math.random()*100);
               	     }
               }
               if(sign3==3)
               {
            	   if(num4==0)//�����ĸΪ0
               		num4=1+(int)(Math.random()*100);//�������һ��1-100������
               	    while(num3%num4!=0)
               	    {
               		   num3=(int)(Math.random()*100);
               	    }
               }
               s1= num1+Sign(sign1)+num2+Sign(sign2)+num3+Sign(sign3)+num4+"=";
               return s1;
        }
                	
      //����Ϊ5��������������ʽ�Ĳ���������
        public static String fivenum(int num1,int num2,int num3,int num4,int num5)
        {
        	String s1= new String();
        	int sign1=(int)(Math.random()*4);//�������һ��0-3��������0��ʾ�ӷ���1��ʾ������2��ʾ�˷���3��ʾ����
        	int sign2=(int)(Math.random()*4);//�������һ��0-3��������0��ʾ�ӷ���1��ʾ������2��ʾ�˷���3��ʾ����
        	int sign3=(int)(Math.random()*4);//�������һ��0-3��������0��ʾ�ӷ���1��ʾ������2��ʾ�˷���3��ʾ����
        	int sign4=(int)(Math.random()*4);//�������һ��0-3��������0��ʾ�ӷ���1��ʾ������2��ʾ�˷���3��ʾ����
            if(sign1==sign2)
                sign2=(sign1+1)%3;//��֤�������������ͬ��
             if(sign2==sign3)
            	 sign3=(sign2+1)%3;//��֤�������������ͬ��
             if(sign3==sign4)
            	 sign4=(sign3+1)%3;//��֤�������������ͬ��
                	
                //����Ĺ���Ϊ�ų����������ģ����з�ĸΪ0��
               if(sign1==3)
               {
                	if(num2==0)//�����ĸΪ0
                		num2=1+(int)(Math.random()*100);//�������һ��1-100������
                	    while(num1%num2!=0)
                	    {
                		   num1=(int)(Math.random()*100);
                	     }
               }
               if(sign2==3)
               {
            	   if(num3==0)//�����ĸΪ0
               		num3=1+(int)(Math.random()*100);//�������һ��1-100������
               	    while(num2%num3!=0)
               	    {
               		   num2=(int)(Math.random()*100);
               	     }
               }
               if(sign3==3)
               {
            	   if(num4==0)//�����ĸΪ0
               		num4=1+(int)(Math.random()*100);//�������һ��1-100������
               	    while(num3%num4!=0)
               	    {
               		   num3=(int)(Math.random()*100);
               	    }
               }
               if(sign4==3)
               {
            	   if(num5==0)//�����ĸΪ0
               		num5=1+(int)(Math.random()*100);//�������һ��1-100������
               	    while(num4%num5!=0)
               	    {
               		   num4=(int)(Math.random()*100);
               	    }
               }
               s1= num1+Sign(sign1)+num2+Sign(sign2)+num3+Sign(sign3)+num4+Sign(sign4)+num5+"=";
               return s1; 
        }
//====================================================================================
        //����ķ���Ϊ�����沨���ķ����ų�����ʽ��Ϊ������������������ʽ�Ľ��
        
       
        	public static int jisuan(String s) {
        		Stack<Integer> stack1 = new Stack<Integer>();//������
        		Stack<String> stack2 = new Stack<String>();//�Ų�����
        		HashMap<String, Integer> hashmap = new HashMap<String, Integer>();//�����������ȼ���
        		hashmap.put("(", 0);
        		hashmap.put("+", 1);
        		hashmap.put("-", 1);
        		hashmap.put("*", 2);
        		hashmap.put("/", 2);
        		//int tiao = 0;
        		for (int i = 0; i < s.length();) {
        			StringBuffer digit = new StringBuffer();  //StringBuffer���еķ�����Ҫƫ���ڶ����ַ����ı仯��
                                 //      ����׷�ӡ������ɾ���ȣ����Ҳ��StringBuffer��String�����Ҫ����
        			char c = s.charAt(i);//��ʽ���ַ����и�Ϊc�ַ�
        			while (Character.isDigit(c)) {//�ж��ַ��Ƿ�Ϊ10��������,��һ��������digit
        				digit.append(c);
        				i++;
        				c = s.charAt(i);
        			}
        			if (digit.length() == 0) 
        			{  //��ǰdigit�����Ѿ������֣�����ǰ��������
        				switch (c) {
        					case '(': {
        						stack2.push(String.valueOf(c));//����ǣ�   ת��Ϊ�ַ���ѹ���ַ�ջ
        						break;
        						}
        					case ')': {//�����������˼��㣬��Ϊ�������ȼ����
        						String stmp = stack2.pop();//����ǣ���������ջջ��Ԫ��ȡ��
        						while (!stack2.isEmpty() && !stmp.equals("(")) { //��ǰ����ջ���滹��+ - * /
        							int a = stack1.pop();  //ȡ������a,b
        							int b = stack1.pop();
        							int sresulat = calculate(b, a, stmp);//����
        							if(sresulat<0)
        								return  -1;
        							stack1.push(sresulat);//�����ѹ��ջ
        							stmp = stack2.pop();//����ָ����һ���������
        						}
        						break;
        						}
        					case '=': {//�����Ⱥ��˼��㣬
        						String stmp;
        						while (!stack2.isEmpty()) {//��ǰ����ջ���滹��+ - * /,����û������
        							stmp = stack2.pop();
        							int a = stack1.pop();
        							int b = stack1.pop();
        							int sresulat = calculate(b, a, stmp);
        							if(sresulat<0)
        								return  -1;
        							stack1.push(sresulat);
        							}
        							break;
        							}
        					default: {  //������֮ǰ���κ����
        						String stmp;
        						while (!stack2.isEmpty()) { //�������ջ�з���
        							stmp = stack2.pop(); //��ǰ����ջ��ջ��Ԫ��
        							if (hashmap.get(stmp) >= hashmap.get(String.valueOf(c))) {//�Ƚ����ȼ�
        								int a = stack1.pop();
        								int b = stack1.pop();
        								int sresulat =calculate (b, a, stmp);
        								if(sresulat<0)
            								return  -1;
        								stack1.push(sresulat);
        								} 
        							else {
        								stack2.push(stmp);
        								break;
        								}

        						}
        						stack2.push(String.valueOf(c));  //������ѹ�����ջ
        						break;
        						}
        					}
        				} 
        			else {//�������֣�ֱ��ѹջ
        				stack1.push(Integer.valueOf(digit.toString()));
        				continue;
        				}
        				i++;
        			}
        		return stack1.peek();  //����ջ�����ּ���ʽ�Ĵ𰸡�
        	}

        	public static int calculate(int a, int b, String stmp) {//����a stmp b��ֵ
        		int res = 0;//����
        		char s = stmp.charAt(0);
        		switch (s) {
        		  case '+': {
        			res = a + b;
        			break;
        		  }
        		  case '-': {
        			res = a - b;

        			break;
        		  }
        		  case '*': {
        			res = a * b;
        			break;
        		  }
        		  case '/': {
        			  if(b==0)
        				  return -1;
        			  else
        			      res = a / b;
        			break;
        		  }
        		}
        		return res;
        	}
}



                    

        

           

             
               
               
               
               
               
               
               
               
               
               
               
               
               
               
               
               
               
               
               
               
               
               
               
               
               
               
               
               
               
               
            	

