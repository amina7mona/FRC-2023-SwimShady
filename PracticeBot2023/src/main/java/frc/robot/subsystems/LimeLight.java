// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.cscore.HttpCamera;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

public class LimeLight extends SubsystemBase {
  NetworkTable table;
  NetworkTableEntry tx;
  NetworkTableEntry ty;
  double x;
  double y;
  boolean inRange;
  double targetHeight = 7;// Change when nessesary
  double targetDistance;
  double angletoRad;

  HttpCamera httpCamera;


  /** Creates a new LimeLight. */
  public LimeLight() {
    table = NetworkTableInstance.getDefault().getTable("limelight");
    NetworkTableEntry ledMode = table.getEntry("ledMode");
    ledMode.setDouble(1);
    NetworkTableEntry camMode = table.getEntry("camMode");
    camMode.setDouble(1);

    /*
    String url = SmartDashboard.getString("limelight_Stream", "http://10.3.33.219:5800");
    httpCamera = new HttpCamera("LimelightCamera", url+"/stream.mjpg", HttpCameraKind.kMJPGStreamer);
    CameraServer.addCamera(httpCamera);
    */
    
    //NetworkTableEntry stream_url = table.getEntry("source");
    //SmartDashboard.putString("LLightStreamUrl", stream_url.getString(""));
    //table.putValue("ledMode", NetworkTableValue.makeInteger(1));
    //tx = table.getEntry("tx");
    //ty = table.getEntry("ty");

  }

  @Override
  public void periodic() {

    /*
    x = tx.getDouble(0); // Max value : 24
    y = ty.getDouble(0); // Max value : 27
    // Get's x and y values

    angletoRad = Math.toRadians(y);

    targetDistance = (targetHeight / Math.tan(angletoRad));

    if ((targetDistance < 35) || (targetDistance > 36 && targetDistance < 41)) {
      if(x > -7 && x < 7) // ADJUST THESE VALUES IN ORDER TO INCREASE ACCURANCY FOR ALIGNMENT. REQUIRES AT LEAST A 7 DEGREE TOLERANCE AREA.
      {
        inRange = true;
      }
      inRange = false;
    } else {
      inRange = false;
    }
    
    //SmartDashboard.putNumber("LimelightXangle", x);
    //SmartDashboard.putNumber("LimelightYangle", y);
    //SmartDashboard.putNumber("LimeLightDistance", targetDistance);//distance in inches
    //SmartDashboard.putBoolean("Is_In_Range", inRange);
    */
  }
}
