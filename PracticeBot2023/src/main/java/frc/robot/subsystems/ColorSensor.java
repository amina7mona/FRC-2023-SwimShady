package frc.robot.subsystems;
// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

import edu.wpi.first.wpilibj.Joystick;
import frc.robot.subsystems.LEDStrip.FancyLED;

public class ColorSensor {
  Joystick joy;
  LEDStrip strip;

  final int NUMBER_OF_LEDS = 103;

  public ColorSensor(){
    strip = new LEDStrip(1, NUMBER_OF_LEDS);
    joy = new Joystick(0);
  }

  boolean cone = true;
  boolean teleop = false;
  boolean off = false;

  public void setTeleop(boolean teleop){
    this.teleop = teleop;
  }
  
  public void periodic(){
    if(teleop){
      if(joy.getRawButton(5)){
        cone = true;
        off = false;
      }else if(joy.getRawButton(3)){
        cone = false;
        off = false;
      }else if (joy.getRawButton(4)){
        strip.set(0,0,0);
        off = true;
      }
      if (off){
        strip.set(0,0,0);
      } else{
        if(!cone){
          strip.set(106, 13,173);//cube
        }else{
          strip.set(40, 20, 0);//cone
        }
      }
    }else{
      //strip.setFancyDualLayer(FancyLED.PULSE, 0,0,100,150,20,1);
      strip.setFancyDualLayer(FancyLED.PULSE, 0,0,0,0,0,0);
    }
  }
}