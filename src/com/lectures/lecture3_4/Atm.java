package com.lectures.lecture3_4;

/**
 * Класс описывающий банкомат
 * оперирующий тремя номиналами купюр 20, 50, 100
 * Содержит методы для дозагрузки купюр трех номиналов setCash,
 * а также снятия наличных cashOut.
 */
    public class Atm {
        int NominalOf20;
        int NominalOf50;
        int NominalOf100;
        public Atm(){       //конструктор по умолчанию
        }
        public Atm (int nominalOf20, int nominalOf50, int nominalOf100){ //конструктор с параметрами
            NominalOf20=nominalOf20;
            NominalOf50=nominalOf50;
            NominalOf100=nominalOf100;
        }
        public void setCash(int sum20,int sum50,int sum100) { // метод для до загрузки купюр в банкомат
            NominalOf20+=sum20;
            NominalOf50+=sum50;
            NominalOf100+=sum100;
        }

        public boolean cashOut(int summa) { //метод выдачи наличных
            if ((summa%10!=0)) {
                return false;
            }
            if (calcNaminal(summa)){
                return true;
            } else return false;
        }

        public boolean calcNaminal(int sumCash) { // метод расчета номиналов при выдачи купюр, с учетом их наличия в банкомате
            int num20=0;
            int num50=0;
            int num100=0;
            int var=0;
            if (NominalOf20*20+NominalOf50*50+NominalOf100*100>=sumCash) {
                for (num20=0;num20<=NominalOf20;num20++){
                    for (num50=0;num50<=NominalOf50;num50++) {
                        for (num100=0;num100<=NominalOf100;num100++) {
                            var=num20*20+num50*50+num100*100;
                            if (var==sumCash){
                                break;
                            }
                        }
                        if(var==sumCash) {
                            break;
                        }
                    }
                    if (var==sumCash) {
                        break;
                    }
                }
            } else return false;
            System.out.println("Сумма будет выдана:"+"\nКоличество купюр номиналом 100: "+num100);
            System.out.println("Количество купюр номиналом 50: "+num50);
            System.out.println("Количество купюр номиналом 20: "+num20);
            return true;
        }
    }
