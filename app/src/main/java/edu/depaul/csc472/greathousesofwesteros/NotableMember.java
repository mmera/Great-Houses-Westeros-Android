package edu.depaul.csc472.greathousesofwesteros;

import android.os.Parcel;
import android.os.Parcelable;


/**
 * Created by Marco on 10/30/16.
 */

public class NotableMember implements Parcelable {

    private String name;
    private String description;

    public NotableMember(String name, String description) {
        this.name = name;
        this.description = description;

    }

    public NotableMember(Parcel in) {
        String[] data = new String[2];

        in.readStringArray(data);
        this.name = data[0];
        this.description=data[1];
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeStringArray(new String[]{this.name,this.description});
    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public NotableMember createFromParcel(Parcel in) {
            return new NotableMember(in);
        }

        @Override
        public NotableMember[] newArray(int size) {
            return new NotableMember[size];
        }
    };

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getLastName(){
        String[] names = name.split("\\s+");
        return names[names.length-1];
    }

}
