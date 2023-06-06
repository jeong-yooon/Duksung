package choijungyoon;
public class Box {

		static int numberOfBox;
		int width;
		int height;
		int length;
	
		
		Box(){
			width = height = length = 10;
			numberOfBox++;
		}
		
		Box(int width, int height, int length){
			
			this.width = width;
			this.height = height;
			this.length = length;
			numberOfBox++;
		}
		
		int getVolume() { return width*height*length;}
		static int getNumberOfBox() { return numberOfBox;}
}