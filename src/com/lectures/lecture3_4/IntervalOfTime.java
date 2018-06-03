package com.lectures.lecture3_4;

/**
 * Класс описывающий интервал времени в виде ЧЧ ММ СС
 * имеет возможность задания интервала в общем количестве секунд,
 * а также тремя параметрами часы, минуты, секунды.
 * Имеет методы возврата времени в общем количестве секунд,
 * а также в формате ЧЧ ММ СС
 */
public class IntervalOfTime {
    int Seconds;
    int Minutes;
    int Hours;

    public IntervalOfTime (int sec){
        Seconds=sec;
    }// конструктор для задания интервала времени в секундах
    public IntervalOfTime (int sec,int min,int hour) { // конструктор задает интервал времени в 3-х параметрах:часы,мин,сек
        Seconds = sec;
        Minutes = min;
        Hours = hour;
    }
    public int getSec() { // метод возвращающий интервал времени в секундах (общее количество)
        int timeInSeconds=Hours*3600+Minutes*60+Seconds;
        return timeInSeconds;
    }

    public void setInSec(int sec) { // метод для задания интервала времени только секундах
        Hours=sec/60/60;
        Minutes=(sec/60)%60;
        Seconds = sec-Hours*3600-Minutes*60;
    }

    public String getTime() { // метод для получения интервала времени в формате ЧЧ ММ СС
        String time=new String();
        if (Seconds>=60) {
            Minutes+=Seconds/60;
            Seconds=Seconds%60;
        }
        if (Minutes>=60) {
            Hours+=Minutes/60;
            Minutes=Minutes%60;
        }
        time=Hours+":"+Minutes+":"+Seconds;
        return time;
    }
}


