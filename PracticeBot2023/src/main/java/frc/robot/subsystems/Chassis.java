// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Chassis extends SubsystemBase {
  /** Creates a new Chassis. */
  CANSparkMax rightmotor1, rightmotor2, rightmotor3;
  CANSparkMax leftmotor1, leftmotor2, leftmotor3;
  MotorControllerGroup rightleader;
  MotorControllerGroup leftleader;
  DifferentialDrive drive;

  public Chassis() {
    rightmotor1  = new CANSparkMax(1, MotorType.kBrushless);
    rightmotor2  = new CANSparkMax(2, MotorType.kBrushless);
    rightmotor3  = new CANSparkMax(3, MotorType.kBrushless);

    rightleader = new MotorControllerGroup(rightmotor1, rightmotor2, rightmotor3);

    leftmotor1 = new CANSparkMax(4, MotorType.kBrushless);
    leftmotor2 = new CANSparkMax(5, MotorType.kBrushless);
    leftmotor3 = new CANSparkMax(6, MotorType.kBrushless);

    leftleader = new MotorControllerGroup(leftmotor1, leftmotor2, leftmotor3);
    drive = new DifferentialDrive(leftleader, rightleader);
  }

  public void drive(double speed, double rotation) {
    drive.arcadeDrive(speed, rotation);
  }
}
