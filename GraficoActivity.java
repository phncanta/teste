package com.example.appfinancas;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;

import java.util.ArrayList;

public class GraficoActivity extends AppCompatActivity {

    private LineChart lineChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grafico);

        lineChart = findViewById(R.id.lineChart);

        if (lineChart == null) {
            throw new RuntimeException("LineChart não encontrado. Verifique o XML activity_grafico.xml");
        }

        setupChart();
        loadChartData();
    }

    private void setupChart() {

        // Remove descrição padrão
        lineChart.getDescription().setEnabled(false);

        // Interações
        lineChart.setTouchEnabled(true);
        lineChart.setDragEnabled(true);
        lineChart.setScaleEnabled(false);
        lineChart.setPinchZoom(false);

        // Estilo geral
        lineChart.setDrawGridBackground(false);
        lineChart.setBackgroundColor(Color.TRANSPARENT);

        // Animação
        lineChart.animateX(800);

        // X Axis (dias da semana)
        XAxis xAxis = lineChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setDrawGridLines(false);
        xAxis.setGranularity(1f);
        xAxis.setTextColor(Color.DKGRAY);

        String[] dias = {"Dom", "Seg", "Ter", "Qua", "Qui", "Sex", "Sáb"};
        xAxis.setValueFormatter(new IndexAxisValueFormatter(dias));

        // Y Axis
        YAxis leftAxis = lineChart.getAxisLeft();
        leftAxis.setDrawGridLines(true);
        leftAxis.setTextColor(Color.DKGRAY);

        lineChart.getAxisRight().setEnabled(false);

        // Legenda
        Legend legend = lineChart.getLegend();
        legend.setEnabled(true);
        legend.setTextColor(Color.DKGRAY);
        legend.setForm(Legend.LegendForm.LINE);
    }

    private void loadChartData() {

        ArrayList<Entry> entradas = new ArrayList<>();

        entradas.add(new Entry(0, 300));
        entradas.add(new Entry(1, 700));
        entradas.add(new Entry(2, 500));
        entradas.add(new Entry(3, 900));
        entradas.add(new Entry(4, 600));
        entradas.add(new Entry(5, 800));
        entradas.add(new Entry(6, 400));

        LineDataSet dataSet = new LineDataSet(entradas, "Gastos da Semana");

        // Estilo da linha
        dataSet.setColor(Color.parseColor("#2ECC71"));
        dataSet.setLineWidth(3f);
        dataSet.setCircleColor(Color.parseColor("#27AE60"));
        dataSet.setCircleRadius(5f);
        dataSet.setDrawValues(false);
        dataSet.setMode(LineDataSet.Mode.CUBIC_BEZIER);
        dataSet.setDrawFilled(true);
        dataSet.setFillColor(Color.parseColor("#A5D6A7"));

        LineData lineData = new LineData(dataSet);

        lineChart.setData(lineData);
        lineChart.invalidate(); // atualiza gráfico
    }
    //botão para ir a MeusGastos
    public void vergastos (View v){
        Intent intent = new Intent(GraficoActivity.this, MeusGastos.class);
        startActivity(intent);
    }
    //Botão para ir a Cadastro Gasto
    public void addgastos(View v) {
        Intent intent = new Intent(GraficoActivity.this, CadastroGasto.class);
        startActivity(intent);
        finish();
    }

}