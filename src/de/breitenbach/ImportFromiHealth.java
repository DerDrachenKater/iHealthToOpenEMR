package de.breitenbach;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;

class ImportFromiHealth
{
    static InputStream is = null;
    static UserData user;
    static WeightData[] weight;
    static BPData[] pressure;
    static BGData[] glucose;

    public static void getData()
    {
        getBPDataFromiHealth();
        getUserDataFromiHealth();
        getWeightDataFromiHealth();
        getBGDataFromiHealth();
    }

    public static void getWeightDataFromiHealth()
    {

       try
        {
            URL url = new URL("https://openapi.ihealthlabs.eu/openapiv2/user/43caf107534145bbb9079fc640c2e355/weight.json/?client_id=8adb7479352e4731aa9bd51b7358cf68&client_secret=803e5babac9d483daa6902b34906f874&redirect_uri=http://localhost&access_token=SRmuCFxq6pdDNM5cAi7OJ9ZUhcbriZnI5JfbVAu-ntbvgdMLizPKwnnZdML5-2YCXtuVg5vbX9wAomNSbQhQG1-pmU1YeXfqXxg5Kae6qFYQ9l2b89fC4*T72tsy4sQc0k20qXS4hmgB31jOh5ofYY2-z2Mwp4q5ar8Pzu9A*rpUngo-jhAEi*wKmf1CyT4GfP7LEOki0zj6Y6jf-jc8cQ&sc=C0BCC8D6FD3744569F950D7348284F27&sv=9125F3B8BEE54E14B23407E9303B81BF");
            is = url.openStream();
            String json = new Scanner(is).useDelimiter("\\Z").next();
            Gson gWson = new Gson();
            weight = gWson.fromJson(json, WeightData[].class);
            for ( int i = 0; i < weight.length; i++)
            {
                WeightDatabase.insertWeight(weight[i]);
            }

        } catch (Exception e)
        {
            System.err.println("Allgemeiner Fehler");
            e.printStackTrace();
        } finally
        {
            if (is != null)
            {
                try
                {
                    is.close();
                } catch (IOException e)
                {
                    System.err.println("IOFehler");
                    e.printStackTrace();
                }
            }
        }
    }

    public static void getUserDataFromiHealth()
    {
        try
        {
            URL url = new URL("https://openapi.ihealthlabs.eu/openapiv2/user/43caf107534145bbb9079fc640c2e355.json/?client_id=8adb7479352e4731aa9bd51b7358cf68&client_secret=803e5babac9d483daa6902b34906f874&redirect_uri=http://localhost&access_token=SRmuCFxq6pdDNM5cAi7OJ9ZUhcbriZnI5JfbVAu-ntbvgdMLizPKwnnZdML5-2YCXtuVg5vbX9wAomNSbQhQG1-pmU1YeXfqXxg5Kae6qFYQ9l2b89fC4*T72tsy4sQc0k20qXS4hmgB31jOh5ofYY2-z2Mwp4q5ar8Pzu9A*rpUngo-jhAEi*wKmf1CyT4GfP7LEOki0zj6Y6jf-jc8cQ&sc=C0BCC8D6FD3744569F950D7348284F27&sv=F1E0F88C1C944688967B9254B4395537&locale=de_DE");
            is = url.openStream();
            String json = new Scanner(is).useDelimiter("\\Z").next();
            Gson gUson = new Gson();
            user = gUson.fromJson(json, UserData.class);
            UserDatabase.insertUser(user);
        } catch (Exception e)
        {
            System.err.println("Allgemeiner Fehler");
            e.printStackTrace();
        } finally
        {
            if (is != null)
            {
                try
                {
                    is.close();
                } catch (IOException e)
                {
                    System.err.println("IO-Fehler");
                    e.printStackTrace();
                }
            }
        }
    }

    public static void getBPDataFromiHealth()
    {
        try
        {
            URL url = new URL("https://openapi.ihealthlabs.eu/openapiv2/user/43caf107534145bbb9079fc640c2e355/bp.json/?client_id=8adb7479352e4731aa9bd51b7358cf68&client_secret=803e5babac9d483daa6902b34906f874&redirect_uri=http://localhost&access_token=SRmuCFxq6pdDNM5cAi7OJ9ZUhcbriZnI5JfbVAu-ntbvgdMLizPKwnnZdML5-2YCXtuVg5vbX9wAomNSbQhQG1-pmU1YeXfqXxg5Kae6qFYQ9l2b89fC4*T72tsy4sQc0k20qXS4hmgB31jOh5ofYY2-z2Mwp4q5ar8Pzu9A*rpUngo-jhAEi*wKmf1CyT4GfP7LEOki0zj6Y6jf-jc8cQ&sc=C0BCC8D6FD3744569F950D7348284F27&sv=C6CFEE7A74724D01B8ACF94447962FD8");
            is = url.openStream();
            String json = new Scanner(is).useDelimiter("\\Z").next();
            Gson gPson = new Gson();
            pressure = gPson.fromJson(json, BPData[].class);

            for ( int i = 0; i < pressure.length; i++)
            {
                BPDatabase.insertBP(pressure[i]);
            }
        } catch (Exception e)
        {
            System.err.println("Allgemeiner Fehler");
            e.printStackTrace();
        } finally
        {
            if (is != null)
            {
                try
                {
                    is.close();
                } catch (IOException e)
                {
                    System.err.println("IO---Fehler");
                    e.printStackTrace();
                }
            }
        }
    }

    public static void getBGDataFromiHealth()
    {
        try
        {
            URL url = new URL("https://openapi.ihealthlabs.eu/openapiv2/user/43caf107534145bbb9079fc640c2e355/glucose.json/?client_id=8adb7479352e4731aa9bd51b7358cf68&client_secret=803e5babac9d483daa6902b34906f874&redirect_uri=http://localhost&access_token=SRmuCFxq6pdDNM5cAi7OJ9ZUhcbriZnI5JfbVAu-ntbvgdMLizPKwnnZdML5-2YCXtuVg5vbX9wAomNSbQhQG1-pmU1YeXfqXxg5Kae6qFYQ9l2b89fC4*T72tsy4sQc0k20qXS4hmgB31jOh5ofYY2-z2Mwp4q5ar8Pzu9A*rpUngo-jhAEi*wKmf1CyT4GfP7LEOki0zj6Y6jf-jc8cQ&sc=C0BCC8D6FD3744569F950D7348284F27&sv=76B31813CEE2403DB9512BD0E66FDAC5");
            is = url.openStream();
            String json = new Scanner(is).useDelimiter("\\Z").next();

            //System.out.println(new Scanner(is).useDelimiter("\\Z").next());
            Gson gGson = new Gson();
            glucose = gGson.fromJson(json, BGData[].class);

            for ( int i = 0; i < glucose.length; i++)
            {
                BGDatabase.insertBG(glucose[i]);
            }
        } catch (Exception e)
        {
            System.err.println("Allgemeiner Fehler");
            e.printStackTrace();
        } finally
        {
            if (is != null)
            {
                try
                {
                    is.close();
                } catch (IOException e)
                {
                    System.err.println("IO--Fehler");
                    e.printStackTrace();
                }
            }
        }
    }
}
