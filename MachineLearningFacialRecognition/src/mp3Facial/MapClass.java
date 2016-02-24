package mp3Facial;


public class MapClass implements Comparable<MapClass> {

	public double pro;
	public int label;
	 public int compareTo(MapClass arg0) 
     {
         if(this.pro < arg0.pro)
         {
             return -1;
         }
         else if(this.pro> arg0.pro)
         {
             return 1;
         }

         return 0;
     }
}
