package de.breitenbach;

/**
 * Created by yamaneko on 28.01.2017.
 */
public class BPData
{
    private int BPL;
    private String DataID;
    private int HP;
    private int HR;
    private int LP;
    private long MDate;
    private String Note;
    private long LastChangeTime;
    private String DataSource;
    private String TimeZone;

    int getBPL()
    {
        return BPL;
    }

    void setBPL(int BPL)
    {
        this.BPL = BPL;
    }

    String getDataID()
    {
        return DataID;
    }

    void setDataID(String dataID)
    {
        DataID = dataID;
    }

    int getHP()
    {
        return HP;
    }

    void setHP(int HP)
    {
        this.HP = HP;
    }

    int getHR()
    {
        return HR;
    }

    void setHR(int HR)
    {
        this.HR = HR;
    }

    int getLP()
    {
        return LP;
    }

    void setLP(int LP)
    {
        this.LP = LP;
    }

    long getMDate()
    {
        return MDate;
    }

    void setMDate(long MDate)
    {
        this.MDate = MDate;
    }

    String getNote()
    {
        return Note;
    }

    void setNote(String note)
    {
        Note = note;
    }

    long getLastChangeTime()
    {
        return LastChangeTime;
    }

    void setLastChangeTime(long lastChangeTime)
    {
        LastChangeTime = lastChangeTime;
    }

    String getDataSource()
    {
        return DataSource;
    }

    void setDataSource(String dataSource)
    {
        DataSource = dataSource;
    }

    String getTimeZone()
    {
        return TimeZone;
    }

    void setTimeZone(String timeZone)
    {
        TimeZone = timeZone;
    }

    @Override
    public String toString()
    {

        return "iHealthBloodPressureData{\n" +
                "BPL=" + BPL +
                ", \nDataID='" + DataID + '\'' +
                ", \nHP=" + HP +
                ", \nHR=" + HR +
                ", \nLP=" + LP +
                ", \nMDate=" + MDate +
                ", \nNote='" + Note + '\'' +
                ", \nLastChangeTime=" + LastChangeTime +
                ", \nDataSource='" + DataSource + '\'' +
                ", \nTimeZone='" + TimeZone + '\'' +
                '}';
    }
}
