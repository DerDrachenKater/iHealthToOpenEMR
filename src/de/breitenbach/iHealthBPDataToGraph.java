package de.breitenbach;

import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYChartBuilder;
import org.knowm.xchart.XYSeries;
import org.knowm.xchart.style.Styler;
import org.knowm.xchart.style.colors.XChartSeriesColors;
import org.knowm.xchart.style.lines.SeriesLines;
import org.knowm.xchart.style.markers.SeriesMarkers;

import java.awt.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class iHealthBPDataToGraph
{


    static XYChart paintBPTGraph()
    {
        XYChart graph = new XYChartBuilder().width(800).height(600).title("Gewicht").theme(Styler.ChartTheme.GGPlot2)
                .build();
        graph.getStyler().setLegendPosition(Styler.LegendPosition.InsideNE);
        graph.getStyler().setDefaultSeriesRenderStyle(XYSeries.XYSeriesRenderStyle.Line);

        String[][] table = iHealthWeightDB.selectWeight();
        List<Date> dates = new ArrayList<Date>();
        List<Double> systole = new ArrayList<>();
        List<Double> diastole = new ArrayList<>();

        DateFormat sdf = new SimpleDateFormat("YYYY-MM-DD HH:mm:ss.S");
        Date date = null;

        for ( int  i = 0; i < table.length; i++)
        {
            try
            {
                date = sdf.parse(table[i][2]);
            }catch (ParseException pe)
            {
                pe.printStackTrace();
            }
            systole.add(Double.parseDouble(table[i][3]));
            diastole.add(Double.parseDouble(table[i][4]));
            dates.add(date);
        }
        graph.addSeries("Systole", dates,systole);
        graph.addSeries("Diastole", dates, diastole);

        return graph;
    }
}
