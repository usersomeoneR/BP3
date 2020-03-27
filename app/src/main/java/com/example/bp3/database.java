//package com.example.bp3;
//
//private void jsonParse(){
//        //De huidige gebruiker is een tester: dit is standaard 1234567
//        String url="";
//        String url="https://adaonboarding.ml/t1/Studentstap.php?studentnummer=1234567";
//        JsonObjectRequest request=new JsonObjectRequest(Request.Method.GET,url,null,
//        new Response.Listener<JSONObject>(){
//@Override
//public void onResponse(JSONObject response){
//        try{
//        JSONArray jsonArray=response.getJSONArray("rij");
//        for(int i=0;i<jsonArray.length();i++){
//        JSONObject rij=jsonArray.getJSONObject(i);
//
//        int id=rij.getInt("id");
//        int studentnummer=rij.getInt("studentnummer");
//        int stapnu=rij.getInt("stapnu");
//
//        mTextView.append("ID: "+String.valueOf(id)+", Studentnummer: "+String.valueOf(studentnummer)+", Stapnu: "+String.valueOf(stapnu)+"\n\n");
//
//        }
//        }catch(JSONException e){
//        e.printStackTrace();
//        }
//
//        }
//        },new Response.ErrorListener(){
//@Override
//public void onErrorResponse(VolleyError error){
//        error.printStackTrace();
//        }
//        });
//        mQueue.add(request);
//        }
//        }