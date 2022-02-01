package com.example.calculator;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.application.Application;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;
import javafx.stage.Stage;


public class Calculator extends Application {

    private static TextField newlab = new TextField();



    public void Digitalize(Button newbtn, String sample)
    {
        newbtn.setMinSize(50,50);

        newbtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent click) {
                String s = newlab.getText();
                if(s != "" && s.charAt(0) == 'I')
                {
                    newlab.setText("");
                }
                newlab.setText(s+sample);
            }
        });
    }


    @Override
    public void start(Stage stage) throws Exception{



        Button add = new Button("+");
        Button sub = new Button("-");
        Button mol = new Button("x");
        Button div = new Button("÷");

        Button ac = new Button("AC");
        ac.setOnAction(new EventHandler<ActionEvent>() {
                           @Override
                           public void handle(ActionEvent click) {
                               newlab.setText("");
                           }
                       });
        ac.setMinSize(50,50);

        Button eq = new Button("=");
        eq.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent click) {
                String s = newlab.getText();
                String num1 = "";
                String num2 = "";
                char operand = ' ';

                int flag = 0;

                int f1;
                int f2;

                if(s.charAt(0) == '+' || s.charAt(0) == '-' || s.charAt(0) == 'x' || s.charAt(0) == '÷')
                {
                    newlab.setText("Invalid expression");
                }
                else if(s.charAt(s.length()-1) == '+' || s.charAt(s.length()-1) == '-' || s.charAt(s.length()-1) == 'x' || s.charAt(s.length()-1) == '÷')
                {
                    newlab.setText("Invalid expression");
                }
                else if(s.charAt(0) == 'I')
                {
                    newlab.setText("");
                }
                else {
                    for(char c: s.toCharArray())
                    {
                        if(Character.compare(c,'+') == 0 || Character.compare(c,'-') == 0 || Character.compare(c,'x') == 0 || Character.compare(c,'÷') == 0)
                        {
                            flag++;
                            operand = c;
                        }
                    }

                    if(flag > 1)
                    {
                        newlab.setText("Invalid expression, only one operation");
                    }
                    else if(flag == 0)
                    {
                        newlab.setText(newlab.getText());
                    }
                    else
                    {
                        flag = 0;
                        for(char c: s.toCharArray()) {
                            if ((Character.compare(c, '+') != 0 && Character.compare(c, '-') != 0 && Character.compare(c, 'x') != 0 && Character.compare(c, '÷') != 0) && flag == 0) {
                                num1 += c;
                            } else if ((Character.compare(c, '+') != 0 && Character.compare(c, '-') != 0 && Character.compare(c, 'x') != 0 && Character.compare(c, '÷') != 0) && flag == 1) {
                                num2 += c;
                            } else {
                                System.out.println(c);
                                flag = 1;
                            }
                        }
                        f1 = Integer.parseInt(num1);
                        f2 = Integer.parseInt(num2);
                        if(operand == '+')
                        {
                            f1 = f1+f2;
                            newlab.setText(String.valueOf(f1));
                        }
                        else if(operand == '-')
                        {
                            f1 = f1-f2;
                            newlab.setText(String.valueOf(f1));
                        }
                        else if(operand == 'x')
                        {
                            f1 = f1*f2;
                            newlab.setText(String.valueOf(f1));
                        }
                        else if(operand == '÷')
                        {
                            f1 = f1/f2;
                            newlab.setText(String.valueOf(f1));
                        }
                    }

                }
            }
        });
        eq.setMinSize(50,50);

        Button one = new Button("1");
        Button two = new Button("2");
        Button three = new Button("3");
        Button four = new Button("4");
        Button five = new Button("5");
        Button six = new Button("6");
        Button seven = new Button("7");
        Button eight = new Button("8");
        Button nine = new Button("9");
        Button zero = new Button("0");


        Digitalize(add,"+");
        Digitalize(sub,"-");
        Digitalize(mol,"x");
        Digitalize(div,"÷");
        Digitalize(one,"1");
        Digitalize(two,"2");
        Digitalize(three,"3");
        Digitalize(four,"4");
        Digitalize(five,"5");
        Digitalize(six,"6");
        Digitalize(seven,"7");
        Digitalize(eight,"8");
        Digitalize(nine,"9");
        Digitalize(zero,"0");




        VBox root = new VBox();


        HBox temp = new HBox();

        VBox digit = new VBox();
        VBox symbol = new VBox();

        newlab.setMinSize(200,60);

        temp.getChildren().addAll(digit,symbol);


        HBox digit_firstline = new HBox(one,two,three);
        HBox digit_secondline = new HBox(four,five,six);
        HBox digit_tirdline = new HBox(seven,eight,nine);
        HBox digit_fourthline = new HBox(zero);

        HBox symbol_firstline = new HBox(add,mol);
        HBox symbol_secondline = new HBox(sub,div);
        HBox symbol_tirdline = new HBox(ac,eq);

        root.setSpacing(10);


        digit.getChildren().addAll(digit_firstline,digit_secondline,digit_tirdline,digit_fourthline);



        symbol.getChildren().addAll(symbol_firstline,symbol_secondline,symbol_tirdline);

        digit_firstline.setAlignment(Pos.BASELINE_LEFT);
        digit_secondline.setAlignment(Pos.BASELINE_LEFT);
        digit_tirdline.setAlignment(Pos.BASELINE_LEFT);
        digit_fourthline.setAlignment(Pos.BASELINE_CENTER);

        symbol_firstline.setAlignment(Pos.BASELINE_RIGHT);
        symbol_secondline.setAlignment(Pos.BASELINE_RIGHT);
        symbol_tirdline.setAlignment(Pos.BASELINE_RIGHT);


        newlab.setAlignment(Pos.TOP_CENTER);
        newlab.fontProperty();


        digit.setAlignment(Pos.CENTER_LEFT);
        symbol.setAlignment(Pos.TOP_RIGHT);

        root.getChildren().addAll(newlab,temp);

        Scene scene = new Scene(root,250,270);


        stage.setTitle("Calculator");

        stage.setScene(scene);

        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}