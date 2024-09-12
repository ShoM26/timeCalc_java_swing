import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.event.ActionListener;

public class Calculator {
    //Variable Creation
    private int hours;
    private int minutes;
    private int seconds;
    private int decimal;
    //End Variable Creation

    public Calculator(){

    }
    public Calculator(int hr, int min, int sec, int dec){
        hours = hr;
        minutes = min;
        seconds = sec;
        decimal = dec;
    }

    //Getters
    public int getHours(){
        return hours;
    }

    public int getMinutes(){
        return minutes;
    }

    public int getSeconds(){
        return seconds;
    }

    public int getDecimal(){
        return decimal;
    }



    //Setters
    public void setHours(int newValue){
        hours = newValue;
    }
    public void setMinutes(int newValue){
        minutes = newValue;
    }
    public void setSeconds(int newValue){
        seconds = newValue;
    }
    public void setDecimal(int newValue){
        decimal = newValue;
    }



    //Addition
    public Calculator addition(Calculator timeOne, Calculator timeTwo){
        Calculator finalTime = new Calculator();
        finalTime.setHours(timeOne.getHours()+timeTwo.getHours());
        finalTime.setMinutes(timeOne.getMinutes()+timeTwo.getMinutes());
        finalTime.setSeconds(timeOne.getSeconds()+ timeTwo.getSeconds());
        finalTime.setDecimal(timeOne.getDecimal()+ timeTwo.getDecimal());
        if(finalTime.getDecimal() >= 100){
            finalTime.setDecimal(finalTime.getDecimal()%100);
            finalTime.setSeconds(finalTime.getSeconds()+1);
        }
        if(finalTime.getSeconds() >= 60){
            finalTime.setSeconds(finalTime.getSeconds()%60);
            finalTime.setMinutes(finalTime.getMinutes()+1);
        }
        if(finalTime.getMinutes() >= 60){
            finalTime.setMinutes(finalTime.getMinutes()%60);
            finalTime.setHours(finalTime.getHours()+1);
        }
        return finalTime;
    }

    //Subtraction

    public Calculator subtraction(Calculator timeOne, Calculator timeTwo){
        Calculator errorCalc = new Calculator(-1,-1,-1,-1);
        Calculator finalTime = new Calculator();
        //Begin subtraction of the decimals
        if(timeOne.getDecimal() < timeTwo.getDecimal()){
            if(timeOne.getSeconds() == 0){
                if(timeOne.getMinutes() == 0){
                    if(timeOne.getHours() == 0){
                        return errorCalc;
                    }
                    else{
                        timeOne.setHours(timeOne.getHours()-1);
                        timeOne.setMinutes(timeOne.getMinutes()+60);
                        timeOne.setMinutes(timeOne.getMinutes()-1);
                        timeOne.setSeconds(timeOne.getSeconds()+60);
                        timeOne.setSeconds(timeOne.getSeconds()-1);
                        timeOne.setDecimal(timeOne.getDecimal()+100);
                        finalTime.setDecimal(timeOne.getDecimal()- timeTwo.getDecimal());
                    }
                }
                else{
                    timeOne.setMinutes(timeOne.getMinutes()-1);
                    timeOne.setSeconds(timeOne.getSeconds()+60);
                    timeOne.setSeconds(timeOne.getSeconds()-1);
                    timeOne.setDecimal(timeOne.getDecimal()+100);
                    finalTime.setDecimal(timeOne.getDecimal()- timeTwo.getDecimal());
                }
            }
            else{
                timeOne.setSeconds(timeOne.getSeconds()-1);
                timeOne.setDecimal(timeOne.getDecimal()+100);
                finalTime.setDecimal(timeOne.getDecimal()- timeTwo.getDecimal());
            }
        }
        else{
            finalTime.setDecimal(timeOne.getDecimal()- timeTwo.getDecimal());
        }

        //End subtraction of the decimals

        //Begin subtraction of the seconds
        if(timeOne.getSeconds() < timeTwo.getSeconds()){
            if(timeOne.getMinutes() == 0){
                if(timeOne.getHours() == 0){
                    return errorCalc;
                }
                else{
                    timeOne.setHours(timeOne.getHours()-1);
                    timeOne.setMinutes(timeOne.getMinutes()+60);
                    timeOne.setMinutes(timeOne.getMinutes()-1);
                    timeOne.setSeconds(timeOne.getSeconds()+60);
                    finalTime.setSeconds(timeOne.getSeconds()- timeTwo.getSeconds());
                }
            }
            else{
                timeOne.setMinutes(timeOne.getMinutes()-1);
                timeOne.setSeconds(timeOne.getSeconds()+60);
                finalTime.setSeconds(timeOne.getSeconds()- timeTwo.getSeconds());
            }
        }
        else{
            finalTime.setSeconds(timeOne.getSeconds()- timeTwo.getSeconds());
        }
        //End the subtraction of the seconds

        //Start the subtraction of minutes
        if(timeOne.getMinutes() < timeTwo.getMinutes()){
            if(timeOne.getHours() == 0){
                return errorCalc;
            }
            else{
                timeOne.setHours(timeOne.getHours()-1);
                timeOne.setMinutes(timeOne.getMinutes()+60);
                finalTime.setMinutes(timeOne.getMinutes()- timeTwo.getMinutes());
            }
        }
        else{
            finalTime.setMinutes(timeOne.getMinutes()- timeTwo.getMinutes());
        }
        //End the subtraction of minutes

        //Start the subtraction of hours
        if(timeOne.getHours() < timeTwo.getHours()){
            return errorCalc;
        }
        else{
            finalTime.setHours(timeOne.getHours()- timeTwo.getHours());
        }
        //End the subtraction of hours

        return finalTime;
    }

    public Calculator multiplication(Calculator time, int numeral){
        Calculator finalTime = new Calculator();
        int temp;
        finalTime.setHours(time.getHours()*numeral);
        finalTime.setMinutes(time.getMinutes()*numeral);
        finalTime.setSeconds(time.getSeconds()*numeral);
        finalTime.setDecimal(time.getDecimal()*numeral);

        temp = finalTime.getDecimal()/100;
        finalTime.setDecimal(finalTime.getDecimal()%100);
        finalTime.setSeconds(finalTime.getSeconds()+temp);
        temp = finalTime.getSeconds()/60;
        finalTime.setSeconds(finalTime.getSeconds()%60);
        finalTime.setMinutes(finalTime.getMinutes()+temp);
        temp = finalTime.getMinutes()/60;
        finalTime.setMinutes(finalTime.getMinutes()%60);
        finalTime.setHours(finalTime.getHours()+temp);
        return finalTime;
    }
    public Calculator division(Calculator time, int numeral){
        Calculator finalTime = new Calculator();
        int totalHundredths = 0;

        totalHundredths += time.getHours()*360000;
        totalHundredths += time.getMinutes()*6000;
        totalHundredths += time.getSeconds()*100;
        totalHundredths += time.getDecimal();

        totalHundredths = totalHundredths/numeral;


        finalTime.setHours(totalHundredths/360000);
        totalHundredths = totalHundredths%360000;
        finalTime.setMinutes(totalHundredths/6000);
        totalHundredths = totalHundredths%6000;
        finalTime.setSeconds(totalHundredths/100);
        totalHundredths = totalHundredths%100;
        finalTime.setDecimal(totalHundredths);

        return finalTime;
    }


    public void display(Calculator c){
        System.out.println("Hrs: " + c.getHours() + " Mins: " + c.getMinutes() + " Sec: " + c.getSeconds());
    }





}
