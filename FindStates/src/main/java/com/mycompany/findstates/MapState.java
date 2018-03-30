
package com.mycompany.findstates;

import java.util.HashMap;


public class MapState {

    HashMap<String, String> map = new HashMap<String, String>();

    public  MapState() {
        map.put("andhra ", "AP");
        map.put("arunachal ", "AR");
        map.put("assam", "AS");
        map.put("bihar", "BR");
        map.put("chhattisgarh", "CG");

        map.put("goa", "GA");
        map.put("gujarat", "GJ");
        map.put("haryana", "HR");
        map.put("jammuandkashmir", "JK");
        
        map.put("himachalpradesh", "HP");

        map.put("jharkhand", "JH");
        map.put("karnataka", "KA");
        map.put("kerala", "KL");
        map.put("madhyapradesh", "MP");
        map.put("maharashtra", "MH");

        map.put("manipur", "MN");
        map.put("meghalaya", "ML");
        map.put("mizoram", "MZ");
        map.put("nagaland", "NL");
        map.put("orissa", "OR");

        map.put("punjab", "PB");
        map.put("rajasthan", "RJ");
        map.put("sikkim", "SK");
        map.put("tamilnadu", "TN");
        map.put("tripura", "TR");

        map.put("uttarakhand", "UK");
        map.put("uttarpradesh", "UP");
        map.put("westbengal", "WB");
        map.put("tamilnadu", "TN");
        map.put("tripura", "TR");

        map.put("andamanandnicobar", "AN");
        map.put("chandigarh", "CH");
        map.put("dadraandnagarhaveli", "DH");
        map.put("damananddiu", "DD");
        map.put("delhi", "DL");

        map.put("Lakshadweep", "LD");
        map.put("Pondicherry", "PY");

    }

    
     public String findAbr(String name){
         
         String finalname = name.toLowerCase().trim();
         
        return map.get(finalname);
        
    }
}
