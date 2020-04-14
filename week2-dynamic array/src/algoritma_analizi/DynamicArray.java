package algoritma_analizi;
import java.util.ArrayList;
import java.util.Scanner;
public class DynamicArray {

    private ArrayList<Object> liste;
    private int size,inObject; //boyutu ve eleman sayýlarý tutuluyor

    //yapýcý metodlar burada bulunuyor
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
        inObject = size; //boyut kadar elemanýdýr
    }

    public Object remove(){ //pop fonksiyonu 
        if(inObject != 0){ //eleman var mý diye kontrol ediyor
            int l = liste.size();
            ArrayList<Object> nList = new ArrayList<Object>(liste.size());
            for(int i=0; i<l-1; i++){ //liste yeniden oluþturuluyor
                nList.add(liste.get(i));
            }
            Object r = liste.get(l-1);
            liste = nList;
            inObject--; //eleman sayýsý bir azaltýlýyor
            return r;
        }else{
            return null; //eleman yok ise
        }
    }

    public void append(Object tempObject) {
        if(inObject == size){ // eleman sayýsý ve boyut eþit ise
            resizeOneObject(); //boyut artýrýlýr
            liste.add(tempObject); //eleman eklenir
            inObject++; //eleman sayýsý bir artar
        }else{
            liste.add(tempObject); //eðer eleman sayýsý sýnýrda deðilse eleman eklenir
            inObject++; //eleman sayýsý artýrýlýr
        }
    }

    //liste resize edildi fakat sadece 1 eleman eklenebilir
    private void resizeOneObject(){
        ArrayList<Object> mArrayList = new ArrayList<Object>();
        for(int i = 0; i < liste.size(); i++){ //büyük boyutlu yeni bir liste oluþturuluyor 
            mArrayList.add(liste.get(i));
        }
        liste = mArrayList;
        size++; //boyut artýrýlýyor
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
