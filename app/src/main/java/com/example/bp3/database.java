//package com.example.bp3;
//
////private void jsonParse(){
////        //De huidige gebruiker is een tester: dit is standaard 1234567
////        String url="";
////        String url="https://adaonboarding.ml/t1/Studentstap.php?studentnummer=1234567";
////        JsonObjectRequest request=new JsonObjectRequest(Request.Method.GET,url,null,
////        new Response.Listener<JSONObject>(){
////@Override
////public void onResponse(JSONObject response){
////        try{
////        JSONArray jsonArray=response.getJSONArray("rij");
////        for(int i=0;i<jsonArray.length();i++){
////        JSONObject rij=jsonArray.getJSONObject(i);
////
////        int id=rij.getInt("id");
////        int studentnummer=rij.getInt("studentnummer");
////        int stapnu=rij.getInt("stapnu");
////
////        mTextView.append("ID: "+String.valueOf(id)+", Studentnummer: "+String.valueOf(studentnummer)+", Stapnu: "+String.valueOf(stapnu)+"\n\n");
////
////        }
////        }catch(JSONException e){
////        e.printStackTrace();
////        }
////
////        }
////        },new Response.ErrorListener(){
////@Override
////public void onErrorResponse(VolleyError error){
////        error.printStackTrace();
////        }
////        });
////        mQueue.add(request);
////        }
////        }

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

//public class database {
//
//
//    Connection conn; //Globale variabelen die je overal in je class kan gebruiken.
//    Statement stmt;
//
//    //Hier maak ik connectie met mijn database.
//    /**
//     *
//     */
//    public database() {
//        //Ik probeer eerst iets, lukt het niet, laat hier zien wat er mis kan gaan
//        try {
//            conn = DriverManager.getConnection("https://adaonboarding.ml/t1/Studentgegevens.php?studentnummer=1234567");
//            stmt = conn.createStatement();
//        } catch (SQLException ex) {
//            Logger.getLogger(database.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//
//    //Haal data op. Dit is een verkorte versie, zodat ik niet telkens dit opnieuw hoef te typen.
//    //Alleen voor SELECT statements
//
//    /**
//     *
//     * @param strSQL
//     * @return
//     */
//    public ResultSet getData(String strSQL) {
//        ResultSet result = null;
//        strSQL ="SELECT gebruikersnaam FROM studentgegevens WHERE studentnummer=1234567";
//        //Ik probeer eerst iets, lukt het niet, laat hier zien wat er mis kan gaan
//        try {
//            result = stmt.executeQuery(strSQL);
//        } catch (Exception e) {
//            System.err.println(e.getMessage());
//        }
//        return result;
//    }
//    //'Verander' data, als het ware. Dit is een verkorte versie, zodat ik niet telkens dit opnieuw hoef te typen.
//    //Deze functie is alleen voor de UPDATE, DELETE en INSERT statements.
//    /**
//     *
//     * @param strSQL
//     * @return
//     */
//    public int executeDML(String strSQL) {
//        int result = 0;
//
//        //Ik probeer eerst iets, lukt het niet, laat hier zien wat er mis kan gaan
//        try {
//            result = stmt.executeUpdate(strSQL);
//
//        } catch (Exception e) {
//            System.err.println(e.getMessage());
//        }
//        return result;
//    }
//
//}