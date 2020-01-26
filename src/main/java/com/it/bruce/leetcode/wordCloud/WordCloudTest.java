package com.it.bruce.leetcode.wordCloud;

import com.kennycason.kumo.CollisionMode;
import com.kennycason.kumo.WordCloud;
import com.kennycason.kumo.WordFrequency;
import com.kennycason.kumo.bg.CircleBackground;
import com.kennycason.kumo.font.KumoFont;
import com.kennycason.kumo.font.scale.LinearFontScalar;
import com.kennycason.kumo.nlp.FrequencyAnalyzer;
import com.kennycason.kumo.nlp.tokenizers.ChineseWordTokenizer;
import com.kennycason.kumo.palette.LinearGradientColorPalette;

import java.awt.*;
import java.io.IOException;
import java.util.List;


public class WordCloudTest {
    public static void main(String[] args) throws IOException {
        //建立词频分析器，设置词频，以及词语最短长度，此处的参数配置视情况而定即可
        FrequencyAnalyzer frequencyAnalyzer = new FrequencyAnalyzer();
        frequencyAnalyzer.setWordFrequenciesToReturn(600);
        frequencyAnalyzer.setMinWordLength(2);
        //引入中文解析器
        frequencyAnalyzer.setWordTokenizer(new ChineseWordTokenizer());
        final List<WordFrequency> wordFrequencies = frequencyAnalyzer.load("D:\\job.txt");
        Dimension dimension = new Dimension(1920, 1080);
        WordCloud wordCloud = new WordCloud(dimension, CollisionMode.RECTANGLE);
        wordCloud.setPadding(0);
        java.awt.Font font = new java.awt.Font("STSong-Light", 2, 40);
        wordCloud.setBackgroundColor(new Color(255, 255, 255));
        wordCloud.setKumoFont(new KumoFont(font));
//        wordCloud.setBackground(new RectangleBackground(dimension));
        wordCloud.setBackground(new CircleBackground(255));
//        wordCloud.setBackground(new PixelBoundryBackground("D:\\lufei.jpg"));
        wordCloud.setColorPalette(new LinearGradientColorPalette(Color.RED, Color.BLUE, Color.GREEN, 30, 30));
        wordCloud.setFontScalar(new LinearFontScalar(10, 40));
        wordCloud.build(wordFrequencies);
        wordCloud.writeToFile("D:\\job.png");
    }
}
