package com.android.example.spongebobcharacter.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class Characters implements Parcelable {

    private String mNama, mPengisiSuara, mDeskripsi, mFoto;

    public Characters() {
    }

    protected Characters(Parcel in) {
        this.mNama = in.readString();
        this.mDeskripsi = in.readString();
        this.mFoto = in.readString();
        this.mPengisiSuara = in.readString();
    }

    public static final Creator<Characters> CREATOR = new Creator<Characters>() {
        @Override
        public Characters createFromParcel(Parcel source) {
            return new Characters(source);
        }

        @Override
        public Characters[] newArray(int size) {
            return new Characters[size];
        }
    };

    public String getmNama() {
        return mNama;
    }

    public void setmNama(String mNama) {
        this.mNama = mNama;
    }

    public String getmPengisiSuara() {
        return mPengisiSuara;
    }

    public void setmPengisiSuara(String mPengisiSuara) {
        this.mPengisiSuara = mPengisiSuara;
    }

    public String getmDeskripsi() {
        return mDeskripsi;
    }

    public void setmDeskripsi(String mDeskripsi) {
        this.mDeskripsi = mDeskripsi;
    }

    public String getmFoto() {
        return mFoto;
    }

    public void setmFoto(String mFoto) {
        this.mFoto = mFoto;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.mNama);
        dest.writeString(this.mDeskripsi);
        dest.writeString(this.mPengisiSuara);
        dest.writeString(this.mFoto);
    }
}
