package com.wk.materialnewfeaturedemo;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * User: WangKai(123940232@qq.com)
 * 2015-06-18 17:17
 */
public class Person implements Parcelable {
    private String name;
    private String age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.age);
    }

    public Person() {
    }

    protected Person(Parcel in) {
        this.name = in.readString();
        this.age = in.readString();
    }

    public static final Parcelable.Creator<Person> CREATOR = new Parcelable.Creator<Person>() {
        public Person createFromParcel(Parcel source) {
            return new Person(source);
        }

        public Person[] newArray(int size) {
            return new Person[size];
        }
    };
}
