package models;

/**
 * Created by erick on 30/10/2017.
 */

public class Dokter {
//    private int itemId;
//    private String title;
//    private String content;
//    private String recordDate;
//
//
//    public int getItemId() {
//        return itemId;
//    }
//
//    public void setItemId(int itemId) {
//        this.itemId = itemId;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public String getContent() {
//        return content;
//    }
//
//    public void setContent(String content) {
//        this.content = content;
//    }
//
//    public String getRecordDate() {
//        return recordDate;
//    }
//
//    public void setRecordDate(String recordDate) {
//        this.recordDate = recordDate;
//    }

    private int itemID;
    private String Nama;
    private String Alamat;
    private String Nia;

    //GET & SET ALAMAT
    public int getItemID(){
        return itemID;
    }
    public void setItemID(int itemID){
        this.itemID  = itemID;
    }

    //GET & SET NAMA
    public String getNama(){
        return Nama;
    }
    public void setNama(String Nama){
        this.Nama  = Nama;
    }

    //GET & SET ALAMAT
    public String getAlamat(){
        return Alamat;
    }
    public void setAlamat(String Alamat){
        this.Alamat  = Alamat;
    }

    //GET & SET NIA
    public String getNia(){
        return Nia;
    }
    public void setNia(String Nia){
        this.Nia  = Nia;
    }
}
