package algoritma_analizi;
import java.util.ArrayList;
import java.util.Scanner;
public class DynamicArray {

    private ArrayList<Object> liste;
    private int size,inObject; //boyutu ve eleman say�lar� tutuluyor

    //yap�c� metodlar burada bulunuyor
    public DynamicArray(){
        size = 0;
        inObject = 0;
    }
    public DynamicArray(Object [] liste){
        this.liste = new ArrayList<Object>(liste.length);
        for(int i = 0; i< liste.length; i++){
            this.liste.add(liste[i]);
        }
        size = liste.length; //boyut ekleniyor
        inObject = size; //boyut kadar eleman�d�r
    }

    public Object remove(){ //pop fonksiyonu 
        if(inObject != 0){ //eleman var m� diye kontrol ediyor
            int l = liste.size();
            ArrayList<Object> nList = new ArrayList<Object>(liste.size());
            for(int i=0; i<l-1; i++){ //liste yeniden olu�turuluyor
                nList.add(liste.get(i));
            }
            Object r = liste.get(l-1);
            liste = nList;
            inObject--; //eleman say�s� bir azalt�l�yor
            return r;
        }else{
            return null; //eleman yok ise
        }
    }

    public void append(Object tempObject) {
        if(inObject == size){ // eleman say�s� ve boyut e�it ise
            resizeOneObject(); //boyut art�r�l�r
            liste.add(tempObject); //eleman eklenir
            inObject++; //eleman say�s� bir artar
        }else{
            liste.add(tempObject); //e�er eleman say�s� s�n�rda de�ilse eleman eklenir
            inObject++; //eleman say�s� art�r�l�r
        }
    }

    //liste resize edildi fakat sadece 1 eleman eklenebilir
    private void resizeOneObject(){
        ArrayList<Object> mArrayList = new ArrayList<Object>();
        for(int i = 0; i < liste.size(); i++){ //b�y�k boyutlu yeni bir liste olu�turuluyor 
            mArrayList.add(liste.get(i));
        }
        liste = mArrayList;
        size++; //boyut art�r�l�yor
    }



    public static void main(String[] args){
        Scanner getter = new Scanner(System.in);
        DynamicArray dynamicArray = new DynamicArray();
        for(int i = 0; i < 10; i++){
            Object x = getter.nextLine();
            dynamicArray.append(x);
            System.out.println("\n");
        }
        System.out.println(dynamicArray.remove());
        dynamicArray.append(123);
        dynamicArray.append("tempObject");
        System.out.println(dynamicArray.remove());
        getter.close();
    }

}
