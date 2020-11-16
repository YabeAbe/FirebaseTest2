package com.example.firebasetest2;

import java.util.HashMap;

public class Family {
    public String familyName;
    public String familyAddress;
    public HashMap<String, Person> familyMemberMap;

    public Family() {

    }

    public Family(String _familyName, String _familyAddress, HashMap<String, Person> _personMap) {
        familyName = _familyName;
        familyMemberMap = _personMap;
        familyAddress = _familyAddress;
    }
}
