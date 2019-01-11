package org.example.android.task1;

/**
 * Created by com on 04-07-2018.
 */

public class Custom_Container {
    private String mName;
    private String mAge;

    public Custom_Container (String Name , String Age){
        mName = Name;
        mAge = Age;
    }
    public String GetName(){
        return mName;
    }
    public String GetAge(){
        return mAge;
    }
}
