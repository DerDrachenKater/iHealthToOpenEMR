package de.breitenbach;

/**
 * Created by yamaneko on 28.01.2017.
 */
public class iHealthBloodPressureData
{
    int BPL;
    String DataID;
    int HP;
    int HR;
    int LP;
    long MDate;
    String Note;
    long LastChangeTime;
    String DataSource;
    String TimeZone;

    @Override
    public String toString()
    {
        return "iHealthBloodPressureData{" +
                "BPL=" + BPL +
                ", DataID='" + DataID + '\'' +
                ", HP=" + HP +
                ", HR=" + HR +
                ", LP=" + LP +
                ", MDate=" + MDate +
                ", Note='" + Note + '\'' +
                ", LastChangeTime=" + LastChangeTime +
                ", DataSource='" + DataSource + '\'' +
                ", TimeZone='" + TimeZone + '\'' +
                '}';
    }
}
