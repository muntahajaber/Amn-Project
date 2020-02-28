public class Text {
	public String text;
	public Queue<Character> q1,q2,q3;//to split the text
	
	//constructur
	public Text(String s){
	text = s;
	set(s);
	}//end textED


	//setter
	public void set(String s){
	text = s;
	q1= new LinkedQueue();
	q2= new LinkedQueue();
	q3= new LinkedQueue();
	
	Character[] m=new Character[12];
	 
	for (int i=0;i<s.length();i++)
	m[i]=s.charAt(i);

	for(int i=0;i<4 ; i++)
	q1.enqueue(m[i]);

	for(int i=4;i<8 ;i++)
	q2.enqueue(m[i]);


	for(int i=8;i<12 ;i++)
	q3.enqueue(m[i]);


	}

	//encryption
	public String encryption(){
	String m="";
	//---3 Rounds---
	for (int i=0;i<3;i++){
	circularShift(1,q1);
	circularShift(2,q2);
	circularShift(1,q3);
	exchange();
	m=toString();
	m=railfence(m);
	set(m);
	}//---End Rounds---
	m=add(m);
	return m;
	}


	//decryption
	public String decryption(){
	String m=text;
	m=sub(m);
	//----3 Rounds----
	for (int i=0;i<3;i++){
	m=railfenceD(m);
	set(m);
	exchange();
	circularShift(3,q1);
	circularShift(2,q2);
	circularShift(3,q3);
	m=toString();
	 }//---End Rounds---
	return m; 
	}

	//-------------------- Encryption ----------------------------------
    //--------------------- Circular Shift----------------------------
	public void circularShift(int it,Queue q){

		for(int i = 0;i<it;i++)
		q.enqueue(q.serve());
		
		}

	//-------------------- split and combine ----------------------------
	public void exchange(){
	Queue<Character> q4 = new LinkedQueue();
	q4=q2;
	q2=q3;
	q3=q4;
	}
	//----------------rail fence with depth = 3---------------
	public String railfence(String plainText){
	int r=3,len=plainText.length();
	int c=len/3;
	char mat[][]=new char[r][c];
	int k=0;
	 
	String cipherText="";
	 
	for(int i=0;i< c;i++){
	for(int j=0;j< r;j++){
	if(k!=len)
	mat[j][i]=plainText.charAt(k++);
	else
	mat[j][i]='X';}}

	for(int i=0;i< r;i++){
	for(int j=0;j< c;j++){
	cipherText+=mat[i][j];}}

	
	return cipherText;
	} 
	// Reference for this methoed: https://itiansweb.blogspot.com/2015/10/rail-fence-cipher.html



	//------------------------------Add-------------------------
	public String add(String m){

	char ch[]=new char[12];  //
	String mess="";

	for(int i=0;i<m.length();i++){
	if(i%3==0){
	ch[i]=((char)((int)m.charAt(i)+1));
	mess+=ch[i];}
	else if(i%2==0){
	ch[i]=((char)((int)m.charAt(i)+2));
	mess+=ch[i];}
	else {
	ch[i]=((char)((int)m.charAt(i)+3));
	mess+=ch[i];}
	}

	return mess;
	}

	//-----------------------------------decryption---------------------

	//-------------------------------subtraction------------------------
	public String sub(String m){

	char ch[]=new char[12];
	String mess="";

	for(int i=0;i<m.length();i++){
	if(i%3==0){
	ch[i]=((char)((int)m.charAt(i)-1));
	mess+=ch[i];
	
	}else if(i%2==0){
	ch[i]=((char)((int)m.charAt(i)-2));
	mess+=ch[i];
	}else{
	ch[i]=((char)((int)m.charAt(i)-3));
	mess+=ch[i];
	}
	 }

	return mess;
	}

	//--------------------------rail fence---------------------
	public String railfenceD(String cipherText){
	int depth=3;
	int r=depth,len=cipherText.length();
	int c=len/depth;
	char mat[][]=new char[r][c];
	int k=0;
	 
	String plainText="";
	 
	for(int i=0;i< r;i++){
	for(int j=0;j< c;j++)
	mat[i][j]=cipherText.charAt(k++);
	}

	for(int i=0;i< c;i++){
	for(int j=0;j< r;j++)
	plainText+=mat[j][i];
	}
	return plainText;
	}

	// Reference for this methoed: https://itiansweb.blogspot.com/2015/10/rail-fence-cipher.html


	//To convert to string after the swaps
	public String toString(){

	Character[] b = new Character[12];

	for(int i=0;i<4;i++)
	b[i] = q1.serve();

	for(int i=4;i<8;i++)
	b[i] = q2.serve();

	for(int i=8;i<12;i++)
	b[i] = q3.serve();

	String mes="";

	for(int i=0;i<12;i++)
	mes+=b[i];

	return mes;
	}



}
