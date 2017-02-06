package de.breitenbach;

/**
 * Created by yamaneko on 28.01.2017.
 */
public class WeightData
{
    private String DataSource;
    private String TimeZone;
    private float BMI;
    private String DataID;
    private long MDate;
    private String Note;
    private float WeightValue;
    private long LastChangeTime;
    private int userID;

    float getBMI()
    {
        return BMI;
    }

    void setBMI(float BMI)
    {
        this.BMI = BMI;
    }

    String getDataID()
    {
        return DataID;
    }

    void setDataID(String dataID)
    {
        DataID = dataID;
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

    float getWeightValue()
    {
        return WeightValue;
    }

    void setWeightValue(float weightValue)
    {
        WeightValue = weightValue;
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

    public int getUserID()
    {
        return userID;
    }

    public void setUserID(int userID)
    {
        this.userID = userID;
    }

    @Override
    public String toString()
    {
        return "iHealthWeightData{\n" +
                "BMI=" + BMI +
                ", \nDataID='" + DataID + '\'' +
                ", \nMDate=" + MDate +
                ", \nNote='" + Note + '\'' +
                ", \nWeightValue=" + WeightValue +
                ", \nLastChangeTime=" + LastChangeTime +
                ", \nDataSource='" + DataSource + '\'' +
                ", \nTimeZone='" + TimeZone + '\'' +
                '}';
    }
}
